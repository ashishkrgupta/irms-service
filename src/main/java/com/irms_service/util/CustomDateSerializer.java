package com.irms_service.util;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

public class CustomDateSerializer extends DateDeserializer{
	
	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		// TODO Auto-generated method stub
		return super.deserialize(p, ctxt);
	}

}
