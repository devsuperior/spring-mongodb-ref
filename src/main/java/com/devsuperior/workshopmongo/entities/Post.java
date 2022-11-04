package com.devsuperior.workshopmongo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post")
public class Post implements Serializable {

	@Id
	private String id;
	private Instant date;
	private String title;
	private String body;
	private User author;
	
	public Post() {
	}

	public Post(String id, Instant date, String title, String body, User author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, body, date, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(author, other.author) && Objects.equals(body, other.body)
				&& Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(title, other.title);
	}
}
