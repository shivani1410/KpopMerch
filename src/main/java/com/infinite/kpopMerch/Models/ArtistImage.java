package com.infinite.kpopMerch.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class ArtistImage {
	@Id
	@Column(name = "artist_id")
	private String artistId;

	@Column(name = "artistname")
	private String artistName;

	@Column(name = "artist_img")
	private byte[] artistImg;

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public byte[] getArtistImg() {
		return artistImg;
	}

	public void setArtistImg(byte[] artistImg) {
		this.artistImg = artistImg;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public ArtistImage(String artistId, String artistName, byte[] artistImg) {

		this.artistId = artistId;
		this.artistName = artistName;
		this.artistImg = artistImg;
	}

	public ArtistImage() {
	}

}
