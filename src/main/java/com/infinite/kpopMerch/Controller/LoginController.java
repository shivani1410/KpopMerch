package com.infinite.kpopMerch.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.input.BoundedInputStream;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Config.JwtTokenUtil;
import com.infinite.kpopMerch.Models.JwtResponse;
import com.infinite.kpopMerch.Service.LoginService;

@RestController
public class LoginController extends ResponseEntityExceptionHandler {
	@Autowired
	LoginService loginService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	private String errorMessage = "";

	@PostMapping(path = "/Login", consumes = "application/json", produces = "application/json")
	public String userLogin(InputStream inputStream) throws IOException, ParseException {
		errorMessage = "Incorrect Username or Password";
		System.out.println("inside login");
		StringBuilder strbldr = new StringBuilder(64000);
		String data = null;
		String output = "";
		String jsonString = "";
		BoundedInputStream boundedInput = new BoundedInputStream(inputStream, 4096);
		BufferedReader br = new BufferedReader(new InputStreamReader(boundedInput), 2048);
		String line = null;
		while ((line = br.readLine()) != null) {
			strbldr.append(line);
		}
		JSONObject obj = new JSONObject(strbldr.toString());

		data = obj.toString();
//			JSONParser parser = new JSONParser();
//			JSONObject userJSON = (JSONObject) parser.parse(data);
//			System.out.println(userJSON);
		String userName = obj.get("username").toString();
		String password = obj.get("password").toString();
		output = loginService.userLogin(userName);
		System.out.println("output=================" + output);
		authenticate(userName, password);
		System.out.println("after authenticate=================");
		final UserDetails details = loginService.loadUserByUsername(userName);
		System.out.println("after details=================" + details);
		final String token = jwtTokenUtil.generateToken(details);
		System.out.println("after token=================" + token);
		JwtResponse response = null;
		response = new JwtResponse(token);
		ObjectMapper mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(response);

		return "{" + "\"User_Details\" : [" + output + "," + jsonString + "]}";
	}

	private void authenticate(String username, String password) throws BadCredentialsException, DisabledException {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest webrequest) {
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
