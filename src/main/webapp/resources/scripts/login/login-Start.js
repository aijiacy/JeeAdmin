define([ 'require',
         'angular',
         'angular-route',
         'common-HttpUtils',
         'login-Loader',
         'login-App'],
         function(require, angular) {
			require([ 'domReady!' ], function(doc) {
				angular.bootstrap(doc, [ 'loginApp' ]);
			});
		 }
);