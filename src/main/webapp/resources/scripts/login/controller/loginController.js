/**
 * 
 */
define([ 'angular', 'login-App' ], function(angular, loginApp) {
	'use strict';
	loginApp.controller('loginCtrl', [ '$scope', 'loginSvr',
			function($scope, loginSvr) {
				$scope.loginData = loginSvr.loginData; // loginService.loginData;
				$scope.doLogin = function(){
					loginSvr.login($scope.loginData, function(data, status){
						console.log(status + ":" + data);
						if(status === 200){
							if(data.opResult && (data.opCode === 0)){
								//window.location.href='system/portail';
							} else {
								alert('登录失败：' + data.opDesc);
							}
						} else {
							alert('登录异常，请稍后再试！');
						}
					});
				}
			} ]);
});