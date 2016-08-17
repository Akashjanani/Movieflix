(function() {
    'use strict';

    angular
        .module('user', ['ngMessages', 'ngRoute'])
        .config(moduleConfig)
        .run(moduleRun);

    moduleConfig.$inject = ['$routeProvider'];

    function  moduleConfig($routeProvider) {
        $routeProvider
            .when('/login', {
                templateUrl: 'app/views/login.view.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'
            })
            .when('/register', {
                templateUrl: 'app/views/register.view.html',
                controller: 'RegisterController',
                controllerAs: 'vm'
            })
            .when('/Admin', {
                templateUrl: '../Admin.html',
                controller: 'LoginController'
            })
            .when('/user-list', {
                templateUrl: 'app/views/user-list.tmpl.html',
                controller: 'UserListController',
                controllerAs: 'userListVm'
            })
            .when('/movie-list', {
                templateUrl: 'app/views/movie-list.tmpl.html',
                controller: 'MoviesListController',
                controllerAs: 'movieListVm'
            })
            .when('/movie-detail/:id', {
                templateUrl: 'app/views/movie-detail.tmpl.html',
                controller: 'MovieDetailsController',
                controllerAs: 'moviesVm'
            })
            .when('/add-movie/', {
                templateUrl: 'app/views/add-movie.tmpl.html',
                controller: 'AddMovieController',
                controllerAs: 'addMovieVm'
            })
            .when('/top-movies', {
                templateUrl: 'app/views/top-movies.tmpl.html',
                controller: 'TopMoviesController',
                controllerAs: 'topMoviesVm'
            })
            .when('/top-series', {
                templateUrl: 'app/views/top-series.tmpl.html',
                controller: 'TopSeriesController',
                controllerAs: 'topSeriesVm'
            })
            .when('/user-home', {
                templateUrl: 'app/views/user.home.html',
                controller: 'UserHomeController',
                controllerAs: 'userHomeVm'
            })
            .when('/user-movie-detail/:id', {
                templateUrl: 'app/views/user-movie-detail.html',
                controller: 'UserMovieController',
                controllerAs: 'userMovieVm'
            })
            .when('/my-account/:id', {
                templateUrl: 'user-account.tmpl.html',
                controller: 'UserAccountController',
                controllerAs: 'userAccountVm'
            })
            .when('/genre', {
                templateUrl: 'app/views/categories.view.html',
                controller: 'CategoriesController',
                controllerAs: 'selectVm'
            })
            .when('/imdbRatings', {
                templateUrl: 'app/views/sort.imdbRatings.html',
                controller: 'SorterController',
                controllerAs: 'vm'
            })
            .when('/imdbVotes', {
                templateUrl: 'app/views/sort.imdbVotes.html',
                controller: 'SorterController',
                controllerAs: 'vm'
            })
            .when('/year', {
                templateUrl: 'app/views/sort.year.html',
                controller: 'SorterController',
                controllerAs: 'vm'
            })
            .when('/edituser', {
                templateUrl: 'app/views/user-account.tmpl.html',
                controller: 'UserAccountController',
                controllerAs: 'vm'
            })
            .otherwise({
                redirectTo: '/user-home'
            })
            .otherwise({
                redirectTo: '/login'
            });
    }

    moduleRun.$inject = [];

    function moduleRun() {
        console.log('App Started');
    }
})();