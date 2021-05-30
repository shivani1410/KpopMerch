package com.infinite.kpopMerch.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Models.album_details;
import com.infinite.kpopMerch.Service.AlbumDetailsService;
import com.infinite.kpopMerch.Utils.Config;

@RestController
public class AlbumDetailsController {
	@Autowired
	AlbumDetailsService albumDetailsService;

	@GetMapping(path = "/getNewAlbums", produces = "application/json")
	public String getNewAlbums() throws JsonProcessingException, ParseException {
		List<album_details> output = albumDetailsService.getNewAlbums();

		String jsonString = "";
		ObjectMapper mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(output);
		JSONParser parser = new JSONParser();

		JSONArray jArray = (JSONArray) parser.parse(jsonString);

		JSONArray jArrayFinal = new JSONArray();
		JSONArray jArray1;
//		System.out.println(jArray.size());
		for (int i = 0; i < 1; i++) {

			for (int j = 0; j < jArray.size(); j++) {
				JSONObject json = new JSONObject();
				jArray1 = (JSONArray) parser.parse(jArray.get(j).toString());

				String albumId = jArray1.get(0).toString();
				String albumName = jArray1.get(1).toString();
				String releaseDate = jArray1.get(2).toString();
				String albumCover = jArray1.get(3).toString();
				String artistName = jArray1.get(4).toString();
				json.put("albumId", albumId);
				json.put("albumName", albumName);
				json.put("releaseDate", releaseDate);
				json.put("albumCover", albumCover);
				json.put("artistName", artistName);

				jArrayFinal.add(json);

			}
		}
		String jsonStringFinal = "";

		jsonStringFinal = jArrayFinal.toString();
		return jsonStringFinal;

	}

	@PostMapping(path = "/getAlbumById", consumes = "application/json", produces = "application/json")
	public String getAlbumById(InputStream inputStream) throws IOException, ParseException {
		Config config = new Config();
		org.json.JSONObject obj = config.covertInputStream(inputStream);
		String id = obj.getString("id");
		System.out.println(id);
		String albumDetails = albumDetailsService.getAlbumById(id);

		return albumDetails;
	}

	@PostMapping(path = "/getAlbumByName", consumes = "application/json", produces = "application/json")
	public String getAlbumByName(InputStream inputStream) throws IOException, ParseException {
		Config config = new Config();
		org.json.JSONObject obj = config.covertInputStream(inputStream);
		String search = obj.getString("search");

		System.out.println(search);
		List<album_details> output = albumDetailsService.getAlbumByName(search);
		String jsonString = "";
		ObjectMapper mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(output);
		JSONParser parser = new JSONParser();

		JSONArray jArray = (JSONArray) parser.parse(jsonString);

		JSONArray jArrayFinal = new JSONArray();
		JSONArray jArray1;
//		System.out.println(jArray.size());
		for (int i = 0; i < 1; i++) {

			for (int j = 0; j < jArray.size(); j++) {
				JSONObject json = new JSONObject();
				jArray1 = (JSONArray) parser.parse(jArray.get(j).toString());

				String albumId = jArray1.get(0).toString();
				String albumName = jArray1.get(1).toString();
//				String releaseDate = jArray1.get(2).toString();
//				String albumCover = jArray1.get(3).toString();
				String artistName = jArray1.get(2).toString();
				json.put("albumId", albumId);
				json.put("albumName", albumName);

				json.put("artistName", artistName);

				jArrayFinal.add(json);

			}
		}
		String jsonStringFinal = "";

		jsonStringFinal = jArrayFinal.toString();
		return jsonStringFinal;
	}

	@PostMapping(path = "/getAlbumByArtistId", consumes = "application/json", produces = "application/json")
	public String getAlbumByArtistId(InputStream inputStream) throws IOException, ParseException {
		Config config = new Config();
		org.json.JSONObject obj = config.covertInputStream(inputStream);
		String search = obj.getString("artistId");

		System.out.println(search);
		List<album_details> output = albumDetailsService.getAlbumByArtistId(search);
		String jsonString = "";
		ObjectMapper mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(output);
		JSONParser parser = new JSONParser();

		JSONArray jArray = (JSONArray) parser.parse(jsonString);

		JSONArray jArrayFinal = new JSONArray();
		JSONArray jArray1;
//		System.out.println(jArray.size());
		for (int i = 0; i < 1; i++) {

			for (int j = 0; j < jArray.size(); j++) {
				JSONObject json = new JSONObject();
				jArray1 = (JSONArray) parser.parse(jArray.get(j).toString());

				String albumId = jArray1.get(0).toString();
				String albumName = jArray1.get(1).toString();
				String releaseDate = jArray1.get(2).toString();
				String albumCover = jArray1.get(3).toString();
				String artistName = jArray1.get(4).toString();
				json.put("albumId", albumId);
				json.put("albumName", albumName);
				json.put("releaseDate", releaseDate);
				json.put("albumCover", albumCover);
				json.put("artistName", artistName);

				jArrayFinal.add(json);

			}
		}
		String jsonStringFinal = "";

		jsonStringFinal = jArrayFinal.toString();
		return jsonStringFinal;
	}

	@GetMapping(path = "/getAllAlbums", produces = "application/json")
	public String getAllAlbums() throws JsonProcessingException, ParseException {
		List<album_details> output = albumDetailsService.getAllAlbum();

		String jsonString = "";
		ObjectMapper mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(output);
		JSONParser parser = new JSONParser();

		JSONArray jArray = (JSONArray) parser.parse(jsonString);

		JSONArray jArrayFinal = new JSONArray();
		JSONArray jArray1;
//		System.out.println(jArray.size());
		for (int i = 0; i < 1; i++) {

			for (int j = 0; j < jArray.size(); j++) {
				JSONObject json = new JSONObject();
				jArray1 = (JSONArray) parser.parse(jArray.get(j).toString());

				String albumId = jArray1.get(0).toString();
				String albumName = jArray1.get(1).toString();
				String releaseDate = jArray1.get(2).toString();
				String albumCover = jArray1.get(3).toString();
				String artistName = jArray1.get(4).toString();
				json.put("albumId", albumId);
				json.put("albumName", albumName);
				json.put("releaseDate", releaseDate);
				json.put("albumCover", albumCover);
				json.put("artistName", artistName);

				jArrayFinal.add(json);

			}
		}
		String jsonStringFinal = "";

		jsonStringFinal = jArrayFinal.toString();
		return jsonStringFinal;

	}

}
