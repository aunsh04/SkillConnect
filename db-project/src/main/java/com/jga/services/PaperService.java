package com.jga.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Courses;
import com.jga.models.Papers;
import com.jga.repositories.PapersRepository;

@RestController
public class PaperService {
	@Autowired
	PapersRepository papersRepository;
	
	@PostMapping("/api/papers")
	public Papers createBook(@RequestBody Papers paper) {
		return papersRepository.save(paper);
		
	}

	
	@PutMapping("/api/papers/{pid}")
	public Papers updatepaper(
			@PathVariable("pid") int id,
			@RequestBody Papers newpaper) {
		Optional<Papers> courses = papersRepository.findById(id);
		Papers r = courses.get();
		r.set(newpaper);
		return papersRepository.save(r);
		
	}
	
	
	@DeleteMapping("/api/papers/{pId}")
	public void deletebook
	(@PathVariable("pId") int id) {
		papersRepository.deleteById(id);
	}
}
