(function() {
    angular
    .module('DBProject')
    .controller("LoggedinController", loggedinController);
    
    function loggedinController(UserService,$routeParams) {
        var viewModel = this
    	console.log($routeParams);
        viewModel.hello = "hello from MovieDetailsController";
        viewModel.movieTitle = $routeParams.tid;
        if($routeParams.type == "r"){
        	console.log("a")
        	var id = $routeParams.tid
			var promise = UserService.getrecbyid(id);
			promise.then(function(response) {
				console.log("u")
				viewModel.type="r"
				console.log(response.data);
				viewModel.id = response.data.id;
				viewModel.name = response.data.firstName;
				viewModel.last = response.data.lastName;
				viewModel.age = response.data.age;
				viewModel.comp = response.data.companyname;
				viewModel.address = response.data.address;
				viewModel.city=response.data.city;
				viewModel.gender=response.data.gender;
				if(viewModel.gender==1){
					viewModel.gender="Male"
				}
				else {
					viewModel.gender="Female"
				}
				viewModel.email = response.data.email;
				viewModel.state = response.data.state;

			})
        }
        else if($routeParams.type == "s"){
        	console.log("a")
        	var id = $routeParams.tid
			var promise = UserService.getstudbyid(id);
			promise.then(function(response) {
				console.log("u")
				viewModel.type="s"
				console.log(response.data);
				viewModel.id = response.data.id;
				viewModel.name = response.data.firstName;
				viewModel.last = response.data.lastName;
				viewModel.age = response.data.age;
				viewModel.address = response.data.address;
				viewModel.city=response.data.city;
				viewModel.gender=response.data.gender;
				if(viewModel.gender==1){
					viewModel.gender="Male"
				}
				else {
					viewModel.gender="Female"
				}
				viewModel.email = response.data.email;
				viewModel.state = response.data.state;
				viewModel.highestdegree = response.data.highestdegree;
				viewModel.uni = response.data.universityname;
				viewModel.major = response.data.major;
				viewModel.s1 = response.data.desc1;
				viewModel.s2 = response.data.desc2;

			})
        }
        else if($routeParams.type == "a"){
        	console.log("a")
        	var id = $routeParams.tid
			var promise = UserService.getrecbyid(id);
			promise.then(function(response) {
				console.log("u")
				viewModel.type="a"
				console.log(response.data);
				viewModel.id = response.data.id;
				
    })
        }
        else{
        	console.log("a")
        	var id = $routeParams.tid
			var promise = UserService.getprofbyid(id);
			promise.then(function(response) {
				
					
				console.log("u")
				viewModel.type="p"
				console.log(response.data);
				viewModel.id = response.data.id;
				viewModel.name = response.data.firstName;
				viewModel.last = response.data.lastName;
				viewModel.age = response.data.age;
				viewModel.address = response.data.address;
				viewModel.city=response.data.city;
				viewModel.gender=response.data.gender;
				viewModel.profat=response.data.profat;
				viewModel.profd=response.data.profdegree;
				if(viewModel.gender==1){
					viewModel.gender="Male"
				}
				else {
					viewModel.gender="Female"
				}
				viewModel.email = response.data.email;
				viewModel.state = response.data.state;
				//set followers with id
				var followPromise = UserService.getstudentsfollprof(id);
				followPromise.then(function(followerResponse) {
					console.log('getting followers');
					console.log(followerResponse.data);
					viewModel.followers = followerResponse.data;
				})
				
				
				var uploadPromise = UserService.getpapersByProf(id);
				uploadPromise.then(function(uploadResponse) {
					console.log('getting papers');
					console.log(uploadResponse.data);
					viewModel.papersUploaded = uploadResponse.data;
				})
				
				var profFollowprofPromise = UserService.getproffollprof(id);
				profFollowprofPromise.then(function(profFollowProfResponse) {
					console.log('getting profs following this prof');
					console.log(profFollowProfResponse.data);
					viewModel.profsFollowing = profFollowProfResponse.data;
				})
				
				var profFollowByprofPromise = UserService.getproffollbyprof(id);
				profFollowByprofPromise.then(function(profFollowByProfResponse) {
					console.log('getting profs followed by this prof');
					console.log(profFollowByProfResponse.data);
					viewModel.profsFollowedByProf = profFollowByProfResponse.data;
				})
								var endorsedBookListPromise = UserService.getbooksEndorsedByProf(id);
				endorsedBookListPromise.then(function(endorsedBookListResponse) {
					console.log('getting books endorsed by this prof');
					console.log(endorsedBookListResponse.data);
					viewModel.endorsedBooksByProf = endorsedBookListResponse.data;
				})
				

			
					
			
    })
        	
        }
    }
})();