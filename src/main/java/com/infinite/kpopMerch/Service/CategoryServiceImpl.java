package com.infinite.kpopMerch.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Models.CategoryDetails;
import com.infinite.kpopMerch.Repository.CategoryDetailsRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDetailsRepo categoryDetailsRepo;

	@Override
	public String getAllCategory() throws JsonProcessingException {
		// TODO Auto-generated method stub
		List<CategoryDetails> allCategories = categoryDetailsRepo.findAll();
		ObjectMapper mapper = new ObjectMapper();
		String output = "";
		output = mapper.writeValueAsString(allCategories);
		return output;

	}

}
