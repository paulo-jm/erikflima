package com.guusto.mapping.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guusto.exception.GuustoException;
import com.guusto.exception.GuustoRuntimeException;

public class ObjectMapperUtils {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static <T> T readValue(String json, Class<T> clazz) throws GuustoException {

		if (StringUtils.isNotBlank(json) && clazz != null) {
			try {
				return (T) OBJECT_MAPPER.readValue(json, clazz);
			} catch (IOException e) {
				throw new GuustoException(e.getMessage(), e);
			}
		}
		return null;

	}

	public static Map<String, Object> readValueMetadata(String metadata) {

		if (StringUtils.isNotBlank(metadata)) {
			try {
				return OBJECT_MAPPER.readValue(metadata, new TypeReference<Map<String, Object>>() {
				});
			} catch (IOException e) {
				throw new GuustoRuntimeException(e.getMessage(), e);
			}
		}
		return null;

	}

	public static String writeValueMetadata(Map<String, Object> metadata) {

		if (metadata != null && !metadata.isEmpty()) {
			try {
				return OBJECT_MAPPER.writeValueAsString(metadata);
			} catch (IOException e) {
				throw new GuustoRuntimeException(e.getMessage(), e);
			}
		}
		return null;

	}

}
