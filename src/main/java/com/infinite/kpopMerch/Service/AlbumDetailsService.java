package com.infinite.kpopMerch.Service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinite.kpopMerch.Models.album_details;

public interface AlbumDetailsService {
	public List<album_details> getNewAlbums();

	public String getAlbumById(String id) throws JsonProcessingException;

	public List<album_details> getAlbumByName(String search) throws JsonProcessingException;

	public List<album_details> getAllAlbum();

	public List<album_details> getAlbumByArtistId(String id) throws JsonProcessingException;
}
