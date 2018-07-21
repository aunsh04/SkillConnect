(function () {
    angular
        .module("DBProject")
        .controller("LoginController", loginController);

    function loginController(UserService, $location,$scope,$routeParams) {
    		var viewModel = this;
    		
    		
    		//event handler
    		viewModel.rlogin = rlogin;
    		viewModel.slogin = slogin;
    		viewModel.plogin = plogin;
    		viewModel.alogin = alogin;
    		

    		function rlogin(u,p) {
    			console.log("a")
    			var promise = UserService.getrec(u,p);
    			promise.then(function(response) {
    				if(response.data.id == undefined){

    					console.log("sssssss")
    					$location.url("/errorpage")
    				}
    				else{
    				console.log(response.data);
    				viewModel.rec = response.data.id;
    				var r ="r"
    				console.log(viewModel.rec);
    				var a = viewModel.rec;
    				$location.url("/loggedinuser/"+a+"/"+r)
    				}
    			});
    		}
    		
    		function alogin(u,p) {
    			console.log("a")
    			if (u== "admin" && p == "admin"){
    			var promise = UserService.getrec(u,p);
    			promise.then(function(response) {
    				console.log(response.data);
    				viewModel.rec = response.data.id;
    				var r ="a"
    				console.log(viewModel.rec);
    				var a = viewModel.rec;
    				$location.url("/adminhome")
    			
    			
    			});
    			}
    			else{
    				$location.url("/errorpage")
    			}
    		}
    		
    		function slogin(u,p) {
    			
    			var promise = UserService.getstud(u,p);
    			console.log(u)
    			promise.then(function(response) {
    				if(response.data.id == undefined){

    					console.log("sssssss")
    					$location.url("/errorpage")
    				}
    				else{
    					console.log(response.data);
        				
        				viewModel.rec = response.data.id;
        				var s ="s"
            			console.log(s);
            			var a = viewModel.rec;
            			$location.url("/loggedinuser/"+a+"/"+s)
        				
    				}
    				});
    		}
    		function plogin(u,p) {
    			
    			var promise = UserService.getprof(u,p);
    			promise.then(function(response) {
    				if(response.data.id == undefined){

    					console.log("sssssss")
    					$location.url("/errorpage")
    				}
    				else{
    				console.log(response.data);
    				viewModel.rec = response.data.id;
    				var p ="p"
        			console.log(viewModel.rec);
        			var a = viewModel.rec;
        			$location.url("/loggedinuser/"+a+"/"+p)
    				}
    			});
    		}
    }
    
    
   	})();