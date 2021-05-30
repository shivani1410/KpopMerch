package com.infinite.kpopMerch.Controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Models.season_greeting;
import com.infinite.kpopMerch.Service.SeasonGreetingsService;

@RestController
public class SeasonGreetingsController {
	@Autowired
	SeasonGreetingsService seasonGreetingsService;

	@PostMapping(path = "/getAllSeason", produces = "application/json")
	public String getAllSeasonGreeting(@RequestParam("offset") int offset ) throws JsonProcessingException, ParseException {
		System.out.println("offset--------------------"+offset);
		List<season_greeting> output = seasonGreetingsService.getAllSeasonGreeting(offset);

		String jsonString = "";
		ObjectMapper mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(output);
		JSONParser parser = new JSONParser();

		JSONArray jArray = (JSONArray) parser.parse(jsonString);

		JSONArray jArrayFinal = new JSONArray();
		JSONArray jArray1;
//		
		for (int i = 0; i < 1; i++) {

			for (int j = 0; j < jArray.size(); j++) {
				JSONObject json = new JSONObject();

				json=(JSONObject) parser.parse(jArray.get(j).toString());
			
			JSONObject jsonArtist = new JSONObject();
			jsonArtist=(JSONObject) json.get("artist");
			
				String sgId = json.get("sg_id").toString();
				
				String sgImg = json.get("sg_img").toString();
				String price = json.get("price").toString();
				String artistName = jsonArtist.get("artistname").toString();
				JSONObject jsonFinal = new JSONObject();
				jsonFinal.put("sgId", sgId);
				jsonFinal.put("sgImg", sgImg);
				jsonFinal.put("price", price);

				jsonFinal.put("artistName", artistName);

				jArrayFinal.add(jsonFinal);

			}
		}
		String jsonStringFinal = "";

		jsonStringFinal = jArrayFinal.toString();
		System.out.println(jsonStringFinal + "---------------------seasonGreeting");
		return jsonStringFinal;

	}

}
