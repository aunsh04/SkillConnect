package com.jga.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import com.jga.models.Recruiter;
import com.jga.models.Person;
import com.jga.models.Professor;

public interface RecruiterRepository extends CrudRepository<Recruiter, Integer> { 

	@Query("SELECT p FROM Recruiter p WHERE p.username=:username and p.password=:password") Recruiter 	
	findUserByCred	(@Param("username") String p, @Param("password") String r);
}
