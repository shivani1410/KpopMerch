package com.infinite.kpopMerch.Models;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwtToken;

	public String getJwtToken() {
		return jwtToken;
	}

	public JwtResponse(String jwtToken) {

		this.jwtToken = jwtToken;
	}

}
