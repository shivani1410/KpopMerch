package com.infinite.kpopMerch.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.input.BoundedInputStream;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Config {

	public JSONObject covertInputStream(InputStream inputStream) throws IOException {
		StringBuilder strbldr = new StringBuilder(64000);

		try (BoundedInputStream boundedInput = new BoundedInputStream(inputStream, 4096);
				BufferedReader br = new BufferedReader(new InputStreamReader(boundedInput), 2048)) {
			String line = null;
			while ((line = br.readLine()) != null) {
				strbldr.append(line);
			}
		}
		JSONObject obj = new JSONObject(strbldr.toString());
		return obj;

	}

	public org.json.simple.JSONObject convertToJSON(String value) throws ParseException {
		JSONParser parser = new JSONParser();
		org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(value);
		return jsonObject;
	}
}
