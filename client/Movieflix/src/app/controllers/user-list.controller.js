(function() {
    'use strict';

    angular
        .module('user')
        .controller('UserListController', UserListController);

    UserListController.$inject = ['adminService'];

    function UserListController(adminService) {
        var userListVm = this;

        init();

        function init() {
            console.log('in UserListController');

            userListVm.sorter = {
                sortBy: 'firstName',
                sortOrder: false
            };

            adminService.getUsers()
                .then(function(data) {
                    userListVm.users = data;
                    console.log(data);
                })
                .catch(function(error) {
                    console.log(error);
                });
        }
    }
})();