package com.Niche.model;

public class Token {
	private final String jwt;

	public Token(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
}
