(function() {
    'use strict';

    angular
        .module('user')
        .service('userHomeService', userHomeService);

    userHomeService.$inject = ['$http', '$q'];

    function userHomeService($http, $q) {
        var self = this;

        self.getMovies = getMovies;
        self.getMovie = getMovie;
        self.getTopMovies = getTopMovies;
        self.getTopSeries = getTopSeries;
        self.getReview = getReview;
        self.addComment = addComment;
        self.getGenre = getGenre;
        self.sortimdbRatings = sortimdbRatings;
        self.sortimdbVotes = sortimdbVotes;
        self.sortYear = sortYear;
        self.editUser = editUser;


        function getMovies() {
            return $http.get('http://localhost:8080/Movieflix/api/movies/')
                .then(successFn, errorFn);
        }
        function getMovie(id) {
            return $http.get('http://localhost:8080/Movieflix/api/movies/' +id)
                .then(successFn, errorFn);
        }
        function getTopMovies() {
            return $http.get('http://localhost:8080/Movieflix/api/movies/topMovies/')
                .then(successFn, errorFn);
        }
        function getTopSeries() {
            return $http.get('http://localhost:8080/Movieflix/api/movies/topSeries/' )
                .then(successFn, errorFn);
        }
        function getReview(movieid) {
            return $http.get('http://localhost:8080/Movieflix/api/reviews/findByMovieId/' +movieid)
                .then(successFn, errorFn);
        }
        function addComment(user) {
            return $http.post('http://localhost:8080/Movieflix/api/reviews', user)
                .then(successFn, errorFn);
        }
        function getGenre(genre) {
            return $http.get('http://localhost:8080/Movieflix/api/movies/genre/' +genre)
                .then(successFn, errorFn)
        }
        function sortimdbRatings() {
            return $http.get('http://localhost:8080/Movieflix/api/movies/imdbRatings')
                .then(successFn, errorFn);

        }
        function sortimdbVotes() {
            return $http.get('http://localhost:8080/Movieflix/api/movies/imdbVotes')
                .then(successFn, errorFn);

        }
        function sortYear() {
            return $http.get('http://localhost:8080/Movieflix/api/movies/sortYear')
                .then(successFn, errorFn);
        }

        function editUser(id) {
            return $http.get('http://localhost:8080/Movieflix/api/users' +id)
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