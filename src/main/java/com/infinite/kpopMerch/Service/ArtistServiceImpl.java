package com.infinite.kpopMerch.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Models.artist;
import com.infinite.kpopMerch.Repository.ArtistRepo;

@Service
public class ArtistServiceImpl implements ArtistService {
	@Autowired
	ArtistRepo artistRepo;

	@Override
	public String getAllArtists() throws JsonProcessingException {

		List<artist> allArtist = artistRepo.findAll();
		ObjectMapper mapper = new ObjectMapper();
		String output = "";
		output = mapper.writeValueAsString(allArtist);
		return output;
	}

	@Override
	public String getArtistByName(String artistName) throws JsonProcessingException {
		artist artist = artistRepo.findByArtistname(artistName);
		ObjectMapper mapper = new ObjectMapper();
		String output = "";
		output = mapper.writeValueAsString(artist);
		return output;

	}

}
