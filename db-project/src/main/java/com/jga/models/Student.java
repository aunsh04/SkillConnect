package com.jga.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student extends Person {
	

	private String universityname;
	private String highestdegree;
	private String major;
	private String desc1;
	private String linkedinurl;
	public String getLinkedinurl() {
		return linkedinurl;
	}

	public void setLinkedinurl(String linkedinurl) {
		this.linkedinurl = linkedinurl;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	private String desc2;
	
	@ManyToMany(mappedBy = "followingStudents")
	@JsonIgnore
	private List<Professor> followedProfessors;
	
	
	@ManyToMany(mappedBy = "followingStudents")
	@JsonIgnore
	private List<Recruiter> followedRecruiters;
	
	@OneToMany(mappedBy="student")
	
	private List<StudentCourseReview> studentReviews;
	
	
	public Student() {
		super();
	}
	
	public Student(String universityname, String highestdegree, String major) {
		super();
		this.universityname = universityname;
		this.highestdegree = highestdegree;
		this.major = major;
	}

	public String getUniversityname() {
		return universityname;
	}

	public void setUniversityname(String universityname) {
		this.universityname = universityname;
	}

	public String getHighestdegree() {
		return highestdegree;
	}

	public void setHighestdegree(String highestdegree) {
		this.highestdegree = highestdegree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<Professor> getFollowedProfessors() {
		return followedProfessors;
	}

	public void setFollowedProfessors(List<Professor> followedProfessors) {
		this.followedProfessors = followedProfessors;
	}
	
	public void followProfessor(Professor professor) {
		this.followedProfessors.add(professor);
		if(!professor.getFollowingStudents()
				.contains(this)) {
			professor.getFollowingStudents().add(this);
}}
	
	
	public void followRecruiter(Recruiter recruiter) {
		this.followedRecruiters.add(recruiter);
		if(!recruiter.getFollowingStudents()
				.contains(this)) {
			recruiter.getFollowingStudents().add(this);
}}
	

	public List<StudentCourseReview> getStudentReviews() {
		return studentReviews;
	}

	public void setStudentReviews(List<StudentCourseReview> studentReviews) {
		this.studentReviews = studentReviews;
	}

	public List<Recruiter> getFollowedRecruiters() {
		return followedRecruiters;
	}

	public void setFollowedRecruiters(List<Recruiter> followedRecruiters) {
		this.followedRecruiters = followedRecruiters;
	}
}
