(function () {
    angular
        .module("DBProject")
        .controller("Profbookcontroller", profbookController);

    function profbookController(bservice,$routeParams) {
		var viewModel = this;
		
		
		
		function init() {
			viewModel.profid= $routeParams.id;
			viewModel.bookterm=$routeParams.term;
			
			console.log('init book');
			var promise = bservice.findBooksBySearch($routeParams.term);
			promise.then(function(response) {
				var books = response.data.items;
				console.log(books);
				if (books!=undefined) {
					createBooks(books);
					viewModel.books = books;
					
				}
			});
		}
		init();
		
		
		function createBooks(books) {
			console.log(books);
			console.log('creating books');
			var i;
			for (i = 0; i < books.length; i++) { 
				var book = {
						id:books[i].id,
						title:books[i].volumeInfo.title
				};
				bservice.postBooks(book);
			}
			
		}
		
}
    
    
    
   	})();