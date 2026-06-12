package com.zensar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class TokenEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 512)
    private String token;

	public TokenEnity() {
		
	}
	
	public TokenEnity( String token) {
		super();
		this.token = token;
	}

	public TokenEnity(Long id, String token) {
		super();
		this.id = id;
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
    
  
}
