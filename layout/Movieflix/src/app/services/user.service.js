(function() {
    'use strict';

    angular
        .module('user')
        .service('userService', userService);

    userService.$inject = ['$http', '$q'];

    function userService($http, $q) {
        var self = this;

        self.createUser = createUser;
        self.login = login;

        function createUser(user) {
            return $http.post('http://localhost:8080/Movieflix/api/users/', user)
                .then(successFn, errorFn);
        }
        function login(login) {
            return $http.post('http://localhost:8080/Movieflix/api/users/login', login)
                .then(successFn, errorFn);
        }
        function successFn(response) {
            return response.data; //RESOLVE
        }
        function errorFn(response) {
            return $q.reject(error.status); //REJECT
        }
    }
})();