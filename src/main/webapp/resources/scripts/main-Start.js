define([ 'require',
         'jquery',
         'angular',
         'angular-animate',
         'angular-route',
         'common-HttpUtils',
         'login-Loader',
         'main-App'],
         function(require, $, angular) {
			require([ 'domReady!' ], function(doc) {
				angular.bootstrap(doc, [ 'mainApp' ]);
			});
		 }
);