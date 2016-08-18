(function() {
    'use strict';

    angular
        .module('user')
        .controller('UserAccountController', UserAccountController);

    UserAccountController.$inject = ['userHomeService', '$routeParams'];

    function UserAccountController(userHomeService, $routeParams) {
        var vm = this;

        init();

        function init() {
            userHomeService
                .userAccount("a6e9d552-a953-4248-91ce-def986e13fc7")
                .then(function(data) {
                    vm.user = data;
                }, function(error) {
                    console.log(error);
                });
        }
    }
})();