package com.jga.models;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Professor extends Person {
	
	@ManyToMany
	@JoinTable(name="PROFESSOR_BOOK",joinColumns=@JoinColumn(name="PROFESSOR_ID", referencedColumnName="ID"),inverseJoinColumns=@JoinColumn(name="BOOK_ID", referencedColumnName="ID"))
	@JsonIgnore
	private List<Books> endorsedBooks;
	
	
	@ManyToMany
	@JoinTable(name="PROFESSOR_STUDENT",joinColumns=@JoinColumn(name="PROFESSOR_ID", referencedColumnName="ID"),inverseJoinColumns=@JoinColumn(name="STUDENT_ID", referencedColumnName="ID"))
	@JsonIgnore
	private List<Student> followingStudents;
	
	@ManyToMany
	@JoinTable(name="PROFESSOR_PROFESSOR",joinColumns=@JoinColumn(name="PROFESSOR_ID", referencedColumnName="ID"),inverseJoinColumns=@JoinColumn(name="PROFESSOR1_ID", referencedColumnName="ID"))
	@JsonIgnore
	private List<Professor> followingProfessors;
	
	@ManyToMany(mappedBy="followingProfessors")
	@JsonIgnore
	private List<Professor> followedProfessors;
	
	
	@OneToMany(mappedBy="uploadingProfessor")
	private List<Papers> papersUploaded;
	
	private String profat;
	private String profdegree;
	public String getProfat() {
		return profat;
	}
	public void setProfat(String profat) {
		this.profat = profat;
	}
	public String getProfdegree() {
		return profdegree;
	}
	public void setProfdegree(String profdegree) {
		this.profdegree = profdegree;
	}
	
	public List<Books> getEndorsedBooks() {
		return endorsedBooks;
	}
	public void setEndorsedBooks(List<Books> endorsedBooks) {
		this.endorsedBooks = endorsedBooks;
	}
	public void endorseBook(Books book) {
		this.endorsedBooks.add(book);
		if(!book.getEndorsedProfessors().contains(this)) {
			book.getEndorsedProfessors().add(this);
}}
	public void deleteEndorseBook(Books book) {
		int pos = this.endorsedBooks.indexOf(book);
		this.endorsedBooks.remove(pos);
		System.out.print(pos);
		pos = book.getEndorsedProfessors().indexOf(this);
		book.getEndorsedProfessors().remove(pos);
		System.out.print(pos);
	}
	public List<Student> getFollowingStudents() {
		return followingStudents;
	}
	public void setFollowingStudents(List<Student> followingStudents) {
		this.followingStudents = followingStudents;
	}
	
	
	
	
//	public void getFollowedByStudent(Student student) {
//		this.followingStudents.add(student);
//		if(!student.getFollowedProfessors().contains(this)) {
//			student.getFollowedProfessors().add(this);
//}}
	
	public List<Professor> getFollowingProfessors() {
		return followingProfessors;
	}
	public void setFollowingProfessors(List<Professor> followingProfessors) {
		this.followingProfessors = followingProfessors;
	}
	public List<Professor> getFollowedProfessors() {
		return followedProfessors;
	}
	public void setFollowedProfessors(List<Professor> followedProfessors) {
		this.followedProfessors = followedProfessors;
	}
	public List<Papers> getPapersUploaded() {
		return papersUploaded;
	}
	public void setPapersUploaded(List<Papers> papersUploaded) {
		this.papersUploaded = papersUploaded;
	}
	public void uploadedPaper(Papers paper) {
			this.papersUploaded.add(paper);
			if(paper.getUploadingProfessor() != this) {
				paper.setUploadingProfessor(this);
	}
}
			
	

	public void followProfessor(Professor professor) {
		this.followedProfessors.add(professor);
		if(!professor.getFollowingProfessors()
		.contains(this)) {
			professor.getFollowingProfessors().add(this);
		}
}

	


}
