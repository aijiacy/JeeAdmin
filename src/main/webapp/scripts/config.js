/**
 * require configuration.
 */
require.config({
	baseUrl	: '',
	paths	: {
		'require'					: 'plugins/require/2.1.17/require.min',
		'domReady'					: 'plugins/require/2.1.17/domReady',
		'angular'					: 'plugins/angular/1.3.15/angular.min',
		'angular-animate'			: 'plugins/angular/1.3.15/angular-animate.min',
		'angular-ui-router'			: 'plugins/angular-ui/0.2.14/angular-ui-router.min',
		'angular-ui-bootstrap'		: 'plugins/angular-ui/ui-bootstrap/0.12.1/ui-bootstrap.min',
		'angular-ui-bootstraptpls'	: 'plugins/angular-ui/ui-bootstrap/0.12.1/ui-bootstrap-tpls.min',
		
		'main-Start'				: 'scripts/start',
		'main-App'					: 'scripts/app',
		'adm-HttpUtils'				: 'scripts/common/httpUtils'
	},
	shim	: {
		'angular'				: { exports : 'angular'},
		'angular-animate'		: { deps : ['angular'], exports : 'angular-animate' },
		'adm-HttpUtils'			: { deps : ['angular'], exports : 'adm-HttpUtils' }
	},
	deps	: ['main-Start']
});