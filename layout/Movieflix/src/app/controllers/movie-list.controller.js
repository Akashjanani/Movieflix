(function() {
    'use strict';

    angular
        .module('user')
        .controller('MoviesListController', MoviesListController);

    MoviesListController.$inject = ['adminService'];

    function MoviesListController(adminService) {
        var movieListVm = this;

        init();

        function init() {
            console.log('in MoviesListController');

            movieListVm.sorter = {
                sortBy: 'title',
                sortOrder: false
            };

            adminService
                .getMovies()
                .then(function (data) {
                    movieListVm.movies = data;
                })
                .catch(function (error) {
                    console.log(error);
                });

            movieListVm.deleteMovie = function (id) {
                _.remove(movieListVm.movies, function(u){
                    if(u.id === id)
                    {
                    adminService
                        .deleteMovie(id)
                        .then(function () {
                            adminService
                            .getMovies()
                                .then(function (data) {
                                    movieListVm.movies = data;
                                })
                        })
                        }
                })
            }

        }

    }
})();