package com.infinite.kpopMerch.Service;

import org.json.simple.parser.ParseException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LoginService extends UserDetailsService {
	public String userLogin(String username) throws JsonProcessingException, ParseException;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
