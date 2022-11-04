package com.devsuperior.workshopmongo.dto;

import java.io.Serializable;
import java.util.List;

import com.devsuperior.workshopmongo.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	private List<PostDTO> posts;
	
	public UserDTO() {
	}

	public UserDTO(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public User toEntity(String id, String name, String email) {
		return new User(id, name, email);
	}

	public List<PostDTO> getPosts() {
		return posts;
	}
}
