package com.irms_service.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.irms_service.entity.DBFile;
import com.irms_service.entity.MiscConfig;
import com.irms_service.service.FileService;
import com.irms_service.service.MiscConfigService;

@RestController
@RequestMapping("/util")
public class UtilityController {

	@Autowired
	MiscConfigService miscConfigService;
	
	@Autowired
	private FileService fileService;
	
	
	@GetMapping
	public List<MiscConfig> getConfigurations() {
		return miscConfigService.getAllMiscData();
	}
	
	@PutMapping
	public void addData(@RequestBody MiscConfig data) {
		miscConfigService.addMiscConfig(data);
	}
	
	@GetMapping(value = "/{type}")
	public Map<String, List<MiscConfig>>  getValues(@PathVariable("type") String tag){
		return miscConfigService.getValues(tag);
	}
	
	@PostMapping(value = "/upload", consumes = "multipart/form-data")
	public List<DBFile> uploadFile(@RequestParam("file") MultipartFile[] files) throws IOException {
		List<DBFile> savedFiles = new ArrayList<>();
		for (MultipartFile file : files) {
			try {
				savedFiles.add(fileService.saveFile(file));
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}
		return savedFiles;
	}
}
