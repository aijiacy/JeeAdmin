require.config({
	baseUrl	: '',
	paths	: {
		'require'				: 'resources/plugins/require/2.1.17/require.min',
		'domReady'				: 'resources/plugins/require/2.1.17/domReady',
		'angular'				: 'resources/plugins/angular/1.3.15/angular.min',
		'angular-route'			: 'resources/plugins/angular/1.3.15/angular-route.min',
		
		'login-Start'			: 'resources/scripts/login/login-Start',
		'login-App'				: 'resources/scripts/login/login-App',
		'login-Loader'			: 'resources/scripts/login/login-Loader',
		'common-HttpUtils'		: 'resources/scripts/common/common-httpUtils'
	},
	shim	: {
		'angular'				: { exports : 'angular' },
		'angular-route'			: { deps : ['angular'], exports : 'angular-route' },
		'common-HttpUtils'		: { deps : ['angular'], exports : 'common-HttpUtils' }
	},
	deps	: ['login-Start']
});