(function () {
    angular
        .module("DBProject")
        .factory("CourseService", courseService);
    
        function courseService($http) {
        var api = {
            "findCoursesByTitle": findCoursesByTitle,
            "getUdacityCourses":getUdacityCourses,
            "postCourse":postCourse,
            "findCourse":findCourse,
            "postReview":postReview,
            "getStudentReview":getStudentReview
        };
        return api;


//        function findCoursesByName() {
////        		$http.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
//            var url = 'https://www.udemy.com/api-2.0/courses?search=python';
//            var results = $http.get(url, {
//                headers: {'Authorization': 'Basic Y1U2MW54RXIzd0VzWjNXNkE0clpxUm0yck1NdXcwVTJYZE9jVkpKYzpmaENiRVp1WjZBbHFrWUpZWTVPYXFWNmJsVUhoZHVLanlSOUtaMXFlSWpjUjZ2QUU1YmFIclBJRTRVVFZVeXpYakhoNGdDbVk4dFhJdkJwa3gxeTJjTmYyWkwzajhqRlF6TUVWSVlFcUVNQkJhbEdxS1ozVVpIRzRFNndMQ0RSbQ=='}
//            });
//            return results;
//        }
        
        function findCourse(id) {
	        	var results = $http.get('/api/courses/'+id);
	    		return results;
        }
        
        
        function findCoursesByTitle(title) {
	    		var results = $http.get('/api/courses/search/'+title);
	    		return results;
        }
        
        function getUdacityCourses() {
        		var url = 'https://www.udacity.com/public-api/v0/courses';
        		var results = $http.get(url);
        		return results;
        }
        
        function postCourse(course) {
        		var results = $http.post("/api/courses", course);
        		return results;
        }
        
        function postReview(review,sId,cId) {
	        	 var results = $http.post('/api/student/'+sId+'/course/'+cId+'/review',review);
	        	 return results;
        }
        
        
        function getStudentReview(cId) {
        		var results = $http.get('/api/courses/reviews/'+cId);
        		return results;
        }

    }
})();