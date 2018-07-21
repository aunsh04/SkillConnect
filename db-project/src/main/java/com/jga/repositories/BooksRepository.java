package com.jga.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import com.jga.models.Books;


public interface BooksRepository extends CrudRepository<Books, String> {
	
//	@Query("DELETE FROM Professor_Book p WHERE p.professor_id=:pid and p.book_id=:bid ") void 	
//	findbookend	(@Param("pid") int p , @Param("bid") String b );
}
