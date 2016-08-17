(function() {
    'use strict';

    angular
        .module('user')
        .controller('SorterController', SorterController);

    SorterController.$inject = ['userHomeService'];

    function SorterController(userHomeService) {
        var vm = this;

        init();

        function init() {
            console.log('in SorterController');

            userHomeService
                .sortimdbRatings()
                .then(function (data) {
                    vm.movies = data;
                    console.log(data);
                })
                .catch(function (error) {
                    console.log(error);
                })
            userHomeService
                .sortimdbVotes()
                .then(function(data) {
                    vm.movies = data;
                    console.log(data);
                })
                .catch(function(error) {
                    console.log(error);
                })

            userHomeService
                .sortYear()
                .then(function(data) {
                    vm.movies = data;
                    console.log(data);
                })
                .catch(function(error) {
                    console.log(error);
                });

        }
    }
})();