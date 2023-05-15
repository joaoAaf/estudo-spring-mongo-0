package com.estudo.estudoSpringMongo.dto;

import java.io.Serializable;

import com.estudo.estudoSpringMongo.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String id;
	String name;
	
	public AuthorDTO() {
	}

	public AuthorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
