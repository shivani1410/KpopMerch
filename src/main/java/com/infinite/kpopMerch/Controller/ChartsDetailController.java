package com.infinite.kpopMerch.Controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinite.kpopMerch.Service.AlbumDetailsService;
import com.infinite.kpopMerch.Service.OrderDetailsService;

@RestController
public class ChartsDetailController {
	@Autowired
	OrderDetailsService orderDetailsService;
	@Autowired
	AlbumDetailsService albumDetailsService;

	@GetMapping(path = "/getTopCharts", produces = "application/json")
	public String getNewAlbums() throws JsonProcessingException, ParseException {
		List<String> output = orderDetailsService.findMaxCountAlbums();
		JSONParser parser = new JSONParser();
		JSONArray jArrayFinal = new JSONArray();
		for (String id : output) {
			JSONObject json = new JSONObject();
			String[] res = id.split(",");
			System.out.println("id---  " + res[0]);
			System.out.println("count---  " + res[0]);
			System.out.println("val---  " + id);
			String albumDetails = albumDetailsService.getAlbumById(res[0]);
			json = (JSONObject) parser.parse(albumDetails);

			System.out.println("album-----------------" + albumDetails);
			String albumName = json.get("albumName").toString();
			JSONObject json1 = new JSONObject();
//			json1.put
			json.put("count", res[1]);
			jArrayFinal.add(json);
		}
//		String jsonString = "";
//		ObjectMapper mapper = new ObjectMapper();
//		jsonString = mapper.writeValueAsString(output);
//		System.out.println("jsonString-------------------  " + jsonString);
//		return jsonString;
		String jsonStringFinal = "";

		jsonStringFinal = jArrayFinal.toString();
		System.out.println("jsonString-------------------  " + jsonStringFinal);
		return jsonStringFinal;
	}
}
