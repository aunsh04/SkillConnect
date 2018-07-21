package com.jga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Books;
import com.jga.models.CourseInstructor;
import com.jga.models.Courses;
import com.jga.models.Professor;
import com.jga.models.Recruiter;
import com.jga.models.Student;
import com.jga.models.StudentCourseReview;
import com.jga.repositories.CourseInstructorRepository;
import com.jga.repositories.CoursesRepository;
import com.jga.repositories.StudentCourseReviewRepository;
import com.jga.repositories.StudentRepository;

@RestController
public class CoursesService 
{

	@Autowired
	CoursesRepository courseRepository;
	
	@Autowired
	CourseInstructorRepository instructorRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentCourseReviewRepository studentCourseRepository;
	
	@GetMapping("api/courses")
	public List<Courses> findAllCourses()
	{
		return (List<Courses>) courseRepository.findAll();
	}
	
	@PostMapping("/api/courses")
	public Courses createCourse(@RequestBody Courses course) 
	{
		return courseRepository.save(course);
		
	}
	
	@GetMapping("/api/courses/{courseID}")
	public Optional<Courses> findCourseById
	
	(@PathVariable("courseID") int courseID) {
	 
		return courseRepository.findById(courseID);
	}
	
	
	@GetMapping("/api/courses/search/{title}")	
	public List<Courses> findCourseByTitle(@PathVariable("title") String title){
		return (List<Courses>) courseRepository.findCourseByTitle(title);
	}
	
	
	
	@GetMapping("/api/courses/recruiter/{cId}")
	public List<Recruiter> 
findRecruitersEndorsingCourse(@PathVariable("cId") int cId) {
		Courses course = courseRepository.findById(cId).get();
		return course.getEndorsedRecruiters();
}
	
	@GetMapping("/api/courses/reviews/{cId}")
	public List<StudentCourseReview> findReviewsForCourse(@PathVariable("cId") int cId) {
		Courses course = courseRepository.findById(cId).get();
		return course.getCourseReviews();
	}
	
	
	@PutMapping("/api/courses/{cid}")
	public Courses updatebooks(
			@PathVariable("cid") int id,
			@RequestBody Courses newcourse) {
		Optional<Courses> courses = courseRepository.findById(id);
		Courses r = courses.get();
		r.set(newcourse);
		return courseRepository.save(r);
		
	}
	
	
	@DeleteMapping("/api/courses/{cId}")
	public void deletebook
	(@PathVariable("cId") int id) {
		courseRepository.deleteById(id);
	}
	
	
	
}
