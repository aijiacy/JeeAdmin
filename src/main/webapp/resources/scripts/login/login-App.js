/**
 * login module
 */
define([ 'angular' ], function(angular) {
	var loginApp = angular.module('loginApp', [ 'ngRoute', 'httpUtils' ]);
	loginApp.config([ '$routeProvider', '$locationProvider', function appConfig($routeProvider, $locationProvider) {
		$locationProvider.html5Mode(true);
	}]);
	loginApp.run(['$location', function appRun($location){
		console.log($location.path());
	}]);
	return loginApp;
});