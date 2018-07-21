(function () {
    angular
        .module("DBProject")
        .controller("BookController", bookController);

    function bookController(bservice,$routeParams) {
		var viewModel = this;
		
		viewModel.createBook = createBook;
		
		function init() {
			console.log($routeParams.term);
			console.log('init book');
			var promise = bservice.findBooksBySearch($routeParams.term);
			promise.then(function(response) {
				var books = response.data.items;
				if (books!=undefined) {
					console.log('going to create books');
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
		
		function createBook(book) {
			console.log(book);
			console.log('creating books');		
				bservice.postBooks(book);
			
		}
		
		
}
    
    
   	})();