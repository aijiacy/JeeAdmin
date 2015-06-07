/**
 * 
 */
define([ 'main-App' ], function(mainApp) {
	'use strict';
	mainApp.service("loginSvr", [
			'$http',
			function($http) {
				var lgnSvr = {
					loginData : {
						"account" : {
							"username" : 'admin',
							"password" : ''
						},
						"captcha" : '',
						"rememberMe" : false
					},
					login : function(data, fn) {
						var param = data;
						$http.post('system/login/signIn', param)
						.success(
								function(data, status) {
									fn(data, status);
								}).error(function(data, status) {
									fn(data, status);
								});
					}
				};
				return lgnSvr;
			} ]);
});