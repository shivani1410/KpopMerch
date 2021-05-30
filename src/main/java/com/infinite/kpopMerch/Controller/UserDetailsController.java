package com.infinite.kpopMerch.Controller;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.infinite.kpopMerch.Models.Users;
import com.infinite.kpopMerch.Service.UserDetailsService;
import com.infinite.kpopMerch.Utils.Config;

@RestController
public class UserDetailsController extends ResponseEntityExceptionHandler {
	@Autowired
	UserDetailsService userLoginService;

	private String errorMessage = "";

	@PostMapping(path = "/createNewUser", consumes = "application/json", produces = "application/json")
	public String createNewUser(InputStream inputStream) throws IOException {
		Config config = new Config();
		JSONObject obj = config.covertInputStream(inputStream);

		Users user = new Users();
		user.setName(obj.get("nameOfUser").toString());
		user.setAge(obj.get("age").toString());
		user.setPhoneNo(obj.get("phone").toString());
		user.setUsername(obj.get("username").toString());
		user.setPassword(obj.get("password").toString());
		String output = userLoginService.saveNewUser(user);

		return output;
	}

	@PostMapping(path = "/checkUsername", consumes = "application/json", produces = "application/json")
	public String checkUsername(InputStream inputStream) throws IOException, ParseException {
		Config config = new Config();
		JSONObject obj = config.covertInputStream(inputStream);
		String output = userLoginService.checkUserName(obj.toString());
		System.out.println(output);
		return output;

	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest webrequest) {
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
