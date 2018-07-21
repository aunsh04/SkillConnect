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

import com.jga.models.BookAuthor;
import com.jga.models.Books;
import com.jga.models.Person;
import com.jga.models.Professor;
import com.jga.repositories.BooksAuthorRepository;
import com.jga.repositories.BooksRepository;
import com.jga.repositories.ProfessorRepository;
import com.jga.repositories.ProfessorRepository;

@RestController
public class BooksService {
	@Autowired
	BooksRepository booksRepository;
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	BooksAuthorRepository booksAuthorRepository;

	@GetMapping("/api/books")
	public List<Books> findAllbooks() {
		return (List<Books>) booksRepository.findAll();
	}
	
	@PostMapping("/api/books")
	public Books createBook(@RequestBody Books book) {
		return booksRepository.save(book);
		
	}
	
	
	@GetMapping("/api/books/{bookId}")
	public Optional<Books> findUserById
	
	(@PathVariable("bookId") String id) {
	 
		return booksRepository.findById(id);
	}
	
	
	@PostMapping("/api/book/{bId}/professor/{pId}")
	public void endorseBookByProfessor(
			@PathVariable("bId") String bId,
			@PathVariable("pId") int pId) {
		Books books = booksRepository.findById(bId).get();
		Professor professor = professorRepository.findById(pId).get();
		books.addProfessorEndorsement(professor);
		booksRepository.save(books);
}


	
	@PutMapping("/api/books/{bId}/authored/{aId}")
	public void authoredCourse(
			@PathVariable("bId") String bId,
			@PathVariable("aId") int aId) {
		Books book = booksRepository.findById(bId).get();
		BookAuthor author = booksAuthorRepository.findById(aId).get();
		book.authoredBook(author);
		booksRepository.save(book);
		author.setAuthorBook(book);
		booksAuthorRepository.save(author);
	}
	
	
	@GetMapping("/api/books/professor/{bId}")
	public List<Professor> 
findProfessorsEndorsingBook(@PathVariable("bId") String bId) {
		Books book = booksRepository.findById(bId).get();
		return book.getEndorsedProfessors();
}

		
	@PutMapping("/api/books/{bid}")
	public Books updatebooks(
			@PathVariable("bid") String id,
			@RequestBody Books newbook) {
		Optional<Books> books = booksRepository.findById(id);
		Books r = books.get();
		r.set(newbook);
		return booksRepository.save(r);
		
	}
	
	
//	@DeleteMapping("/api/books/prof/enddel/{pid}/{bid}")
//	public void deleterelation
//	(@PathVariable("bId") String bid,
//	@PathVariable("pId") int pid){
//		booksRepository.findbookend(pid, bid);
//	}
	
	@DeleteMapping("/api/books/{bId}")
	public void deletebook
	(@PathVariable("bId") String id) {
		booksRepository.deleteById(id);
	}
	
	@GetMapping("/api/books/{bookId}/authors")
	public List<BookAuthor> findCourseAuthors(@PathVariable("bookId") String id) {
		Optional<Books> book = booksRepository.findById(id);
		System.out.println(book.get());
		return book.get().getAuthors();
	}
}
