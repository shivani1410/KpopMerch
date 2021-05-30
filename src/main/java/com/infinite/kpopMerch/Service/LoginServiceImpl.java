package com.infinite.kpopMerch.Service;

import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Models.Users;
import com.infinite.kpopMerch.Repository.UserLoginRepo;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserLoginRepo userLoginRepo;

	@Override
	public String userLogin(String username) throws JsonProcessingException, ParseException {
		System.out.println(username);

		Users userDetails = userLoginRepo.findByUsername(username);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		jsonString = mapper.writeValueAsString(userDetails);

		return jsonString;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("inside loadUserByUsername");
		Users userAcess = new Users();
		System.out.println("inside loadUserByUsername");
		userAcess = userLoginRepo.findByUsername(username);
		System.out.println("after findByUsername");
		if (userAcess == null) {
			System.out.println("inside userAcess");
			throw new UsernameNotFoundException("User not found with " + username);
		}
		System.out.println("login service 46");
		return new User(userAcess.getUsername(), userAcess.getPassword(), new ArrayList<>());
	}

}
