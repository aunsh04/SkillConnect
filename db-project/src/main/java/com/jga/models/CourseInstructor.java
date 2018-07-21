package com.jga.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CourseInstructor 
{

	@Id
	private int id;
	
	@ManyToOne()
	@JsonIgnore
	private Courses course;
	
	private String instructorName;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Courses getCourse() {
		return course;
	}
	
	public void setCourse(Courses course) {
		this.course = course;
	}
	
	public String getInstructorName() {
		return instructorName;
	}
	
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
}
