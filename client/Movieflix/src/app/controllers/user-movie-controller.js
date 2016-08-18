(function() {
    'use strict';

    angular
        .module('user')
        .controller('UserMovieController', UserMovieController);

    UserMovieController.$inject = ['userHomeService', '$routeParams'];

    function UserMovieController(userHomeService, $routeParams) {
        var userMovieVm = this;
        userMovieVm.userComment = userComment;
        init();

        function init() {
            userHomeService
                .getMovie($routeParams.id)
                .then(function(data) {
                    userMovieVm.movie = data;
                }, function(error) {
                    console.log(error);
                });
            userHomeService
                .getReview($routeParams.id)
                .then(function(data) {
                    userMovieVm.review = data;
                }, function(error) {
                    console.log(error);
                });
        }

        function userComment() {
                    userHomeService
                .addComment(userMovieVm.newReview)
                .then(function(data) {
                    $location.path('/user-movie-detail/:id');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();