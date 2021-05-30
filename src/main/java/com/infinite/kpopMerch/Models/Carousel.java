package com.infinite.kpopMerch.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carousel")
public class Carousel {
	@Id
	@Column(name = "carousel_id")
	private String carouselId;
	@Column(name = "carousel_img")
	private byte[] carouselImg;

	public String getCarouselId() {
		return carouselId;
	}

	public void setCarouselId(String carouselId) {
		this.carouselId = carouselId;
	}

	public byte[] getCarouselImg() {
		return carouselImg;
	}

	public void setCarouselImg(byte[] carouselImg) {
		this.carouselImg = carouselImg;
	}

}
