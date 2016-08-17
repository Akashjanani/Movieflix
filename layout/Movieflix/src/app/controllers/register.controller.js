(function () {
    'use strict';

    angular
        .module('user')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['userService', '$location', '$rootScope'];
    function RegisterController(userService, $location, $rootScope) {
        var vm = this;

        vm.register = register;

        function register() {
            vm.dataLoading = true;
            userService.createUser(vm.user)
                .then(function (response) {
                    $location.path('/login');
                }, function(error) {
                    console.log(error);
                })
        }
    }

})();
