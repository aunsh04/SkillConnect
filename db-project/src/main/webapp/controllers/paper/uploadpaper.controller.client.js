(function () {
    angular
        .module("DBProject")
        .controller("UploadController", uploadController);

    function uploadController(pservice,$routeParams) {
    		var viewModel = this;
    		var profId = $routeParams.pid;
    		
    		
    		//event handler
    		viewModel.upload = upload;
    		
    		
    		
    		function upload(paper) {
    			pservice.postPapers(paper);
    			addPaperToProfessor(paper);
    		}
    		
    		function addPaperToProfessor(paper) {
    			console.log(paper);
    			console.log('adding professsor to paper');
    			pservice.addPaperToProf(paper,profId);	
    		}
    		
    }
    
    
   	})();