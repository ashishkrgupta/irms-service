package com.irms_service.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.irms_service.entity.MiscConfig;
import com.irms_service.service.MiscConfigService;

@RestController
@RequestMapping("/util")
public class UtilityController {

	@Autowired
	MiscConfigService miscConfigService;
	
	@Value("${irms-service.upload-location}")
	private String uploadLoc;
	
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
	public ResponseEntity<Map<String, String>> uploadFile(@RequestPart("file") MultipartFile file,
			@RequestPart("meta") String meta) {
		System.out.println(meta);
		//for (MultipartFile file : files) {
			try {
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(uploadLoc + file.getOriginalFilename());
	            
	            Files.write(path, bytes);


	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		//}
		
		return null;
	}
}
