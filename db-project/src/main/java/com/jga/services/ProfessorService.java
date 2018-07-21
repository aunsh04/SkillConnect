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
import com.jga.models.Papers;
import com.jga.models.Person;
import com.jga.models.Professor;
import com.jga.models.Recruiter;
import com.jga.models.Student;
import com.jga.repositories.BooksRepository;
import com.jga.repositories.PapersRepository;
import com.jga.repositories.ProfessorRepository;
import com.jga.repositories.StudentRepository;

@RestController
public class ProfessorService {
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	BooksRepository booksRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	PapersRepository paperRepository;
	
	@PostMapping("/api/professor")
	public Professor createProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	
	
	@DeleteMapping("/api/person/professor/{professorId}")
	public void deleteProfessor
	(@PathVariable("professorId") int id) {
		professorRepository.deleteById(id);
	}

	
	@GetMapping("/api/person/professor/{username}/{password}")	
	public Professor findUserByCred(@PathVariable("username") String sId, @PathVariable("password") String pId){
		return (Professor)professorRepository.findUserByCred(sId , pId);
	}
	
	
	@GetMapping("/api/person/professorname/{firstName}")	
	public List<Professor> findUserByname(@PathVariable("firstName") String na){
		
		return (List<Professor>) professorRepository.findUserByname(na);
	}
	
	@PutMapping("/api/person/professor/{professorId}")
	public Person updateProfessor(
			@PathVariable("professorId") int id,
			@RequestBody Professor newprofessor) {
		Optional<Professor> professor = professorRepository.findById(id);
		Professor r = professor.get();
		r.set(newprofessor);
		return professorRepository.save(r);
		
	}
	
	
	
	@GetMapping("/api/person/professor/{professorid}")
	public Optional<Professor> findprofessorById(@PathVariable("professorid") int professorid){
		return professorRepository.findById(professorid);
	}
	
	@PostMapping("/api/professor/{pId}/book/{bId}")
	public void endorseBookByProfessor(
			@PathVariable("bId") String bId,
			@PathVariable("pId") int pId) {
		Books books = booksRepository.findById(bId).get();
		Professor professor = professorRepository.findById(pId).get();
		professor.endorseBook(books);
		professorRepository.save(professor);
}
	@PutMapping("/api/professor/{pId}/book/{bId}")
	public void deleteEndorseBookByProfessor(@PathVariable("bId") String bId,
	@PathVariable("pId") int pId) {
		Books books = booksRepository.findById(bId).get();
		Professor professor = professorRepository.findById(pId).get();
		professor.deleteEndorseBook(books);
		professorRepository.save(professor);
		booksRepository.save(books);
	}
//	@PostMapping("/api/professor/{pId}/student/{sId}")
//	public void followedByStudent(
//			@PathVariable("pId") int pId,
//			@PathVariable("sId") int sId) {
//		Student student = studentRepository.findById(sId).get();
//		Professor professor = professorRepository.findById(pId).get();
//		professor.getFollowedByStudent(student);
//		professorRepository.save(professor);
//}
	
	@GetMapping("/api/professor/student/{pId}")
	public List<Student> findStudentsFollowingProfessor(@PathVariable("pId") int pId) {
		Professor professor = professorRepository.findById(pId).get();
		return professor.getFollowingStudents();
}
	
	@GetMapping("/api/person/professor")	
	public List<Professor> findAllProfessor(){
		return (List<Professor>) professorRepository.findAll();
	}
	
	
	@PutMapping("/api/person/professor/{prId}/upload")
	public void uploadedPaper(
			@PathVariable("prId") int prId,
			@RequestBody Papers paper) {
		Professor professor = professorRepository.findById(prId).get();
		paper.setUploadingProfessor(professor);
		paperRepository.save(paper);

	}

	@GetMapping("/api/professor/{prId}/uploaded")
	public Iterable<Papers> findUploadedPapers(@PathVariable("prId") int prId) {
		Professor professor = professorRepository.findById(prId).get();
		return professor.getPapersUploaded();
	}
	
	@GetMapping("/api/professor/{prId}/endorsed")
	public Iterable<Books> findEndorsedBooks(@PathVariable("prId") int prId) {
		Professor professor = professorRepository.findById(prId).get();
		return professor.getEndorsedBooks();
	}
	
	
	
	
	
	@PostMapping("/api/professorf/{prId}/professorbf/{pId}")
	public void professorFollowProfessor(@PathVariable("prId") int prId,@PathVariable("pId") int pId) {
		// professor following
		Professor prf = professorRepository.findById(prId).get();
		// professor being followed
		Professor pbf = professorRepository.findById(pId).get();
		prf.followProfessor(pbf);
		professorRepository.save(prf);
}
	
	//Get professors following professor having id prId
	@GetMapping("/api/professor/{prId}/following/professor")
	public Iterable<Professor> findProfessorsFollowingProfessor(@PathVariable("prId") int prId) {
			Professor professor = professorRepository.findById(prId).get();
			return professor.getFollowingProfessors();
	}
	
	//Get professors followed by professor having id prId
	@GetMapping("/api/professor/{prId}/followed/professor")
	public Iterable<Professor> findProfessorsFollowedProfessor(@PathVariable("prId") int prId) {
			Professor professor = professorRepository.findById(prId).get();
			return professor.getFollowedProfessors();
	}




}
