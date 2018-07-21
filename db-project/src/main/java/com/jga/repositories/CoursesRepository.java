package com.jga.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jga.models.Courses;


public interface CoursesRepository extends CrudRepository<Courses, Integer>{
	
	@Query("SELECT c FROM Courses c WHERE c.title=:title") List<Courses> 	
	findCourseByTitle(@Param("title") String title);

}
