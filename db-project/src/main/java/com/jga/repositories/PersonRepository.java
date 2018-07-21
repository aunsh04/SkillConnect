package com.jga.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import com.jga.models.Person;


public interface PersonRepository extends CrudRepository<Person, Integer> {
		@Query("SELECT p FROM Person p WHERE p.username=:username") Iterable<Person> 	
		findUserByUsername	(@Param("username") String p);

		@Query("SELECT p FROM Person p WHERE p.username=:username AND p.password=:password")
		Iterable<Person> findUserByCredentials(
		@Param("username") String username, 
		@Param("password") String password);

}
