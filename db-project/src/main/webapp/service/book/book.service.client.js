(function () {
    angular
        .module("DBProject")
        .factory("bservice", bookService);
    
        function bookService($http) {
        var api = {
            "findBooksBySearch": findBooksBySearch,
            "findBook":findBook,
            "endo":endo,
            "findProfEndorsements":findProfEndorsements,
            "postBooks":postBooks
        };
        return api;

        function findProfEndorsements(id) {
            var url = '/api/books/professor/'+id;
            var results = $http.get(url);
            return results;
        }
        
        
        function findBook(id) {
            var url = 'https://www.googleapis.com/books/v1/volumes/'+id;
            var results = $http.get(url);
            return results;
        }

        function findBooksBySearch(term) {
            var url = 'https://www.googleapis.com/books/v1/volumes?q='+term;
            var results = $http.get(url);
            return results;
        }

        function endo(bId,pid) {
            var url = "/api/professor/" +pid+"/book/"+bId;
            var results = $http.post(url);
            return results;
        }
        
        
        function postBooks(book) {
        		console.log('in front end service');
        		var url = $http.post("/api/books", book);
        }
        

    }
})();

