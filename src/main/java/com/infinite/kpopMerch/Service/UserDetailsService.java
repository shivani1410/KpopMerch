package com.infinite.kpopMerch.Service;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinite.kpopMerch.Models.Users;

public interface UserDetailsService {

	public String saveNewUser(Users user);

	public String checkUserName(String username) throws ParseException, JsonProcessingException;
}
