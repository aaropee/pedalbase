package com.example.pedalboardDesigner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String passwordHash;
	
	@Column(name = "role", nullable = false)
	private String role;

	
	public User() {
		
	}
	
	public User(String username, String email, String passwordHash, String role) {
		super();
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
		this.role = role;
	}
}