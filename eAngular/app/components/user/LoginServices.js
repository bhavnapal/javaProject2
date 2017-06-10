var LoginModule = angular.module('LoginModule', ['ngRoute', 'ngCookies']);

LoginModule.service('LoginServices', ['$http', '$q', function ($http, $q) {

  //For linking backend project with the frontend
    var BASE_URL = 'http://localhost:9090/onlinecollaboration';

    this.login = function (user) {
        console.log(user);
        var deffered = $q.defer();
        $http.post(BASE_URL + '/user/login', user).then
            (
            function (response) {
                console.log(response);
                deffered.resolve(response)
            }, function (error) {
                deffered.reject(error);
            }

            );
        return deffered.promise;
    }

}]);

var RegService = LoginModule.service('RegService', function ($http, $q, BASE_URL) {
    this.register = function (user) {
        var deffered = $q.defer();
        $http.post(BASE_URL + '/user/insert', user).then(
            function (response) {
                console.log(response);
                deffered.resolve(response);

            },
            function (error) {
                console.log(error.data);
                deffered.reject(error);
            }
        );
        return deffered.promise;

    }
})