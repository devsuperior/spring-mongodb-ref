package com.devsuperior.workshopmongo.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post")
public class Post {

	@Id
	private String id;
	private Instant date;
	private String title;
	private String body;
	private Author author;
	
	private List<Comment> comments = new ArrayList<>();
	
	public Post() {
	}

	public Post(String id, Instant date, String title, String body, Author author) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
	public Post(String id, Instant date, String title, String body, String authorId, String authorName) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = new Author(authorId, authorName);
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getAuthorId() {
		return author.getId();
	}
	
	public String getAuthorName() {
		return author.getName();
	}

	public List<Comment> getComments() {
		return comments;
	}
	
	public void addComment(String CommentText, Instant commentDate, String authorId, String authorName) {
		Comment comment = new Comment(CommentText, date, authorId, authorName);
		comments.add(comment);
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

class Author {
	
	private String id;
	private String name;
	
	public Author() {
	}

	public Author(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Author(User entity) {
		id = entity.getId();
		name = entity.getName();
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

class Comment {
	
	private String text;
	private Instant date;
	private Author author;
	
	public Comment() {
	}

	public Comment(String text, Instant date, Author author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}
	
	public Comment(String text, Instant date, String authorId, String authorName) {
		this.text = text;
		this.date = date;
		this.author = new Author(authorId, authorName);
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
