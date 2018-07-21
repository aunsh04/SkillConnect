(function () {
    angular
        .module("DBProject")
        .controller("CourseDetailsController", courseDetailsController);

    function courseDetailsController(CourseService,UserService,$routeParams) {
		var viewModel = this;
		var sId = $routeParams.sid;
		var cId = $routeParams.courseid;
		
		viewModel.sId  = sId;
		viewModel.cId = cId;
		
		viewModel.review = review;
		
		function init() {
			console.log('init course');
			console.log(cId);
			var promise = CourseService.findCourse(cId);
			console.log('init book');
			promise.then(function(response) {
				var courses = response.data;
				console.log(courses);
				if (courses!=undefined) {
					viewModel.courses = courses;
				}
//				getEndorse(bId);
				
				getReviews(cId);
				
			});
		}
		init();
		
		function review(review,sId,cId) {
			CourseService.postReview(review,sId,cId);
		}
		
		function getReviews(cId) {
			var promise = CourseService.getStudentReview(cId);
			promise.then(function(response) {
				var reviews = response.data;
				console.log(reviews);
				var i;
				var studNames = [];
				var studReviews = [];
				for (i = 0; i < reviews.length; i++) { 
					studReviews[i] = reviews[i].review;
					console.log(studReviews[i]);
					var studPromise = UserService.getstudbyid(reviews[i].studentId);
					studPromise.then(function(response) {
						var studName = response.data.firstName;
						console.log(studName);
						studNames[i] = studName;
					})
					
				}
				if (studNames!=undefined) {
					viewModel.studNames = studNames;
				}
				if (studReviews!=undefined) {
					viewModel.reviewsContent = studReviews;
				}
				
			});
		}
}
    
    
   	})();