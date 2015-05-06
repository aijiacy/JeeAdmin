/**
 * JeeAdmin main application console.
 */
define([ 'angular',
         'scripts/login/service/main',
         'scripts/login/controller/main' ], function(angular) {
	return angular.module('mainApp', [ 'ngAnimate', 'httpUtils', 'loginApp' ]);
});