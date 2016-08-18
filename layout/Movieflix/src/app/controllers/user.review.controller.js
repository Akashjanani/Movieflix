(function() {
    'use strict';

    angular
        .module('user')
        .controller('UserReviewController', UserReviewController);

    UserReviewController.$inject = ['userHomeService', '$routeParams'];

    function UserReviewController(userHomeService, $routeParams) {
        var userReviewVm = this;

        init();

        function init() {
            console.log('in UserReviewController');
            userHomeService.getReview($routeParams.id)
                .then(function(data) {
                    userReviewVm.review = data;
                    console.log('exec');

                }, function(error) {
                    console.log(error);
                });
        }
    }
})();