package com.infinite.kpopMerch.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Models.AlbumDetails;
import com.infinite.kpopMerch.Models.ArtistImage;
import com.infinite.kpopMerch.Models.album_details;
import com.infinite.kpopMerch.Repository.AlbumDetailsRepo;
import com.infinite.kpopMerch.Repository.ArtistImgRepo;

@Service
public class AlbumDetailsServiceImpl implements AlbumDetailsService {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	AlbumDetailsRepo albumDetailsRepo;
	@Autowired
	ArtistImgRepo artistImgRepo;

	@SuppressWarnings("unchecked")
	@Override
	public List<album_details> getNewAlbums() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String fromDate = dtf.format(now.minusDays(30));
		String toDate = dtf.format(now);

		Query query = em.createQuery(
				"SELECT album.album_id,album.album_name,album.release_date,album.album_cover, art.artistname FROM album_details album,artist art "
						+ "WHERE album.artist_id=art.artist_id AND release_date>:fromDate AND release_date<:toDate")
				.setParameter("fromDate", fromDate).setParameter("toDate", toDate);
		return query.getResultList();

	}

	@Override
	public String getAlbumById(String id) throws JsonProcessingException {
		AlbumDetails details = albumDetailsRepo.findByAlbumId(id);
		ArtistImage artist = artistImgRepo.findByArtistId(details.getArtistId());
		Integer totalPrice = Integer.parseInt(details.getPrice()) + 50;
		JSONObject json = new JSONObject();
		json.put("albumId", details.getAlbumId());
		json.put("albumName", details.getAlbumName());
		json.put("releaseDate", details.getReleaseDate());
		json.put("url", details.getUrl());
		json.put("albumCover", details.getAlbumCover());
		json.put("artistName", artist.getArtistName());
		json.put("price", details.getPrice());
		json.put("category", details.getCategory());
		json.put("totalPrice", totalPrice);
		String jsonString = "";
		ObjectMapper mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(json);
		return jsonString;
	}

	@Override
	public List<album_details> getAlbumByName(String search) throws JsonProcessingException {
		Query query = em
				.createQuery(
						"SELECT album.album_id,album.album_name, art.artistname FROM album_details album,artist art "
								+ "WHERE album.artist_id=art.artist_id AND album.album_name LIKE :search ")
				.setParameter("search", "%" + search + "%");

		return query.getResultList();
//		List<AlbumDetails> albums = albumDetailsRepo.findByAlbumNameContaining(search);
//
//		return albums;

	}

	@Override
	public List<album_details> getAllAlbum() {
//		List<album_details> allAlbums = albumDetailsRepo.findAll();

		Query query = em.createQuery(
				"SELECT album.album_id,album.album_name,album.release_date,album.album_cover, art.artistname FROM album_details album,artist art "
						+ "WHERE album.artist_id=art.artist_id AND album.category=1");
		return query.getResultList();
//		return allAlbums;
	}

	@Override
	public List<album_details> getAlbumByArtistId(String id) throws JsonProcessingException {
		Query query = em.createQuery(
				"SELECT album.album_id,album.album_name,album.release_date,album.album_cover, art.artistname FROM album_details album,artist art "
						+ "WHERE album.artist_id=art.artist_id AND album.artist_id= :id ")
				.setParameter("id", id);

		return query.getResultList();
	}

}
