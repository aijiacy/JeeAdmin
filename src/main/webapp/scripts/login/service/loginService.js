/**
 * 
 */
define([ 'scripts/login/loginApp' ], function(loginApp) {
	'use strict';
	loginApp.service("loginSvr", [
			'$http',
			function($http) {
				var lgnSvr = {
					loginData : {
						"account" : {
							"name" : 'admin',
							"password" : ''
						},
						"checkCode" : '',
						"forgetPass" : false
					},
					login : function(data) {
						var param = data;
						$http.post('system/login', param).success(
								function(data, status) {
									console.log(data);
									console.log(status);
									if (data.code == "1") {
										//window.location.href = "system/main";
										$location.path('system/main');
									}
								}).error(function(data, status) {
							console.log(data);
							console.log(status);
						});
					}
				};
				return lgnSvr;
			} ]);
});