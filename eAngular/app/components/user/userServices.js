var UserModule = angular.module('UserModule',[]);

UserModule.service('UserService', ['$http', '$q','REST_URI', function ($http, $q,REST_URI) {
    
this.updateUser= function (user, id) {
        var deferred = $q.defer();
        $http.put(REST_URI + '/user/get/' + id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
                console.log(response.data);
            },
            function (errResponse) {
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    this.getUser=function (id) {
        var deferred = $q.defer();
        $http.post(REST_URI + '/user/get/' + id)
            .then(
            function (response) {
                deferred.resolve(response.data);
                console.log(response.data);
            },
            function (errResponse) {
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

}]);
