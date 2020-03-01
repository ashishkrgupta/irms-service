package com.irms_service.entity;

import java.io.Serializable;

public class MiscId implements Serializable{

	private static final long serialVersionUID = 1L;

	String configType;

	String id;

	public String getConfigType() {
		return configType;
	}

	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
