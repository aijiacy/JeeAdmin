/**
 * 
 */
define([ 'angular', 'main-App' ], function(angular, mainApp) {
	'use strict';
	mainApp.controller('loginCtrl', [ '$scope', 'loginSvr',
			function($scope, loginSvr) {
				$scope.loginData = loginSvr.loginData; // loginService.loginData;
				$scope.doLogin = function(){
					loginSvr.login($scope.loginData, function(data, status){
						console.log(status + ":" + data);
						if(status === 200){
							if(data.opResult && (data.opCode === "0000")){
								window.location.href='system/main';
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