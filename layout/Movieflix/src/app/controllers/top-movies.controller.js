(function() {
    'use strict';

    angular
        .module('user')
        .controller('TopMoviesController', TopMoviesController);

    TopMoviesController.$inject = ['userHomeService'];

    function TopMoviesController(userHomeService) {
        var topMoviesVm = this;

        init();

        function init(){
            console.log('in TopMoviesController');

            topMoviesVm.sorter = {
                sortBy: 'title',
                sortOrder: false
            };

            userHomeService
                .getTopMovies()
                .then(function(data) {
                    topMoviesVm.movies = data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        }
    }
})();