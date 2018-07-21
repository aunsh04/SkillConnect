package com.jga.models;

import java.io.Serializable;

public class StudentCourseReviewPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private int studentId;

    private int courseId;
     
     
	public int hashCode() {
		return (int) (studentId + courseId);
	}

	public boolean equals(Object object) {
		if (object instanceof StudentCourseReviewPK) {
			StudentCourseReviewPK otherId = (StudentCourseReviewPK) object;
			return (otherId.studentId == this.courseId) && (otherId.studentId == this.courseId);
		}
		return false;
	}

}
