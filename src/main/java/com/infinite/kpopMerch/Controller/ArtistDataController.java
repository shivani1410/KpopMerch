package com.infinite.kpopMerch.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

import org.apache.commons.io.input.BoundedInputStream;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinite.kpopMerch.Models.ArtistImage;
import com.infinite.kpopMerch.Repository.ArtistImgRepo;
import com.infinite.kpopMerch.Service.ArtistService;

/**
 * 
 * @author Infinite This class is controller for all the Fetch operations of
 *         Artist
 *
 */
@RestController
public class ArtistDataController {
	@Autowired
	ArtistService artistService;
	@Autowired
	ArtistImgRepo artistImgRepo;

	/**
	 * Returns the Data of all the Artists
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@GetMapping(path = "/getAllArtists", produces = "application/json")
	public String getAllArtists() throws JsonProcessingException {
		String output = "";
		output = artistService.getAllArtists();
		return output;
	}

	@PostMapping(path = "/getArtistByName", consumes = "application/json", produces = "application/json")
	public String getArtistByName(InputStream inputStream) throws IOException {
		StringBuilder strbldr = new StringBuilder(64000);
		String data = null;
		String output = null;
		try (BoundedInputStream boundedInput = new BoundedInputStream(inputStream, 4096);
				BufferedReader br = new BufferedReader(new InputStreamReader(boundedInput), 2048)) {
			String line = null;
			while ((line = br.readLine()) != null) {
				strbldr.append(line);
			}
			JSONObject obj = new JSONObject(strbldr.toString());

			data = obj.toString();
			System.out.println(data);
			output = artistService.getArtistByName(obj.get("artistname").toString());
		}
		return output;
	}

	@PostMapping(path = "/getArtistImageByName", consumes = "application/json", produces = "application/json")
	public ArtistImage getArtistImageByName(InputStream inputStream) throws IOException {
		StringBuilder strbldr = new StringBuilder(64000);
		String data = null;
		String output = null;
		try (BoundedInputStream boundedInput = new BoundedInputStream(inputStream, 4096);
				BufferedReader br = new BufferedReader(new InputStreamReader(boundedInput), 2048)) {
			String line = null;
			while ((line = br.readLine()) != null) {
				strbldr.append(line);
			}
		}
		JSONObject obj = new JSONObject(strbldr.toString());

		data = obj.toString();
		System.out.println(data);
		Optional<ArtistImage> artistImage = artistImgRepo.findByArtistName(obj.get("artistname").toString());
		ArtistImage img = new ArtistImage(artistImage.get().getArtistId(), artistImage.get().getArtistName(),
				artistImage.get().getArtistImg());

		return img;
	}

}
