package com.infinite.kpopMerch.Service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Models.Users;
import com.infinite.kpopMerch.Repository.UserLoginRepo;
import com.infinite.kpopMerch.Utils.Config;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserLoginRepo userLoginRepo;

	@Override
	public String saveNewUser(Users user) {
		System.out.println("inside serive");
		String output = "";

		Users userNew = new Users();
		userNew.setUserid("0");
		userNew.setName(user.getName());
		userNew.setAge(user.getAge());
		userNew.setPassword(user.getPassword());
		userNew.setPhoneNo(user.getPhoneNo());
		userNew.setUsername(user.getUsername());
		Users newUser = userLoginRepo.save(userNew);

		output = "New User Created";

		return output;
	}

	@Override
	public String checkUserName(String username) throws ParseException, JsonProcessingException {
		Config config = new Config();
		JSONObject obj = config.convertToJSON(username);
		String output = "";
		String userName = obj.get("username").toString();

		Users userDetails = userLoginRepo.findByUsername(userName);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		jsonString = mapper.writeValueAsString(userDetails);
		System.out.println("json" + jsonString + "String");

		if (!(jsonString.equals("null"))) {
			output = "username already exist";
		} else {
			output = "username available";
		}

		return output;
	}

}
