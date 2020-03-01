package com.irms_service.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irms_service.entity.MiscConfig;
import com.irms_service.repository.MiscConfigRepository;

@Service
@Transactional
public class MiscConfigService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MiscConfigService.class);

	@Autowired
	MiscConfigRepository miscConfigRepository;
	
	public List<MiscConfig>  getAllMiscData(){
		LOGGER.info("Fetching all misc data");
		return miscConfigRepository.findAll();
	}
	
	public void addMiscConfig(MiscConfig data) {
		LOGGER.info("Indsering new misc data: " + data);
		miscConfigRepository.save(data);
		LOGGER.info("Misc data saved");
	}
	
	public Map<String, List<MiscConfig>> getValues(String tag){
		List<MiscConfig> configList = miscConfigRepository.findAll();
		return configList.stream().collect(Collectors.groupingBy(MiscConfig :: getConfigType));
		
	}
}
