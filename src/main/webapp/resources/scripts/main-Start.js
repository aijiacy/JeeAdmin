define([ 'require',
         'jquery',
         'angular',
         'angular-animate',
         'common-HttpUtils',
         'main-App'],
         function(require, $, angular) {
			require([ 'domReady!' ], function(doc) {
				angular.bootstrap(doc, [ 'mainApp' ]);
			});
		 }
);