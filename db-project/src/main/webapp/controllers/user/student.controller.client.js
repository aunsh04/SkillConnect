(function () {
    angular
        .module("DBProject")
        .controller("StudentController", studentController);

    function studentController(StudentService, $routeParams) {
    		var viewModel = this;
    		viewModel.a = $routeParams.id
    		function init() {
    			console.log(a);
    			console.log(viewModel.a);
    			var promise = StudentService.getAllstudent(a);
    			
    			promise.then(function(response) {
    				var student = response.data;
    				if (student!=undefined) {
    					console.log(student.firstName);
    					viewModel.rahul = student;
    				}
    			});
    		}
    		init();
    }
    
    
   	})();