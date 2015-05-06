/**
 * 
 */
define([ 'scripts/login/loginApp' ], function(loginApp) {
	'use strict';
	loginApp.controller('loginCtrl', [ '$scope', 'loginSvr',
			function($scope, loginSvr) {
				$scope.loginData = loginSvr.loginData; // loginService.loginData;
			} ]);
});