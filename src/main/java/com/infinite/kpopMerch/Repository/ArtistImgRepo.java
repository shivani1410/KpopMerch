package com.infinite.kpopMerch.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infinite.kpopMerch.Models.ArtistImage;

@Repository
public interface ArtistImgRepo extends CrudRepository<ArtistImage, Long> {
	Optional<ArtistImage> findByArtistName(String artistName);

	ArtistImage findByArtistId(String id);

}
