/**
 * 
 */
define([ 'angular', 'main-App' ], function(angular, mainApp) {
	mainApp.config([
			'$routeProvider',
			'$locationProvider',
			'$urlRouterProvider',
			'$stateProvider',
			function($routeProvider, $locationProvider, $urlRouterProvider, $stateProvider) {
				$locationProvider.html5Mode(true);
				
				$routeProvider.when('/system/main', {
					templateUrl: '/system/main'
				}).when('/system/logout', {
					templateUrl: '/system/logout'
				}).otherwise('/system/main');
				
			} ]);
});