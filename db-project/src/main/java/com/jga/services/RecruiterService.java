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
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Books;
import com.jga.models.Courses;
import com.jga.models.Person;
import com.jga.models.Professor;
import com.jga.models.Recruiter;
import com.jga.models.Student;
import com.jga.repositories.CoursesRepository;
import com.jga.repositories.ProfessorRepository;
import com.jga.repositories.RecruiterRepository;

@RestController
public class RecruiterService {
	@Autowired
	RecruiterRepository recruiterRepository;
	
	@Autowired
	CoursesRepository courseRepository;
	
	
	@PostMapping("/api/person/recruiter")
	public Recruiter createRecruiter(@RequestBody Recruiter recruiter) {
		return recruiterRepository.save(recruiter);
		
	}
	
	@GetMapping("/api/person/recruiter")	
	public List<Recruiter> findAllRecruiter(){
		return (List<Recruiter>) recruiterRepository.findAll();
	}
	
	@DeleteMapping("/api/person/recruiter/{recruiterId}")
	public void deleteRecruiter
	(@PathVariable("recruiterId") int id) {
		recruiterRepository.deleteById(id);
	}

	
	@PutMapping("/api/person/recruiter/{recruiterId}")
	public Person updateUser(
			@PathVariable("recruiterId") int id,
			@RequestBody Recruiter newrecruiter) {
		Optional<Recruiter> recruiter = recruiterRepository.findById(id);
		Recruiter r = recruiter.get();
		r.set(newrecruiter);
		return recruiterRepository.save(r);
		
	}
	
	@GetMapping("/api/person/recruiter/{username}/{password}")	
	public Recruiter findUserByCred(@PathVariable("username") String sId, @PathVariable("password") String pId){
		return (Recruiter)recruiterRepository.findUserByCred(sId , pId);
	}
	
	
	
	@GetMapping("/api/person/recruiter/{recruiterid}")
	public Optional<Recruiter> findrecruiterById(@PathVariable("recruiterid") int recruiterid){
		return recruiterRepository.findById(recruiterid);
	}
	
	@GetMapping("/api/recruiter/student/{rId}")
	public List<Student> findStudentsFollowingRecruiter(@PathVariable("rId") int rId) {
		Recruiter recruiter = recruiterRepository.findById(rId).get();
		return recruiter.getFollowingStudents();
	}
	
	@PostMapping("/api/recruiter/{rId}/course/{cId}")
	public void endorseBookByRecruiter(
			@PathVariable("rId") int rId,
			@PathVariable("cId") int cId) {
		Courses course = courseRepository.findById(cId).get();
		Recruiter recruiter = recruiterRepository.findById(rId).get();
		recruiter.endorseCourse(course);
		recruiterRepository.save(recruiter);
}
	
}
