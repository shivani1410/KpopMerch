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
@Table(name = "season_greeting")
public class season_greeting {
	@Id
	@Column(name = "sg_id")
	private String sg_id;
	@Column(name = "sg_img")
	private byte[] sg_img;
	@Column(name = "price")
	private String price;

	@Column(name = "category")
	private String category;
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "artist_id", insertable = false, updatable = false, nullable = true)
	private artist artist;
	@Column(name = "artist_id")
	private String artist_id;

	public String getSg_id() {
		return sg_id;
	}

	public void setSg_id(String sg_id) {
		this.sg_id = sg_id;
	}

	public byte[] getSg_img() {
		return sg_img;
	}

	public void setSg_img(byte[] sg_img) {
		this.sg_img = sg_img;
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

	public artist getArtist() {
		return artist;
	}

	public void setArtist(artist artist) {
		this.artist = artist;
	}

	public String getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}

}
