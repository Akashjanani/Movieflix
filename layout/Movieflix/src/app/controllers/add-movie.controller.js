(function() {
    'use strict';

    angular
        .module('user')
        .controller('AddMovieController', AddMovieController);

    AddMovieController.$inject = ['adminService', '$location'];

    function AddMovieController(adminService, $location) {
        var addMovieVm = this;

        addMovieVm.addMovie = addMovie;

        init();

        function init() {
            console.log('in AddMovieController');
        }

        function addMovie() {
            adminService
                .addMovie(addMovieVm.newMovie)
                .then(function(data) {
                    $location.path('/movie-list');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();