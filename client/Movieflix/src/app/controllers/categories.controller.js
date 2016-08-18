(function() {
    'use strict';

    angular
        .module('user')
        .controller('CategoriesController', CategoriesController);

    CategoriesController.$inject = ['userHomeService', '$routeParams', '$scope'];

    function CategoriesController(userHomeService, $routeParams, $scope) {
        var selectVm = this;
        var item = $scope.showSelectValue;

        console.log(item);
        init();

        function init() {
            console.log('in CategoriesController');

            selectVm.sorter = {
                sortBy: 'firstName',
                sortOrder: false
            };

            userHomeService
                .getGenre($routeParams.item)
                .then(function(data) {
                    selectVm.movies = data;
                }, function(error) {
                    console.log(error);
                });
        }
    }
})();