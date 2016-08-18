(function() {
    'use strict';

    angular
        .module('user')
        .controller('MovieDetailsController', MovieDetailsController);

    MovieDetailsController.$inject = ['adminService', '$routeParams'];

    function MovieDetailsController(adminService, $routeParams) {
        var moviesVm = this;

        init();

        function init() {
            adminService
                .getMovie($routeParams.id)
                .then(function(data) {
                    moviesVm.movies = data;
                }, function(error) {
                    console.log(error);
                });
        }
    }
})();