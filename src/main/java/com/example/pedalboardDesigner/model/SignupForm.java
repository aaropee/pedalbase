package com.example.pedalboardDesigner.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupForm {

	private String username = "";
	
	private String email = "";
	
	private String password = "";
	
	private String passwordCheck = "";
	
	private String role = "USER";

	public String getUsername() {
		return username;
		
	}
}