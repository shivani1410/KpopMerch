package com.infinite.kpopMerch.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.kpopMerch.Models.AlbumDetails;

@Repository
public interface AlbumDetailsRepo extends JpaRepository<AlbumDetails, String> {
	AlbumDetails findByAlbumId(String id);

//	@Query(value = "SELECT album.albumId,album.album_name,album.release_date,album.album_cover FROM album_details album "
//			+ "WHERE album.album_name LIKE :#{search}%", nativeQuery = true)
//	List<AlbumDetails> findAlbumUsingNativeQuery(@Param("search") String search);
	List<AlbumDetails> findByAlbumNameContaining(String albumName);

	List<AlbumDetails> findAll();
}
