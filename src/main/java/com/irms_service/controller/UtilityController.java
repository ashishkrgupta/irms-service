package com.irms_service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irms_service.entity.MiscConfig;
import com.irms_service.service.MiscConfigService;

@RestController
@RequestMapping("/config")
public class UtilityController {

	@Autowired
	MiscConfigService miscConfigService;
	
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
}
