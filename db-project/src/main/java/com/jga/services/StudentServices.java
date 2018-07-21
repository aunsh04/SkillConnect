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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Books;
import com.jga.models.Person;
import com.jga.models.Professor;
import com.jga.models.Recruiter;
import com.jga.models.Student;
import com.jga.repositories.ProfessorRepository;
import com.jga.repositories.RecruiterRepository;
import com.jga.repositories.StudentRepository;

@RestController
public class StudentServices {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RecruiterRepository recruiterRepository;
	
	@GetMapping("/api/person/student/{studentid}")
	public Optional<Student> findstudentById(@PathVariable("studentid") int studentid){
		return studentRepository.findById(studentid);
	}
	
	@DeleteMapping("/api/person/student/{studentId}")
	public void deletestudent
	(@PathVariable("studentId") int id) {
		studentRepository.deleteById(id);
	}
	
	
	@GetMapping("/api/person/student/skill/{skillname}")
	public List<Student> findUserByskill(@PathVariable("skillname") String skill){
		return studentRepository.findUserByskill(skill);
	}
	
	
	@PutMapping("/api/person/student/{studentId}")
	public Person updatestudent(
			@PathVariable("studentId") int id,
			@RequestBody Student newstudent) {
		Optional<Student> student = studentRepository.findById(id);
		Student r = student.get();
		r.set(newstudent);
		return studentRepository.save(r);
		
	}
	
	@GetMapping("/api/person/student")	
	public List<Student> findAllStudent(){
		return (List<Student>) studentRepository.findAll();
	}
	
	@GetMapping("/api/person/student/{username}/{password}")	
	public Student findUserByCred(@PathVariable("username") String sId, @PathVariable("password") String pId){
		return (Student)studentRepository.findUserByCred(sId , pId);
	}
	
	
	@PostMapping("/api/person/student")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PostMapping("/api/student/{sId}/professor/{pId}")
	public void followProfessor(
			@PathVariable("sId") String sId,
			@PathVariable("pId") String pId) 
	
	{   int si = Integer.parseInt(sId);
		int pi = Integer.parseInt(pId);
		Student student = studentRepository.findById(si).get();
		Professor professor = professorRepository.findById(pi).get();
		student.followProfessor(professor);
		studentRepository.save(student);
}
	
	@PostMapping("/api/student/{sId}/recruiter/{rId}")
	public void followRecruiter(
			@PathVariable("sId") int sId,
			@PathVariable("rId") int rId) {
		Student student = studentRepository.findById(sId).get();
		Recruiter recruiter = recruiterRepository.findById(rId).get();
		student.followRecruiter(recruiter);
		studentRepository.save(student);
}
	

	
	
}
