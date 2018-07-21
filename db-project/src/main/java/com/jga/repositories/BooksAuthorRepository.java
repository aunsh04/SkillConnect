package com.jga.repositories;
import org.springframework.data.repository.*;

import com.jga.models.BookAuthor;

public interface BooksAuthorRepository extends CrudRepository<BookAuthor, Integer> {
	
}
