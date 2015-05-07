/**
 * require configuration.
 */
require.config({
	baseUrl	: '',
	paths	: {
		'require'				: 'plugins/require/2.1.17/require.min',
		'jquery'				: 'plugins/jquery/2.1.3/jquery.min',
		'domReady'				: 'plugins/require/2.1.17/domReady',
		'angular'				: 'plugins/angular/1.3.15/angular.min',
		'angular-animate'		: 'plugins/angular/1.3.15/angular-animate.min',
		
		'main-Start'			: 'scripts/start',
		'main-App'				: 'scripts/app',
		'adm-HttpUtils'			: 'scripts/common/httpUtils'
	},
	shim	: {
		'angular'				: { deps : ['jquery'], exports : 'angular' },
		'angular-animate'		: { deps : ['angular'], exports : 'angular-animate' },
		'adm-HttpUtils'			: { deps : ['angular'], exports : 'adm-HttpUtils' }
	},
	deps	: ['main-Start']
});