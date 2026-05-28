package com.devsuperior.workshopmongo.dto;

import java.time.Instant;

public class CommentDTO {
	
	private String text;
	private Instant date;
	private AuthorDTO author;

	public CommentDTO() {
	}

	public CommentDTO(String text, Instant date, AuthorDTO author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
