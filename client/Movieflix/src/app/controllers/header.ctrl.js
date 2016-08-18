(function(){
    'use strict'

        angular
            .module('user')
            .controller('HeaderCtrl', HeaderCtrl);
    HeaderCtrl.$inject = ['$scope', '$location'];
    function HeaderCtrl($scope, $location) {
        $scope.$on('$locationChangeSuccess', function () {
            var path = $location.path();
            var path1 = $location.path();

            $scope.templateUrl = (path === '/login' || path === '/admin')
                ? 'header/header.home.html' : 'header/header.admin.html';

            $scope.templateUrl1 = ( path1 == '/user-home' || path1 === '/login')
                ? 'header/header.user.html': 'header/header.home.html';
        });
    }
})();