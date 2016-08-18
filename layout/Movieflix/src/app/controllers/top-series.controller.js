(function() {
    'use strict';

    angular
        .module('user')
        .controller('TopSeriesController', TopSeriesController);

    TopSeriesController.$inject = ['userHomeService'];

    function TopSeriesController(userHomeService) {
        var topSeriesVm = this;

        init();

        function init(){
            console.log('in TopSeriesController');

            topSeriesVm.sorter = {
                sortBy: 'title',
                sortOrder: false
            };

            userHomeService
                .getTopSeries()
                .then(function(data) {
                    topSeriesVm.series = data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        }
    }
})();