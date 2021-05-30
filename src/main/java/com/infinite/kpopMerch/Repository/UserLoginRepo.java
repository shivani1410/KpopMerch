package com.infinite.kpopMerch.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infinite.kpopMerch.Models.Users;

@Repository
public interface UserLoginRepo extends CrudRepository<Users, String> {

	Users findByUsername(String username);

	Users save(Users users);
}
