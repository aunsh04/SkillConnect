package com.jga.repositories;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jga.models.StudentCourseReview;


public interface StudentCourseReviewRepository extends CrudRepository<StudentCourseReview, Integer> { 
	
	  @Transactional
	  @Modifying
	@Query("DELETE FROM StudentCourseReview p WHERE p.courseId=:cid and p.studentId=:sid ") void 	
	delReview(@Param("cid") int cid , @Param("sid") int sid);
	
}