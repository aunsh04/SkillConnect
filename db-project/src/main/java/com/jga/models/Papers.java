package com.jga.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Papers {
	
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private int year;
	private String downloadUrl;
	
	@ManyToOne()
	@JsonIgnore
	private Professor uploadingProfessor;
	
	public Papers() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	
	
	public void setProfessor(Professor professor) {
		this.uploadingProfessor = professor;
		if(!professor.getPapersUploaded().contains(this)) {
			professor.getPapersUploaded().add(this);
	}}
	public Professor getUploadingProfessor() {
		return uploadingProfessor;
	}
	public void setUploadingProfessor(Professor uploadingProfessor) {
		this.uploadingProfessor = uploadingProfessor;
	}
	public void set(Papers newpaper) {
		this.title = newpaper.title != null ?
				newpaper.title : this.title; 
		this.description = newpaper.description!= null ?
				newpaper.description: this.description; 
		 
		
	}
	
	

	
}
