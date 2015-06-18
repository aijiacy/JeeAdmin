/**
 * JeeAdmin main application console.
 */
define([ 'angular' ], function(angular) {
	var mainApp = angular.module('mainApp', [ 'ngAnimate', 'ngRoute', 'httpUtils', 'ui.router' ]);
	return mainApp;
});