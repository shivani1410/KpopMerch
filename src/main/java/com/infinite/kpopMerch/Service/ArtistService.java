package com.infinite.kpopMerch.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ArtistService {
	public String getAllArtists() throws JsonProcessingException;

	public String getArtistByName(String artistName) throws JsonProcessingException;

}
