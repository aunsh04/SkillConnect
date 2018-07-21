(function () {
    angular
        .module("DBProject")
        .controller("PaperController", paperController);

    function paperController(pservice,$routeParams) {
		var viewModel = this;
		function init() {
			console.log($routeParams.term);
			console.log('init paper');
			var promise = pservice.findPapersBySearch($routeParams.term);
			promise.then(function(response) {
				var papers = response.data.data;
				console.log(papers);
//				createPapers(papers);
				if (papers!=undefined) {
					viewModel.papers= papers;
				}
			});
		}
		init();
		
		
//		function createPapers(papers) {
//			console.log(papers);
//			console.log('creating papers');
//			var i;
//			for (i = 0; i < papers.length; i++) { 
//				pservice.postPapers(papers[i]);
//			}
//			
//		}
    }
})();