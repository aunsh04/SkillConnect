(function () {
    angular
        .module("DBProject")
        .controller("ProfProffollowController", proffollowController);

    function proffollowController(UserService,$routeParams) {
		var viewModel = this;
		function init() {
			console.log($routeParams.profname);
			viewModel.profname = $routeParams.profname;
			viewModel.pid = $routeParams.pid;
			console.log('init prof');
			var promise = UserService.findprofsbyname($routeParams.profname);
			promise.then(function(response) {
				var profs = response.data;
				console.log(profs);
		
				if (profs!=undefined) {
					viewModel.profs = profs;
				}
			});
		}
		init();
}
    
    
   	})();