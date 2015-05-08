require.config({
	baseUrl	: '',
	paths	: {
		'require'				: 'plugins/require/2.1.17/require.min',
		'domReady'				: 'plugins/require/2.1.17/domReady',
		'angular'				: 'plugins/angular/1.3.15/angular.min',
		'angular-route'			: 'plugins/angular/1.3.15/angular-route.min',
		
		'login-Start'			: 'scripts/login/login-Start',
		'login-App'				: 'scripts/login/login-App',
		'login-Loader'			: 'scripts/login/login-Loader',
		'common-HttpUtils'		: 'scripts/common/common-httpUtils'
	},
	shim	: {
		'angular'				: { exports : 'angular' },
		'angular-route'			: { deps : ['angular'], exports : 'angular-route' },
		'common-HttpUtils'		: { deps : ['angular'], exports : 'common-HttpUtils' }
	},
	deps	: ['login-Start']
});