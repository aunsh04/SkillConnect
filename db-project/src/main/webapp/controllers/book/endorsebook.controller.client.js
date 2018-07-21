(function () {
    angular
        .module("DBProject")
        .controller("EndorsebookController", endorsebookcontroller);

    function endorsebookcontroller(bservice,$routeParams) {
    		var viewModel = this;
    		
    		//event handler
    		viewModel.endorsebook = endorsebook;
    		
    		
    		viewModel.bid = $routeParams.bid
    		viewModel.pid = $routeParams.pid
    		
    		function endorsebook(bid,pid){
    			console.log(pid);
    			console.log(bid);
    			var promise= bservice.endo(pid,bid);
    			promise.then(function(response) {
    				
    			});
    		}
}
    
    
   	})();
    		