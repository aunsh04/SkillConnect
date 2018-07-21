(function () {
    angular
        .module("DBProject")
        .controller("PaperDetailsController", paperDetailsController);

    function paperDetailsController(pservice,$routeParams) {
		var viewModel = this;
		var pId = $routeParams.paperid;
		function init() {
			console.log('init paper');
			console.log(pId);
			var promise = pservice.findPaper(pId);
			console.log('init paper');
			promise.then(function(response) {
				var papers = response.data.data;
				console.log(papers);
				if (papers!=undefined) {
					viewModel.papers = papers;
				}
			
			});
		}
		init();
		
}
    
    
   	})();