define([ 'require',
         'angular',
         'angular-animate',
         'adm-HttpUtils',
         'main-App'],
         function(require, angular) {
			require([ 'domReady!' ], function(doc) {
				angular.bootstrap(doc, [ 'mainApp' ]);
			});
		 }
);