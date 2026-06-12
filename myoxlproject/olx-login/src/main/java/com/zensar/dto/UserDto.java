package com.zensar.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserDto {
	@Schema(accessMode = Schema.AccessMode.READ_ONLY) 
	private int id;
	private String userName;
	private String password;
	private String roles;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public UserDto() {
		
	}

	public UserDto(int id, String userName, String password, String roles, String firstName, String lastName,
			String email, String phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	public UserDto(String userName, String password, String roles, String firstName, String lastName,
			String email, String phone) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
