(function () {
    angular
        .module("DBProject")
        .factory("pservice", paperService);
    
    function paperService($http) {
        var api = {
            "findPapersBySearch": findPapersBySearch,
            "findPaper":findPaper,
            "postPapers":postPapers,
            "addPaperToProf":addPaperToProf
        };
        return api;
        
        
        function addPaperToProf(paper,prId) {
     		console.log('in front end service');
     		var url = $http.put('/api/person/professor/'+prId+'/upload', paper);
     } 
        
        function findPapersBySearch(term) {
            var url = 'https://core.ac.uk:443/api-v2/articles/search/'+term+'?page=1&pageSize=10&metadata=true&fulltext=false&citations=false&similar=false&duplicate=false&urls=false&faithfulMetadata=false&apiKey=ego98X2jEvL6taW0NFSRBnhVPOGZpxHb';
            var results = $http.get(url);
            return results;
        }
        
         function findPaper(id) {
            var url = 'https://core.ac.uk:443/api-v2/articles/get/'+id+'?metadata=true&fulltext=false&citations=false&similar=false&duplicate=false&urls=false&faithfulMetadata=false&apiKey=ego98X2jEvL6taW0NFSRBnhVPOGZpxHb';
            var results = $http.get(url);
            return results;
        }
         
         function postPapers(paper) {
     		console.log('in front end service');
     		var url = $http.post("/api/papers", paper);
     } 
        
        
    }
})();


