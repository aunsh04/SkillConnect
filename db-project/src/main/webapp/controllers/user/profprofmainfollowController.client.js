(function () {
    angular
        .module("DBProject")
        .controller("ProfProfMainFollowController", mainFollowController);

    function mainFollowController(UserService,$routeParams) {
    		var viewModel = this;
    		
    		//event handler
    		viewModel.proffollowprof = proffollowprof;
    		
    		
    		viewModel.prid = $routeParams.prid
    		viewModel.pid = $routeParams.pid
    		
    		function proffollowprof(prid,pid){
    			console.log(prid);
    			console.log(pid);
    			var promise= UserService.proffollowprof(prid,pid);
    			promise.then(function(response) {
    				
    			});
    		}
}
    
    
   	})();
    		