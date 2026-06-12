package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
// Import the native Resilience4j annotation
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserDelegateImpl implements UserDelegate {

	@Autowired
	RestTemplate restTemplate;
	
	private final UserAuthClient userAuthClient;
	
	// Clean constructor injection (No more CircuitBreakerFactory needed)
	UserDelegateImpl(UserAuthClient userAuthClient){
		this.userAuthClient = userAuthClient;
	}
	
	@Override
	// Add the annotation here. The name must match your local application.yml exactly.
	@CircuitBreaker(name = "TOKEN-VALIDATION", fallbackMethod = "fallbackIsTokenValid")
	public boolean isTokenValid(String authToken) {
		/*
		 * HttpHeaders headers = new HttpHeaders(); headers.add("Authorization",
		 * authToken); HttpEntity<String> entity = new HttpEntity<>(headers);
		 * 
		 * return restTemplate.exchange(
		 * "http://OLX_LOGIN/user-management/token/validate", HttpMethod.GET, entity,
		 * Boolean.class ).getBody();
		 */
		return userAuthClient.validateToken(authToken).getBody();
	}
     
	// Fallback method signature MUST match the original method, plus a Throwable parameter
	public boolean fallbackIsTokenValid(String authToken, Throwable throwable) {
		return throwable != null ? false : true;
	}
}
