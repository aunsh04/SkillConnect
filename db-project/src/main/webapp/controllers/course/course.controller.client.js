(function () {
    angular
        .module("DBProject")
        .controller("CourseController", courseController);

    
    function courseController(CourseService,$routeParams) {
		var viewModel = this;
		
		viewModel.createCourse = createCourse;
		
		function init() {
			console.log($routeParams.term);
			console.log('init course');
			viewModel.sId = $routeParams.sid;
			var promise = CourseService.findCoursesByTitle($routeParams.term);
			promise.then(function(response) {
				var courses = response.data;
				if (courses!=undefined) {
					console.log(courses);
					viewModel.courses = courses;
				}
			});
		}
		init();

		function createCourse(course) {
	    	console.log(course);
	    	console.log('creating course');		
	    	CourseService.postCourse(course);
	    	
	    }
}
    
    
   	})();




// controller to store courses from Udacity
//(function () {
//    angular
//        .module("DBProject")
//        .controller("CourseController", courseController);
//
//    function courseController(CourseService) {
//		var viewModel = this;
//		
//		function init() {
//			console.log('hi');
////			var promise = CourseService.findCoursesByName();
//			
//			var promise = CourseService.getUdacityCourses();
//			promise.then(function(response) {
////				response.header("Access-Control-Allow-Origin", "*");
//				var courses = response.data;
//				if (courses!=undefined) {
//					viewModel.courses = courses;
//					createCourses(courses);
//				}
//			});
//		}
//		init();
//		
//		function createCourses(courses) {
//			var c = courses.courses;
//			console.log(c);
//			console.log('creating courses');
//			var i;
//			for (i = 0; i < c.length; i++) { 
//				console.log(c[i]);
//				var course = {
//						title:c[i].title,
//						courseURL:c[i].homepage,
//						imageURL:c[i].image,
//						summary:c[i].short_summary,
//						youTubeUrl:c[i].teaser_video.youtube_url
//				};
//
//				CourseService.postCourse(course);
//			}
//			
//		}
//		
//		
//}
//    
//    
//   	})();