/**
 * 
 */
define([ 'scripts/login/loginApp' ], function(loginApp) {
	'use strict';
	loginApp.service("loginSvr", [ '$http', function($http) {
				var lgnSvr = {
					loginData : {
						"account" : {
							"name" : 'admin',
							"password" : ''
						},
						"checkCode" : '',
						"forgetPass" : false
					},
					login : function(data, fn) {
						var param = data;
						$http.post('system/login', param).success(function(data, status){
							fn(data, status);
						}).error(function(data, status){
							fn(data, status);
						});
					}
				};
				return lgnSvr;
			} ]);
});