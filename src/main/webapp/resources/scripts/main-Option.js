/**
 * require configuration.
 */
require.config({
	baseUrl	: '',
	paths	: {
		'require'				: 'resources/plugins/require/2.1.17/require.min',
		'jquery'				: 'resources/plugins/jquery/2.1.3/jquery.min',
		'domReady'				: 'resources/plugins/require/2.1.17/domReady',
		'angular'				: 'resources/plugins/angular/1.3.16/angular.min',
		'angular-animate'		: 'resources/plugins/angular/1.3.16/angular-animate.min',
		'angular-route'			: 'resources/plugins/angular/1.3.16/angular-route.min',
		'angular-ui-router'		: 'resources/plugins/angular-ui/ui-router/0.2.15/angular-ui-router.min',
		
		'main-Start'			: 'resources/scripts/main-Start',
		'main-App'				: 'resources/scripts/main-App',
		'main-Router'			: 'resources/scripts/main-Router',
		'common-HttpUtils'		: 'resources/scripts/common/common-httpUtils',
		
		'login-Loader'			: 'resources/scripts/login/login-Loader'
	},
	shim	: {
		'angular'				: { deps : ['jquery'], exports : 'angular' },
		'angular-animate'		: { deps : ['angular'], exports : 'angular-animate' },
		'angular-route'		: { deps : ['angular'], exports : 'angular-route' },
		'angular-ui-router'		: { deps : ['angular'], exports : 'angular-ui-router' },
		'common-HttpUtils'		: { deps : ['angular'], exports : 'common-HttpUtils' }
	},
	deps	: ['main-Start']
});