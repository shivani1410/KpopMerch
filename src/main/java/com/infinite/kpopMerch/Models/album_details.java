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
public class album_details {
	@Id
	@Column(name = "album_id")
	private String album_id;

	@Column(name = "album_name")
	private String album_name;

	@Column(name = "release_date")
	private String release_date;

	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "artist_id", insertable = false, updatable = false, nullable = true)
	private artist artist;
	@Column(name = "artist_id")
	private String artist_id;
	@Column(name = "album_cover")
	private byte[] album_cover;
	@Column(name = "price")
	private String price;

	@Column(name = "category")
	private String category;

	public String getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public artist getArtist() {
		return artist;
	}

	public void setArtist(artist artist) {
		this.artist = artist;
	}

	public byte[] getAlbum_cover() {
		return album_cover;
	}

	public void setAlbum_cover(byte[] album_cover) {
		this.album_cover = album_cover;
	}

	public String getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
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

}
