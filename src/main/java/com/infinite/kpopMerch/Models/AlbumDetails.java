package com.infinite.kpopMerch.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "album_details")
public class AlbumDetails {
	@Id
	@Column(name = "album_id")
	private String albumId;

	@Column(name = "album_name")
	private String albumName;

	@Column(name = "release_date")
	private String releaseDate;

	@Column(name = "artist_id")
	private String artistId;
	@Column(name = "album_cover")
	private byte[] albumCover;
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "artist_id", insertable = false, updatable = false, nullable = true)
	private artist artist;
	@Column(name = "price")
	private String price;

	@Column(name = "category")
	private String category;
	@Column(name = "url")
	private String url;

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public byte[] getAlbumCover() {
		return albumCover;
	}

	public void setAlbumCover(byte[] albumCover) {
		this.albumCover = albumCover;
	}

	public artist getArtist() {
		return artist;
	}

	public void setArtist(artist artist) {
		this.artist = artist;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
