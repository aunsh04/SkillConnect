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

import com.jga.models.Person;

import com.jga.repositories.PersonRepository;

@RestController
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	
	@GetMapping("/api/person")	
	public List<Person> findAllUsers(
			
			@RequestParam(name="username", required=false) String username,
				@RequestParam(name="password", required=false) String password)
	
	
	{
		if(username != null && password != null) {
			return (List<Person>) personRepository.findUserByCredentials(username, password);
		}
		return (List<Person>) personRepository.findAll();
	}

	
	@GetMapping("/api/person/{name}")	
	public List<Person> findbyusername(
			
			@RequestParam(name="username", required=false) String username)
				
	
	
	{
		if(username != null) {
			return (List<Person>) personRepository.findUserByUsername(username);
		}
		return null;
	}


	
	@GetMapping("/api/person/{personid}")
	public Optional<Person> findUserById(@PathVariable("personid") int personid){
		return personRepository.findById(personid);
	}
	
	
	
	@PutMapping("/api/person/{personId}")
	public Person updateUser(
			@PathVariable("personId") int id,
			@RequestBody Person newPerson) {
		Optional<Person> person = personRepository.findById(id);
		Person p = person.get();
		p.set(newPerson);
		return personRepository.save(p);
		
	}
	
	@PostMapping("/api/person")
	public Person createUser(@RequestBody Person user) {
		return personRepository.save(user);
		
	
	}
	
	@DeleteMapping("/api/person/{personId}")
	public void deleteUser
	(@PathVariable("personId") int id) {
		personRepository.deleteById(id);
	}



}
