package com.infinite.kpopMerch.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infinite.kpopMerch.Models.Carousel;

@Repository
public interface CarouselRepo extends CrudRepository<Carousel, String> {
	List<Carousel> findAll();

}
