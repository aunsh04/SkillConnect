package com.jga.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Courses 
{

	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String imageURL;
	private String courseURL;
	private String summary;
	private String youTubeUrl;
	private String title;
	
	@ManyToMany(mappedBy = "endorsedCourses")
	@JsonIgnore
	private List<Recruiter> endorsedRecruiters;
	
	
	@OneToMany(mappedBy="course", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<CourseInstructor> instructors;
	
	@OneToMany(mappedBy="course")
	
	private List<StudentCourseReview> courseReviews;
	
	public Courses() 
	{
		super();
	}
	
	
	  public StudentCourseReview addStudent(Student student, String review) {
		    StudentCourseReview r = new StudentCourseReview();
		    r.setStudent(student);
		    r.setCourse(this);
		    r.setStudentId(student.getId());
		    r.setCourseId(this.getId());
		    r.setReview(review);
		    if(this.courseReviews == null) {
		    		this.courseReviews = new ArrayList<>();
		    }   	
		    this.courseReviews.add(r);
		    // Also add the association object to the employee.
		    student.getStudentReviews().add(r);
		    return r;
		  }
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id= id;
	}
	
	

	public String getImageURL() {
		return imageURL;
	}


	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


	public String getCourseURL() {
		return courseURL;
	}


	public void setCourseURL(String courseURL) {
		this.courseURL = courseURL;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getYouTubeUrl() {
		return youTubeUrl;
	}


	public void setYouTubeUrl(String youTubeUrl) {
		this.youTubeUrl = youTubeUrl;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<CourseInstructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<CourseInstructor> instructors) {
		this.instructors = instructors;
	}

	public List<StudentCourseReview> getCourseReviews() {
		return courseReviews;
	}

	public void setCourseReviews(List<StudentCourseReview> courseReviews) {
		this.courseReviews = courseReviews;
	}

	public List<Recruiter> getEndorsedRecruiters() {
		return endorsedRecruiters;
	}

	public void setEndorsedRecruiters(List<Recruiter> endorsedRecruiters) {
		this.endorsedRecruiters = endorsedRecruiters;
	}


	public void set(Courses newcourse) {
		this.title = newcourse.title != null ?
				newcourse.title : this.title; 
		this.summary = newcourse.summary!= null ?
				newcourse.summary: this.summary; 

		
	}
	
	
	
}
