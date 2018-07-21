package com.jga.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import com.jga.models.Student;

public interface StudentRepository extends CrudRepository <Student, Integer> {
	
	@Query("SELECT p FROM Student p WHERE p.username=:username and p.password =:password") Student 	
	findUserByCred(@Param("username") String p, @Param("password") String r);
	
	@Query("SELECT p FROM Student p WHERE p.desc1=:one or p.desc2 =:one") List<Student> 	
	findUserByskill(@Param("one") String p);

}
