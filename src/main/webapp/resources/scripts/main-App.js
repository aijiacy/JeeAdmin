/**
 * JeeAdmin main application console.
 */
define([ 'angular' ], function(angular) {
	var mainApp = angular.module('mainApp', [ 'ngAnimate', 'ngRoute', 'httpUtils' ]);
	mainApp.config([ '$routeProvider', '$locationProvider', function appConfig($routeProvider, $locationProvider) {
		$locationProvider.html5Mode(true);
	}]);
	return mainApp;
});