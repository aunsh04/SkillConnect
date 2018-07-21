(function () {
    angular
        .module("DBProject")
        .controller("BookDetailsController", bookDetailsController);

    function bookDetailsController(bservice,$routeParams) {
		var viewModel = this;
		var bId = $routeParams.bookid;
		function init() {
			console.log('init book');
			console.log(bId);
			var promise = bservice.findBook(bId);
			console.log('init book');
			promise.then(function(response) {
				var books = response.data.volumeInfo;
				console.log(books);
				if (books!=undefined) {
					viewModel.books = books;
				}
				getEndorse(bId);
			});
		}
		init();
		
		function getEndorse(bId) {
			console.log('init review');
			console.log(bId);
			var promise = bservice.findProfEndorsements(bId);
			promise.then(function(response) {
				var endorsements = response.data;
				console.log(endorsements);
				if (endorsements!=undefined) {
					viewModel.endorsements = endorsements;
				}
			});
		}
}
    
    
   	})();