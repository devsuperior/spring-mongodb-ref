package com.devsuperior.workshopmongo.dto;

import java.time.Instant;

import com.devsuperior.workshopmongo.entities.Post;

public class PostDTO {
	
	private String id;
	private Instant date;
	private String title;
	private String body;
	
	private AuthorDTO author;
	
	public PostDTO() {
	}
	
	public PostDTO(String id, Instant date, String title, String body, String authorId, String authorName, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		author = new AuthorDTO(authorId, authorName);
	}
	
	public PostDTO(Post post) {
		this.id = post.getId();
		this.date = post.getDate();
		this.title = post.getTitle();
		this.body = post.getBody();
		author = new AuthorDTO(post.getAuthorId(), post.getAuthorName());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
