package com.irms_service.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.irms_service.entity.DBFile;
import com.irms_service.repository.DBFileRepository;

@Service
public class FileService {

	@Value("${irmsService.uploadToDB}")
	private boolean uploadToDb;
	
	@Value("${irmsService.uploadLocation}")
	private String uploadLoc;
	
	@Autowired
	private DBFileRepository repository;
	
	public DBFile saveFile(MultipartFile file) throws IOException {
		if (uploadToDb) {
			return saveFileToDB(file);
		} else {
			return saveFileToFileSystem(file);
		}
	}

	private DBFile saveFileToFileSystem(MultipartFile file) throws IOException {
		DBFile f = new DBFile();
		f.setData(file.getBytes());
        Path path = Paths.get(uploadLoc + file.getOriginalFilename());
		f.setFilename(file.getOriginalFilename());
		f.setFiletype(file.getContentType());
		f.setFilepath(path.toString());
        Files.write(path, f.getData());
        return f;
	}

	private DBFile saveFileToDB(MultipartFile file) throws IOException {
		DBFile f = new DBFile();
		f.setData(file.getBytes());
		f.setFilename(file.getOriginalFilename());
		f.setFiletype(file.getContentType());
		return repository.save(f);
	}

}
