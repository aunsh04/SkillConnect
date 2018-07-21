(function () {
    angular
        .module("DBProject")
        .factory("UserService", userService);

    function userService($http) {
        var api = {
            "getUserByCredentials": getUserByCredentials,
            "getAllUsers": getAllUsers,
            "registerUser": registerUser,
            "getrec":getrec,
            "getstud":getstud,
            "getprof":getprof,
            "getrecbyid":getrecbyid,
            "getstudbyid":getstudbyid,
            "getprofbyid":getprofbyid,
            "findprofsbyname":findprofsby,
            "followprof":followproff,
            "proffollowprof":proffollowproff,
            "getstudentsfollprof":getstudentsfollproff,
            "getproffollprof":getproffollproff,
            "getproffollbyprof":getproffollbyproff,
            "findStudentbyskill":findStudentbyskil,
            "getpapersByProf":getpapersByProf,
            "adminrec":adminrec,
            "adminprof":adminprof,
            "adminstud":adminstud,
            "adminbooks":adminbooks,
            "admincourse":admincourse,
            "delrec":delrec,
            "delprof":delprof,
            "delstud":delstud,
            "delbook":delbook,
            "delcourse":delcourse,
            "updcourse":updcourse,
            "updstud":updstud,
            "updprof":updprof,
            "updrec":updrec,
            "updbook":updbook,
            "endorsedbookdel":endorsedbookdel,
            "getbooksEndorsedByProf":getbooksEndorsedByProf,
            "coursereviewrem": coursereviewrem
        };
        
        return api;
        
        function endorsedbookdel(pid,bid) {
        		return $http.put('/api/professor/'+pid+'/book/'+bid);
        }
        
        
        function getbooksEndorsedByProf(id) {
    		return $http.get('/api/professor/'+id+'/endorsed');
    }
        
        function coursereviewrem(sid,cid) {
    		return $http.delete('/api/student/'+sid+'/course/'+cid+'/delete/review');
    }
        
        
        function adminbooks() {
        		return $http.get('/api/books');
        }
        
        function admincourse() {
    		return $http.get('/api/courses');
    		}
        
        function delbook(id) {
            return $http.delete('/api/books/'+id);
        }
        
        function delcourse(id) {
            return $http.delete('/api/courses/'+id);
        }
        
        
        function updcourse(cid,course) {
            return $http.put('/api/courses/'+cid,course);
        }
        
        function updstud(sid,user) {
            return $http.put('/api/person/student/'+sid,user);
        }
        function updprof(pid,user) {
            return $http.put('/api/person/professor/'+pid,user);
        }
        function updrec(rid,user) {
            return $http.put('/api/person/recruiter/'+rid,user);
        }
        function updbook(bid,book) {
            return $http.put('/api/books/'+bid,book);
        }
        
        
        function adminprof() {
            return $http.get('/api/person/professor');
        }
        
        function delprof(id) {
            return $http.delete('/api/person/professor/'+id);
        }
        function delstud(id) {
            return $http.delete('/api/person/student/'+id);
        }
        function delrec(id) {
            return $http.delete('/api/person/recruiter/'+id);
        }
        function adminstud() {
            return $http.get('/api/person/student');
        }
        function getpapersByProf(id) {
    		return $http.get('/api/professor/'+id+'/uploaded');
    }

        function getstudentsfollproff(pid) {
        		return $http.get('/api/professor/student/'+pid);
        }
        
        function getproffollproff(pid) {
    			return $http.get('/api/professor/'+pid+'/following/professor');
        }
        
        function getproffollbyproff(pid) {
			return $http.get('/api/professor/'+pid+'/followed/professor');
    }
        
        
        function proffollowproff(prid, pid) {
            return $http.post('/api/professorf/'+prid+'/professorbf/'+pid);
        }
        
        
        function followproff(pid, sid) {
            return $http.post('/api/student/'+ sid + '/professor/'+ pid);
        }
        function registerUser(user,a){
        	if(a == "prof"){
        		return $http.post("/api/professor", user);
        	}
        	else if (a == "recru"){
        		return $http.post("/api/person/recruiter", user);
        	}
        		
        	 return $http.post("/api/person/student", user);
        }
        
        function getUserByCredentials(username, password) {
            return $http.get('/api/person' + "?username="+ username + "&password=" + password);
        }
        function findprofsby(name) {
        	console.log(name)
            return $http.get('/api/person/professorname/'+ name );
        	
        }
        
        function findStudentbyskil(skill){
        	console.log(skill)
            return $http.get('/api/person/student/skill/'+ skill);	
        }
        
        function getrec(username, password) {
            return $http.get('/api/person/recruiter/'+ username + "/" + password);
        }
        function adminrec() {
            return $http.get('/api/person/recruiter');
        }
        function getrecbyid(id) {
            return $http.get('/api/person/recruiter/'+ id);
        }
        function getstudbyid(id) {
            return $http.get('/api/person/student/'+ id);
        }
        function getprofbyid(id) {
        		console.log('get prof by id '+id);
            return $http.get('/api/person/professor/'+ id);
        }
        function getstud(username, password) {
            return $http.get('/api/person/student/'+ username + "/" + password);
        }
        function getprof(username, password) {
            return $http.get('/api/person/professor/'+ username + "/" + password);
        }
        function getAllUsers() {
            return $http.get('/api/books');
        }

    }
})();