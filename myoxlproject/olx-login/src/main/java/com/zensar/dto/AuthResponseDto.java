package com.zensar.dto;

public class AuthResponseDto {
	private final String token;
	private final String type = "Bearer";
	private final String expiration;

	public AuthResponseDto(String token, String expiration) {
		this.token = token;
		this.expiration = expiration;
	}

	public String getToken() {
		return token;
	}

	public String getType() {
		return type;
	}

	public String getExpiration() {
		return expiration;
	}
}