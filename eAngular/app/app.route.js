window.routes={

"/about": {
            templateUrl: 'app/components/basic/about.html',
            controller:'AboutController',
            controllerAs:'aboutCtrl',
            requireLogin:false,
            roles:['GUEST','ADMIN','USER']
},

"/contact": {
            templateUrl: 'app/components/basic/contact.html',
            controller: 'contactController',
            controllerAs: 'contactCtrl',
            requireLogin: false,
            roles: ['GUEST', 'USER', 'ADMIN']
        },

 "/user/home": {
            templateUrl: 'app/components/user/home.html',
            controller: 'UserController',
            controllerAs: 'userCtrl',
            requireLogin: true,
            roles: ['USER', 'ADMIN']
},

"/login": {
        templateUrl: 'app/components/authenticate/login.html',
        controller:'AuthenticateController',
        controllerAs:'authCtrl',
        requireLogin:false,
        roles:['GUEST']
},

"/register": {
        templateUrl : 'app/components/authenticate/register.html',
        controller: 'AuthenticateController',
        controllerAs: 'authCtrl',
        requireLogin: false,
        roles: ['GUEST']
    }

};

//specify the backend url from where you are going to get the values
app.constant('REST_URI','http://localhost:9090/onlinecollaboration');

app.config(['$locationProvider', '$routeProvider', '$httpProvider', 
            function ($locationProvider, $routeProvider, $httpProvider) {


for(var path in window.routes){
    $routeProvider.when(path,window.routes[path]);
}

 $routeProvider.otherwise({redirectTo:'/login'})
 $locationProvider.hashPrefix('!');

}]);

app.run(function ($rootScope, $location, AuthenticationService) {


    $rootScope.$on('$locationChangeStart', function (event, next, current) {
       
        // iterate through all the routes
        for (var i in window.routes) {
            // if routes is present make sure the user is authenticated 
            // before login using the authentication service            
            if (next.indexOf(i) != -1) {
                // if trying to access page which requires login and is not logged in 
                $rootScope.user = AuthenticationService.loadUserFromCookie();
                console.log($rootScope.user);
                $rootScope.authenticated = AuthenticationService.getUserIsAuthenticated();
                console.log($rootScope.authenticated);

                if (window.routes[i].requireLogin && !AuthenticationService.getUserIsAuthenticated()) {
                    $location.path('/login');
                }
                else if ((AuthenticationService.getUserIsAuthenticated())
                    &&
                    (window.routes[i].roles.indexOf(AuthenticationService.getRole()) == -1)) {
                    $location.path('/error');
                }
            }
        }
        
    });

    $rootScope.logout = function () {
        console.log($rootScope.userId);
        AuthenticationService.logout($rootScope.userId)
            .then(
            function (user) {
                AuthenticationService.setUserIsAuthenticated(false);
                AuthenticationService.setRole('GUEST');
                $rootScope.authenticated = false;
                $rootScope.isAdmin = false;
                $rootScope.isUser = false;
                $rootScope.islogin = false;
                $location.path('/login');
                console.log(user);
            },
            function (errorResponse) {

                console.log(errorResponse);
            }
            )
    }

     $rootScope.getSingleUser = function (userId) {
         debugger;
        console.log(userId);
        UserService.getUser(userId)
            .then(
            function (d) {
                $rootScope.customer = d;
                console.log(self.customer);
                $location.path('/viewUser');
            },
            function (errResponse) {
                console.error('Error while updating User');
            }
            );
    }


});
