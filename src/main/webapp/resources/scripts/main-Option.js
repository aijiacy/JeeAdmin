/**
 * require configuration.
 */
require.config({
	baseUrl	: '',
	paths	: {
		'require'				: 'resources/plugins/require/2.1.17/require.min',
		'jquery'				: 'resources/plugins/jquery/2.1.3/jquery.min',
		'domReady'				: 'resources/plugins/require/2.1.17/domReady',
		'angular'				: 'resources/plugins/angular/1.3.15/angular.min',
		'angular-animate'		: 'resources/plugins/angular/1.3.15/angular-animate.min',
		
		'main-Start'			: 'resources/scripts/main-Start',
		'main-App'				: 'resources/scripts/main-App',
		'common-HttpUtils'		: 'resources/scripts/common/common-httpUtils'
	},
	shim	: {
		'angular'				: { deps : ['jquery'], exports : 'angular' },
		'angular-animate'		: { deps : ['angular'], exports : 'angular-animate' },
		'common-HttpUtils'		: { deps : ['angular'], exports : 'common-HttpUtils' }
	},
	deps	: ['main-Start']
});