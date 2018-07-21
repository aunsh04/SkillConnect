(function () {
    angular
        .module("DBProject")
        .controller("MainFollowController", mainFollowController);

    function mainFollowController(UserService,$routeParams) {
    		var viewModel = this;
    		
    		//event handler
    		viewModel.followprof = followprof;
    		
    		
    		viewModel.sid = $routeParams.studid
    		viewModel.pid = $routeParams.pid
    		
    		function followprof(sid,pid){
    			console.log(sid);
    			console.log(pid);
    			var promise= UserService.followprof(sid,pid);
    			promise.then(function(response) {
    				
    			});
    		}
}
    
    
   	})();
    		