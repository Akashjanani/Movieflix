(function() {
    'use strict';

    angular
        .module('user')
        .controller('UserHomeController', UserHomeController);

    UserHomeController.$inject = ['userHomeService'];

    function UserHomeController(userHomeService) {
        var userHomeVm = this;

        init();

        function init() {
            console.log('in UserHomeController');

            userHomeVm.sorter = {
                sortBy: 'firstName',
                sortOrder: false
            };

            userHomeService.getMovies()
                .then(function(data) {
                    userHomeVm.movies = data;
                    console.log(data);
                })
                .catch(function(error) {
                    console.log(error);
                });
        }
    }
})();