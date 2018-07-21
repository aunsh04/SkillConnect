package com.jga.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recruiter extends Person {
	
public Recruiter() {
		super();
	}


@ManyToMany
@JoinTable(name="RECRUITER_COURSE",joinColumns=@JoinColumn(name="RECRUITER_ID", referencedColumnName="ID"),inverseJoinColumns=@JoinColumn(name="COURSE_ID", referencedColumnName="ID"))
@JsonIgnore
private List<Courses> endorsedCourses;



@ManyToMany
@JoinTable(name="RECRUITER_STUDENT",joinColumns=@JoinColumn(name="RECRUITER_ID", referencedColumnName="ID"),inverseJoinColumns=@JoinColumn(name="STUDENT_ID", referencedColumnName="ID"))
@JsonIgnore
private List<Student> followingStudents;

private String companyname;

public String getCompanyname() {
	return companyname;
}

public void setCompanyname(String companyname) {
	this.companyname = companyname;
}

public void setFollowingStudents(List<Student> followingStudents) {
	this.followingStudents = followingStudents;
}

public void getFollowedByStudent(Student student) {
	this.followingStudents.add(student);
	if(!student.getFollowedRecruiters().contains(this)) {
		student.getFollowedRecruiters().add(this);
}}

public void endorseCourse(Courses course) {
	this.endorsedCourses.add(course);
	if(!course.getEndorsedRecruiters().contains(this)) {
		course.getEndorsedRecruiters().add(this);
}}



public List<Student> getFollowingStudents() {
	return followingStudents;
}

public List<Courses> getEndorsedCourses() {
	return endorsedCourses;
}

public void setEndorsedCourses(List<Courses> endorsedCourses) {
	this.endorsedCourses = endorsedCourses;
}




}
