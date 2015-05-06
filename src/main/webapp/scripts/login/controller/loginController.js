/**
 * 
 */
define([ 'scripts/login/loginApp' ], function(loginApp) {
	'use strict';
	loginApp.controller('loginCtrl', [ '$scope', 'loginSvr',
			function($scope, loginSvr) {
				$scope.loginData = loginSvr.loginData; // loginService.loginData;
				$scope.doLogin = function(){
					loginSvr.login($scope.loginData, function(data, status){
						console.log(status);
						console.log(data);
					});
				}
			} ]);
});