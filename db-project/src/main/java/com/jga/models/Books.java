package com.jga.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Books {
	@Id
	private String id;
	private String title;
	private String description;
	private String language;
	private double siterating ;
	private int siteratingcount;
	private String thumbnailurl;
	private String publisher;
	
	@ManyToMany(mappedBy = "endorsedBooks")
	private List<Professor> endorsedProfessors;
	
	@OneToMany(mappedBy="book", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<BookAuthor> authors;
	
	public void authoredBook (BookAuthor author) {
			this.authors.add(author);
			if(author.getBook() != this) {
				author.setBook(this);
			}
	}


	public List<BookAuthor> getAuthors() {
		return authors;
	}
	public void setAuthors(List<BookAuthor> authors) {
		this.authors = authors;
	}
	
	public void addProfessorEndorsement(Professor professor) {
		this.endorsedProfessors.add(professor);
		if(!professor.getEndorsedBooks()
				.contains(this)) {
	professor.getEndorsedBooks().add(this);
}}
	

	public List<Professor> getEndorsedProfessors() {
		return endorsedProfessors;
	}
	public void setEndorsedProfessors(List<Professor> endorsedProfessors) {
		this.endorsedProfessors = endorsedProfessors;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public double getSiterating() {
		return siterating;
	}
	public void setSiterating(double siterating) {
		this.siterating = siterating;
	}
	public int getSiteratingcount() {
		return siteratingcount;
	}
	public void setSiteratingcount(int siteratingcount) {
		this.siteratingcount = siteratingcount;
	}
	public String getThumbnailurl() {
		return thumbnailurl;
	}
	public void setThumbnailurl(String thumbnailurl) {
		this.thumbnailurl = thumbnailurl;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Books() {
		super();
	}


	public void set(Books newbook) {
		
		this.title = newbook.title != null ?
				newbook.title : this.title; 
		
		
	}


	
	
}
