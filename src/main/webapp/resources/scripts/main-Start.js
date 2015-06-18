define([ 'require',
         'jquery',
         'angular',
         'angular-animate',
         'angular-route',
         'angular-ui-router',
         'common-HttpUtils',
         'login-Loader',
         'main-App',
         'main-Router'],
         function(require, $, angular) {
			require([ 'domReady!' ], function(doc) {
				angular.bootstrap(doc, [ 'mainApp' ]);
			});
		 }
);