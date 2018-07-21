/**
 * 
 */(function () {
    angular
        .module("DBProject")
        .controller("AdminController", adminController);

    function adminController(UserService, $location,$scope,$routeParams) {
    	var viewModel = this;
    	viewModel.recdel = recdel;
    	viewModel.profdel = profdel;
    	viewModel.studdel = studdel;
    	viewModel.updatestud = updatestud;
    	viewModel.updaterec = updaterec;
    	viewModel.updateprof = updateprof;
    	viewModel.updatebook = updatebook;
    	viewModel.bookdel = bookdel;
    	viewModel.endorsedbookdel = endorsedbookdel;
    	viewModel.coursedel = coursedel;
    	viewModel.coursereviewrem = coursereviewrem;
    	
    	viewModel.studid = $routeParams.studid
    	viewModel.profid = $routeParams.pid
    	viewModel.recid = $routeParams.rid
    	viewModel.bookid = $routeParams.bid
    	viewModel.courseid = $routeParams.cid
    
    	
				function init() {
					
		    		console.log("a")
					var promise = UserService.adminrec();
					promise.then(function(response) {
						console.log(response.data);
						viewModel.recru = response.data;
					})
					var promise = UserService.adminprof();
						promise.then(function(response) {
							console.log(response.data);
							viewModel.prof = response.data;
						})
					var promise = UserService.adminstud();
						promise.then(function(response) {
						console.log(response.data);
						viewModel.stud = response.data;
						})	
					
					var promise = UserService.adminbooks();
						promise.then(function(response) {
						console.log(response.data);
						viewModel.books = response.data;
						})
					var promise = UserService.admincourse();
					promise.then(function(response) {
					console.log(response.data);
					viewModel.courses = response.data;
						})
					
					
				}
				init();
    
    
	
	
		function endorsedbookdel(pid,bid) {
			var promise = UserService.endorsedbookdel(pid,bid);			
		}	
		
		function coursereviewrem(sid,cid){
			var promise = UserService.coursereviewrem(sid,cid);
		}
	
		function bookdel(id) {
			var promise = UserService.delbook(id);			
		}
		function coursedel(id) {
			var promise = UserService.delcourse(id);			
		}
		function updatecourse(course,id) {
			var promise = UserService.updcourse(id,course);
			promise.then(function(response) {
				$location.url("/courselistforadmin")
				
			});
			
			
		}
		
		function updatebook(book,id) {
			var promise = UserService.updbook(id,book);
			promise.then(function(response) {
				$location.url("/bookslistforadmin")
				
			});
		}
		
	
	
	function updateprof(user,id) {
		console.log("a")
		var promise = UserService.updprof(id,user);
		promise.then(function(response) {
			$location.url("/proflistforadmin")
			
		});
	}
	function updaterec(user,id) {
		console.log("a")
		var promise = UserService.updrec(id,user);
		promise.then(function(response) {
			$location.url("/reclistforadmin")
			
		});
	}
	function updatestud(user,id) {
		console.log("a")
		var promise = UserService.updstud(id,user);
		promise.then(function(response) {
			$location.url("/studlistforadmin")
			
		});
	}
	
	function profdel(id) {
		console.log("a")
		var promise = UserService.delprof(id);
		
	}
	function recdel(id) {
		console.log("a")
		var promise = UserService.delrec(id);
		
	}
	function studdel(id) {
		console.log("a")
		var promise = UserService.delstud(id);
		
	
	}
    }
    
   	})();