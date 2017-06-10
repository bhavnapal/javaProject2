var AdminModule = angular.module('AdminModule',['ngRoute','ngCookies']);

AdminModule.service('AdminServices', ['$http', '$q', function ($http, $q) {

    //For linking backend project with the frontend
    var BASE_URL = 'http://localhost:9090/onlinecollaboration';


    //Function to fetch approved user list
    this.approvedUserList = function () {
        var deferred = $q.defer();

        $http.get(BASE_URL + '/user/manage/list')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    //Function to fetch approved blog list
    this.approvedBlogList = function () {
        var deferred = $q.defer();

        $http.get(BASE_URL + '/blog/manage/list')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    //Function to fetch approved job list
    this.manageJobs = function () {
        var deferred = $q.defer();

        $http.get(BASE_URL + '/job/manage/list')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    //Function tochange user role
    this.changeUserRole = function (user) {
        var deferred = $q.defer();

        $http.post(BASE_URL + '/user/role/manage', user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    //Function to fetch approved event list
    this.fetchEventList = function () {
        var deferred = $q.defer();

        $http.get(BASE_URL + '/event/manage/list')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }


}]);