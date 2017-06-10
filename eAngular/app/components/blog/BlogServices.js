var BlogModule = angular.module('BlogModule', ['ngRoute', 'ngCookies']);

BlogModule.service('BlogServices', ['$http', '$q', function ($http, $q) {

    var BASE_URL = 'http://localhost:9090/onlinecollaboration/blog'


    this.fetchAllBlogs = function () {
        console.log('BlogController......');
        return $http.get(BASE_URL + '/all')
            .then(
            function (response) {
                return response.data;
            },
            function (errResponse) {
                console.error('Error while fetching Blogs');
                return $q.reject(errResponse);
            }
            );
        return deferred.promise;
    },

        this.createBlog = function (blog) {
           // var deffered = $q.defer();
          return  $http.post(BASE_URL + '/insert', blog).then(
                function (response) {
                    console.log(response);
                    return response.data;
                },
                function(errResponse) {
                   // console.error('Error while creating blog');
                   // deffered.reject(errResponse);
                   return $q.reject(errResponse);
                }
            );
            return deffered.promise;
        },

        this.updateBlog = function (blog, id) {
            return $http.post(BASE_URL + '/update/' + id, blog)
                .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while updating blog');
                    return $q.reject(errResponse);
                }
                );
            //return deferred.promise;
        },

        this.accept = function (id) {
            console.log("calling approve ")
            return $http.get(BASE_URL + '/accept_blog/' + id)
                .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while accept blog');
                    return $q.reject(errResponse);
                }
                );
            return deferred.promise;
        },

        this.reject = function (id, reason) {
            console.log("calling reject ")
            return $http.get(BASE_URL + '/reject_blog/' + id)
                .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while reject blog');
                    return $q.reject(errResponse);
                }
                );
            return deferred.promise;
        },

        this.deleteBlog = function (id) {
            return $http.delete(BASE_URL + '/delete/' + id)
                .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while deleting blog');
                    return $q.reject(errResponse);
                }
                );
            return deferred.promise;
        },

        this.getBlog = function (id) {
            console.log("calling specefic blog")
            return $http.get(BASE_URL + '/get/' + id)

                .then(
                function (response) {
                    $rootScope.selectedBlog = response.data
                    console.log("data" + response.data)
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while getting blog');
                    return $q.reject(errResponse);
                }
                );
            return deferred.promise;
        }

}]);