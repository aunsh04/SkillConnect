package com.jga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Courses;
import com.jga.models.Student;
import com.jga.models.StudentCourseReview;
import com.jga.repositories.CoursesRepository;
import com.jga.repositories.StudentCourseReviewRepository;
import com.jga.repositories.StudentRepository;

@RestController
public class StudentCourseReviewService {
	@Autowired
	StudentCourseReviewRepository studentCourseReviewRepository;
	
	@Autowired
	CoursesRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/api/student/{studentId}/course/{courseId}/review")
	public StudentCourseReview createStudentReview(@RequestBody StudentCourseReview studentCourseReview, @PathVariable("studentId") int sId, @PathVariable("courseId")int cId) {
		Courses course = courseRepository.findById(cId).get();
		Student student = studentRepository.findById(sId).get();
		StudentCourseReview r = course.addStudent(student, studentCourseReview.getReview());
		return studentCourseReviewRepository.save(r);
	}
	
	@DeleteMapping("/api/student/{studentId}/course/{courseId}/delete/review")
	public void deleteReview(@PathVariable("studentId") int sId, @PathVariable("courseId")int cId) {
		studentCourseReviewRepository.delReview(cId, sId);
		
	}
	
	
	

}
