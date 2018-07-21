(function () {
    angular
        .module("DBProject")
        .factory("StudentService", studentService);

    function studentService($http) {
        var api = {
            "getUserByCredentials": getUserByCredentials,
            "getAllstudent": getAllstudent
        };
        return api;


        function getUserByCredentials(username, password) {
            return $http.get('/api/person' + "?username="+ username + "&password=" + password);
        }
        
        function getAllstudent() {
            return $http.get('/api/person/student/');
        }

    }
})();