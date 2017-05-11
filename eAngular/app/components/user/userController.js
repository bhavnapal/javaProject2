UserModule.controller('UserController', ['$rootScope', 'UserService', 'AuthenticateService', '$routeParams', '$timeout', function ( $rootScope, UserService, AuthenticateService, $routeParams, $timeout) {
    var self = this;
    self.user = {};
    self.users = [];   
    self.submit = submit;
    self.userList = [];

   self.getUser = function () {
    
        getUserId = $rootScope.user.id;
        console.log(getrId);
        UserService.getUser(getId)
            .then(
            function (d) {
                self.client = d;
                console.log(self.client);
            },
            function (errResponse) {
                console.error('Error while updating User');
            }
            );
    }


   self.updateUser = function (user, id) {
        UserService.updateUser(user, id)
            .then(
            function (d) {
                self.user = d;
                AuthenticateService.saveUser(user);
                AuthenticateService.loadUserFromCookie();
                console.log(self.user);
            },
            function (errResponse) {
                console.error('Error while updating User');
            }
            );
    }

    self.submit = function () {
        if (self.client.userId != '' || self.client.userId != undefined) {
            updateUser(self.client, self.client.userId);
            console.log('User updated with id ', self.client.userId);
        }
    }

    self.picture = undefined;

    self.customer = AuthenticateService.loadUserFromCookie();
    console.log(self.customer);
    // the decached technique is used to see the updated image immediately with out page refresh
    self.customer.profileId = self.customer.profileId + '?decached=' + Math.random();

    // once the controller loads call the jQuery
    $timeout(function () {
        load();
    }, 100);

    // to upload the file    
    self.uploadFile = function () {
        if (self.picture == undefined) {
            return;
        }
     }

   
   self.getLatestUsers = function () {
        UserService.getLatestUsers().
            then(function (data) {
                console.log(data);
                self.userList = data;
                if (self.userList.length <= 0) {
                    self.none = true;
                }
                self.failed = false;
            }, function (errResponse) {
                console.error(errResponse);
                self.failed = true;
            });

    }

  

}]);

