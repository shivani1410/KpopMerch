package com.infinite.kpopMerch.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infinite.kpopMerch.Models.CategoryDetails;

@Repository
public interface CategoryDetailsRepo extends CrudRepository<CategoryDetails, String> {
	List<CategoryDetails> findAll();

}
