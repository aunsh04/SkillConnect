package com.jga.repositories;
import org.springframework.data.repository.*;
import com.jga.models.Books;
import com.jga.models.Papers;

public interface PapersRepository extends CrudRepository<Papers, Integer> {
	
}
