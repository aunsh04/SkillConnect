package com.jga.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "StudentCourseReview")
@IdClass(StudentCourseReviewPK.class)
public class StudentCourseReview {
	
	@Id
	private int studentId;
	
	@Id
	private int courseId;
	
	
	@Column(name="REVIEW")
	private String review;

	@ManyToOne
	@JoinColumn(name = "studentId", updatable = false, insertable = false, referencedColumnName = "id")
	@JsonIgnore
    private Student student;
   
   @ManyToOne
   @JoinColumn(name = "courseId", updatable = false, insertable = false, referencedColumnName = "id")
   @JsonIgnore
   private Courses course;   
   
   


public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public int getCourseId() {
	return courseId;
}

public void setCourseId(int courseId) {
	this.courseId = courseId;
}

public void setStudent(Student student) {
	this.student = student;
}

public void setCourse(Courses course) {
	this.course = course;
}

public StudentCourseReview() {
	super();
}

public Student getStudent() {
	return student;
}

public Courses getCourse() {
	return course;
}


public String getReview() {
	return review;
}

public void setReview(String review) {
	this.review = review;
}
   
   
   
}