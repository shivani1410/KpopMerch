package com.infinite.kpopMerch.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class artist {
	@Id
	@Column(name = "artist_id")
	private String artist_id;

	@Column(name = "artistname")
	private String artistname;

	@Column(name = "desc")
	private String desc;

	@Column(name = "artist_img")
	private byte[] artist_img;

	public String getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public byte[] getArtist_img() {
		return artist_img;
	}

	public void setArtist_img(byte[] artist_img) {
		this.artist_img = artist_img;
	}

}