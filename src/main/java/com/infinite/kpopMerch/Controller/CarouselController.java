package com.infinite.kpopMerch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinite.kpopMerch.Service.CarouselService;

@RestController
public class CarouselController {
	@Autowired
	CarouselService carouselService;

	@GetMapping(path = "/getAllCarousel", produces = "application/json")
	public String getAllCarousel() throws JsonProcessingException {
		String output = "";
		output = carouselService.getAllCarousel();
		return output;

	}

}
