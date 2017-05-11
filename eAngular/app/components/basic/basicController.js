
var basic = angular.module('basicModule',[]);

basic.controller('homeController',['$scope', function(c){
    c.message = 'welcome to collaboration. I am in home page.'
}]);

basic.controller('contactController',['$scope', function(c){
    c.message = 'I am in contact page.'
}]);

basic.controller('aboutController',['$scope', function(c){
    c.message = 'I am in about page.'
}]);