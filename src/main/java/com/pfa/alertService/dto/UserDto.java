package com.pfa.alertService.dto;

public class UserDto {
	private Long id;
	private String email;
	private String username;
	public UserDto(Long id, String email, String username) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
