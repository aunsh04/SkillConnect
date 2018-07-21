package com.jga.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import com.jga.models.Person;
import com.jga.models.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> { 
	@Query("SELECT p FROM Professor p WHERE p.username=:username and p.password=:password") Professor 	
	findUserByCred	(@Param("username") String p, @Param("password") String r);
	
	
	@Query("SELECT p FROM Professor p WHERE p.firstName=:firstName") List<Professor> 	
	findUserByname	(@Param("firstName") String p);
	
	
//	@Query("DELETE FROM PROFESSOR_BOOK p WHERE p.professor_id=:pid and p.book_id=:bid ") void 	
//	findbookend	(@Param("pid") int p , @Param("bid") String b  );

//	@Query("DELETE FROM Professor_Book p WHERE p.professor_id=:pid and p.book_id=:bid ") void 	
//	findbookend	(@Param("pid") int p , @Param("bid") String b );

}