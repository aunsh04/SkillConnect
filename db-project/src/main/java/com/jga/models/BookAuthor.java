package com.jga.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BookAuthor {
	
	@Id
	private int id;
	@ManyToOne()
	@JsonIgnore
	private Books book;
	private String authorName;
	
	 public void setAuthorBook(Books book) {
			this.book = book;
			if(!book.getAuthors().contains(this)) {
				book.getAuthors().add(this);
		}
	 }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}
