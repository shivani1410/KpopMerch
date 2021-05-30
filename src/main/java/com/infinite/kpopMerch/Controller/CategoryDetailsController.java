package com.infinite.kpopMerch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinite.kpopMerch.Service.CategoryService;

@RestController
public class CategoryDetailsController {
	@Autowired
	CategoryService categoryService;

	@GetMapping(path = "/getAllCategory", produces = "application/json")
	public String getAllCategory() throws JsonProcessingException {
		String output = "";
		output = categoryService.getAllCategory();
		return output;
	}
}
