package com.infinite.kpopMerch.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Models.Carousel;
import com.infinite.kpopMerch.Repository.CarouselRepo;

@Service
public class CarouselServiceImpl implements CarouselService {
	@Autowired
	CarouselRepo carouselRepo;

	@Override
	public String getAllCarousel() throws JsonProcessingException {
		List<Carousel> carousel = carouselRepo.findAll();
		ObjectMapper mapper = new ObjectMapper();
		String output = mapper.writeValueAsString(carousel);
		return output;
	}

}
