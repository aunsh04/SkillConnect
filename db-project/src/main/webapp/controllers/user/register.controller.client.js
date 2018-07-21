(function () {
    angular
        .module("DBProject")
        .controller("RegisterController", registerController);

    function registerController(UserService) {
    		var viewModel = this;
    		
    		//event handler
    		viewModel.register = register;
    		
    		
    		
    		function register(user,a) {
    			var promise = UserService.registerUser(user,a);
    			promise.then(function(response) {
    				
    			});
    		}
    		
    }
    
    
   	})();