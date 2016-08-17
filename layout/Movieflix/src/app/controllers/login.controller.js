(function () {
    'use strict';

    angular
        .module('user')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['userService', '$location'];
    function LoginController(userService, $location) {
        var loginVm = this;

        loginVm.login = login;

        function login() {
            loginVm.dataLoading = true;
            userService
                .login(loginVm.user)
                .then(function (response) {
                    if(response==true){
                        console.log(response);
                        $location.path('/user-list')
                        }
                        else{
                            $location.path('/user-home')
                    }
                }, function(error) {
                    $location.path('/login')
                    console.log(error);
                })
        }
    }

})();
