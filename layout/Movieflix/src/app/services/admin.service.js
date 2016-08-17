(function() {
    'use strict';

    angular
        .module('user')
        .service('adminService', adminService);

    adminService.$inject = ['$http', '$q'];

    function adminService($http, $q) {
        var self = this;

        self.getUsers = getUsers;
        self.getMovies = getMovies;
        self.getMovie = getMovie;
        self.addMovie = addMovie;

        function getUsers() {
            return $http.get('http://localhost:8080/Movieflix/api/users/')
                .then(successFn, errorFn);
        }
        function getMovies() {
            return $http.get('http://localhost:8080/Movieflix/api/movies/')
                .then(successFn, errorFn);
        }
        function getMovie(id) {
            return $http.get('http://localhost:8080/Movieflix/api/movies/' +id)
                .then(successFn, errorFn);
        }
        function addMovie(movie) {
            return $http.post('http://localhost:8080/Movieflix/api/movies/',movie)
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