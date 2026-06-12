package com.zensar.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class OauthTestController {

	 @GetMapping("/")
	    public Map<String, Object> home(@AuthenticationPrincipal OAuth2User principal) {
	        // Returns the authenticated GitHub user attributes (e.g., name, login, avatar_url)
	        if (principal == null) {
	            return Collections.singletonMap("message", "Not Authenticated");
	        }
	        return Collections.singletonMap("name", principal.getAttribute("name"));
	    }
}
