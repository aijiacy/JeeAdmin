define([ 'require',
         'angular',
         'common-HttpUtils',
         'login-Loader',
         'login-App'],
         function(require, angular) {
			require([ 'domReady!' ], function(doc) {
				angular.bootstrap(doc, [ 'loginApp' ]);
			});
		 }
);