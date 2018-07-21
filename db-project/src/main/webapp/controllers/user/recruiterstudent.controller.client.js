(function () {
    angular
        .module("DBProject")
        .controller("RecruiterStudentController", recruiterStudentController);

    function recruiterStudentController(UserService,$routeParams) {
		var viewModel = this;
		function init() {
			console.log($routeParams.skilll);
			
			var promise = UserService.findStudentbyskill($routeParams.skilll);
			promise.then(function(response) {
				var books = response.data;
				console.log(books);
//				var volumeInfo = [];
//				angular.forEach(books, function(value, key){
//				     console.log(key + ': ' + value.volumeInfo);
//				     volumeInfo.push(value.volumeInfo);
//				});
//				console.log(volumeInfo);
//			     if (volumeInfo!=undefined) {
//			    	 	viewModel.help = volumeInfo;
//			     }
				if (books!=undefined) {
					viewModel.books = books;
				}
//				$location.url("/books/"+books.id);
			});
		}
		init();
}
    
    
   	})();