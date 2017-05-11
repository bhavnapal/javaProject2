var AuthenticateModule = angular.module('AuthenticateModule', []);

AuthenticateModule.service('AuthenticateService', ['$http', '$q', '$rootScope', '$cookies', function ($http, $q,$rootScope, $cookies) {
  
    var userIsAuthenticated = false;
    var role = 'GUEST';

    this.setUserIsAuthenticated = function (value) {
        userIsAuthenticated = value;
    }

    this.getUserIsAuthenticated = function () {
        return userIsAuthenticated;
    }

   this.setRole = function (value) {
        role = value;
    }

    this.getRole = function () {
        return role;
    }

    this.login = function (credentials) {
        console.log(credentials);

        var deferred = $q.defer();
        $http.post(REST_URI + 'login', credentials)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Error while logging in');
                $rootScope.errorMessage = "Invalid credentials."
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;

    }

    this.register = function (user) {
        console.log(user);

        var deferred = $q.defer();
        $http.post(REST_URI + '/register', user)
            .then(
            function (response) {
                deferred.resolve(response.data);
                $rootScope.successMessage = "Registration successful! You will get an email after approval.";
            },
            function (errResponse) {
                console.error('Error while registering');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;

    }

   this.logout = function (userId) {
        var deferred = $q.defer();
        $http.put(REST_URI + '/logout/' + userId)
            .then(function (response) {
                $cookies.putObject('user', undefined);
                userIsAuthenticated = false;
                role = 'GUEST';
                deferred.resolve(response);
                console.log(response);
            },
            function (errResponse) {
                deferred.reject(errResponse);
                console.log(errResponse);
            });
        return deferred.promise;
    }

    this.loadUserFromCookie = function () {
     
        user = $cookies.getObject('user');
        console.log(user)
        if (user) {
            userIsAuthenticated = true;
            $rootScope.authenticated = true;
            $rootScope.message = 'Welcome ' + user.firstName;
            $rootScope.firstName = user.firstName;
            $rootScope.lastName = user.lastName;
            $rootScope.emailId = user.emailId;
            $rootScope.gender = user.gender;
            $rootScope.userId = user.userId;
            console.log($rootScope.userId);
            role = user.role;
            console.log(role);
        }
        else {
            userIsAuthenticated = false;
            role = 'GUEST';
        }
        return user;
    }

   this.saveUser = function (user) {
        // save the user inside the cookie
        $cookies.putObject('user', user);
        role = user.role;
        userIsAuthenticated = true;

    }

}]);