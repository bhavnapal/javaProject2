window.routes={

"/home": {
templateUrl : 'app/components/basic/home.html',
controller : 'BasicController',
controllerAs : 'BasicCtrl',
requireLogin: false,
roles: ['GUEST']
    },
"/about": {
templateUrl : 'app/components/page/about.html',
controller : 'PageController',
controllerAs : 'PageCtrl',
requireLogin: false,
roles: ['GUEST']
    },
"/contact": {
templateUrl : 'app/components/page/contact.html',
controller : 'PageController',
controllerAs : 'PageCtrl',
requireLogin: false,
roles: ['GUEST']
    },
"/register": {
templateUrl : 'app/components/register/registeration.html',
controller : 'RegisterController',
controllerAs : 'RegisterCtrl',
requireLogin: false,
roles: ['GUEST']
    }
};

// specify the backend url from where you are going to get the values
app.constant('REST_URI', 'http://localhost:9090/onlinecollaboration');

app.config(['$routeProvider', function($routeProvider) {
    for(var path in window.routes) {
        $routeProvider.when(path, window.routes[path]);
    }
    $routeProvider.otherwise({ redirectTo: '/login'});
}]);