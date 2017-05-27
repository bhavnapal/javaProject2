var BasicModule = angular.module('chatapp', []);

BasicModule.controller('BasicController', ['BasicService', '$scope', function(BasicService,$scope) {
    BasicService.getGreeting().then(
        function(greeting) {
            this.greeting = greeting;
        },
        function (error) {
            console.log(error);
        }
    );
}]);