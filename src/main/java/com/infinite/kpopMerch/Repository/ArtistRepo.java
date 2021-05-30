package com.infinite.kpopMerch.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infinite.kpopMerch.Models.artist;

@Repository
public interface ArtistRepo extends CrudRepository<artist, String> {
	List<artist> findAll();

	artist findByArtistname(String artistName);

}
