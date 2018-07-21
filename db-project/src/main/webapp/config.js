(function () {
    angular
        .module("DBProject")
        .config(configuration);

    function configuration($routeProvider, $httpProvider) {
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
        $httpProvider.defaults.headers.put['Content-Type'] = 'application/json;charset=utf-8';

        $routeProvider
            
            .when("/home", {
             templateUrl: 'templates/user/home.view.html',
            controller: "LoginController",
            controllerAs: "model",
            })
            
            
            .when("/admin", {
             templateUrl: 'templates/admin/adminhome.view.html',
            controller: "AdminController",
            controllerAs: "model",
            }) 
            .when("/admin/student/:studid", {
             templateUrl: 'templates/admin/adminstudup.view.html',
            controller: "AdminController",
            controllerAs: "model",
            })
       
             .when("/admin/professor/:pid", {
            templateUrl: 'templates/admin/adminprofup.view.html',
           controller: "AdminController",
           controllerAs: "model",
           }) 
            .when("/admin/recruiter/:rid", {
            templateUrl: 'templates/admin/adminrecruup.view.html',
           controller: "AdminController",
           controllerAs: "model",
           })
           
           .when("/admin/book/:bid", {
            templateUrl: 'templates/admin/adminbookup.view.html',
           controller: "AdminController",
           controllerAs: "model",
           }) 
           
           .when("/admin/course/:cid", {
            templateUrl: 'templates/admin/admincourseup.view.html',
           controller: "AdminController",
           controllerAs: "model",
           }) 
           
           
           
            .when("/adminhome", {
             templateUrl: 'templates/admin/adminhomemain.view.html',
            controller: "AdminController",
            controllerAs: "model",
            }) 
            
           
        .when("/reclistforadmin", {
             templateUrl: 'templates/admin/adminreclist.view.html',
            controller: "AdminController",
            controllerAs: "model",
            })
            
            .when("/proflistforadmin", {
             templateUrl: 'templates/admin/adminproflist.view.html',
            controller: "AdminController",
            controllerAs: "model",
            })
        	.when("/studlistforadmin", {
             templateUrl: 'templates/admin/adminstudlist.view.html',
            controller: "AdminController",
            controllerAs: "model",
            })
            
            .when("/admincreateuser",{
                templateUrl: 'templates/user/admincreateuser.view.html',
                controller: 'RegisterController',
                controllerAs: 'model',
                
            })
            
            .when("/admincreatebook",{
                templateUrl: 'templates/admin/admincreatebook.view.html',
                controller: 'BookController',
                controllerAs: 'model',
                
            })
              .when("/admincreatecourse",{
                templateUrl: 'templates/admin/admincreatecourse.view.html',
                controller: 'CourseController',
                controllerAs: 'model',
                
            })
            .when("/courselistforadmin",{
                templateUrl: 'templates/admin/admincourselist.view.html',
                controller: 'AdminController',
                controllerAs: 'model',
                
            })
            
            
            
            .when("/bookslistforadmin",{
                templateUrl: 'templates/admin/adminbooklist.view.html',
                controller: 'AdminController',
                controllerAs: 'model',
                
            })
            .when("/errorpage",{
                templateUrl: 'templates/user/errorpage.view.html',
                controller: 'RegisterController',
                controllerAs: 'model',
                
            })
            .when("/login", {
                templateUrl: 'templates/user/login.view.html',
                controller: "LoginController",
                controllerAs: "model",
            })
            .when("/slogin", {
                templateUrl: 'templates/user/slogin.view.html',
                controller: "LoginController",
                controllerAs: "model",
            })
            .when("/plogin", {
                templateUrl: 'templates/user/plogin.view.html',
                controller: "LoginController",
                controllerAs: "model",
            })
            .when("/rlogin", {
                templateUrl: 'templates/user/rlogin.view.html',
                controller: "LoginController",
                controllerAs: "model",
            })
            .when("/alogin", {
                templateUrl: 'templates/user/alogin.view.html',
                controller: "LoginController",
                controllerAs: "model",
            })
            
            .when('/loggedinuser/:tid/:type', {
                templateUrl: 'templates/user/loggedinuse.view.html',
                controller: "LoggedinController",
                controllerAs: 'model'
            })
             .when('/prof/:id/bookserch/:term', {
                templateUrl: 'templates/book/proforrecbook.view.html',
                controller: "Profbookcontroller",
                controllerAs: 'model'
            })
            
            .when('/prof/:pid/upload', {
                templateUrl: 'templates/paper/professoruploadpaper.view.html',
                controller: "UploadController",
                controllerAs: 'model'
            })
            
            
            .when("/loggedinuser", {
                templateUrl: 'templates/user/loggedinuse.view.html',
                controller: 'LoginController',
                controllerAs: "model",
            })
            .when("/rec/student/skill/:skilll", {
                templateUrl: 'templates/user/studentlist.view.html',
                controller: 'RecruiterStudentController',
                controllerAs: "model",
            })
            .when("/studentreg",{
                templateUrl: 'templates/user/studentreg.view.html',
                controller: 'RegisterController',
                controllerAs: "model",
            })
            
            .when("/prof/:bid/:pid",{
            	templateUrl: 'templates/book/profen.view.html',
            	controller: 'EndorsebookController',
            	controllerAs: "model",
        	})
        
        	.when("/searchforbooks/:",{
                templateUrl: 'templates/user/studentreg.view.html',
                controller: 'RegisterController',
                controllerAs: "model",
            })
            
            .when("/professorreg",{
                templateUrl: 'templates/user/professorreg.view.html',
                controller: 'RegisterController',
                controllerAs: "model",
            })
            .when("/recruiterreg",{
                templateUrl: 'templates/user/recruiterreg.view.html',
                controller: 'RegisterController',
                controllerAs: "model",
            })
            .when("/preregister",{
                templateUrl: 'templates/user/preregister.view.html',
                controller: 'RegisterController',
                controllerAs: 'model',
                
            })
//               .when("/courses",{
//               templateUrl: 'templates/course/course.view.html',
//               controller: 'CourseController',
//               controllerAs: 'model',
//                
//            })
             .when("/student/prof/:sid/follow/:profname",{
               templateUrl: 'templates/user/studentproffollow.view.html',
               controller: 'ProffollowController',
               controllerAs: 'model',
                
            })
             .when("/student/:studid/proffollow/:pid",{
               templateUrl: 'templates/user/studentproffollowmain.view.html',
               controller: 'MainFollowController',
               controllerAs: 'model',
                
            })
            
            .when("/prof/prof1/:pid/follow/:profname",{
               templateUrl: 'templates/user/profproffollow.view.html',
               controller: 'ProfProffollowController',
               controllerAs: 'model',
                
            })
            
            .when("/prof/:prid/proffollow/:pid",{
               templateUrl: 'templates/user/profproffollowmain.view.html',
               controller: 'ProfProfMainFollowController',
               controllerAs: 'model',
                
            })
            
            
          
            .when("/books/:term", {
			templateUrl : 'templates/book/book.view.html',
			controller : 'BookController',
			controllerAs : 'model',
                
            })
            
            .when("/courses/:sid/:term", {
			templateUrl : 'templates/course/course.view.html',
			controller : 'CourseController',
			controllerAs : 'model',
                
            })
            
            .when("/courses/id/:sid/:courseid", {
			templateUrl : 'templates/course/coursedetails.view.html',
			controller : 'CourseDetailsController',
			controllerAs : 'model',
                
            })
                      
            .when("/papers/:term", {
			templateUrl : 'templates/paper/paper.view.html',
			controller : 'PaperController',
			controllerAs : 'model',
                
            })
            
            
            
            .when("/books/id/:bookid", {
			templateUrl : 'templates/book/bookdetails.view.html',
			controller : 'BookDetailsController',
			controllerAs : 'model',
                
            })
            
            
            .when("/papers/id/:paperid", {
			templateUrl : 'templates/paper/paperdetails.view.html',
			controller : 'PaperDetailsController',
			controllerAs : 'model',
                
            })
            
            
            .when("/", {
                redirectTo: "/home"
            })
            
            .otherwise({
                redirectTo: "/"
            });
    }

})();