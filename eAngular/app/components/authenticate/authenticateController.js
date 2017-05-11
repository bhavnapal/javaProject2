AuthenticateModule.controller('AuthenticateController', ['AuthenticateService', '$scope', '$location', '$timeout', function (AuthenticateService, $scope, $timeout) {
  
    var self = this;
    self.credentials = {};
    self.error = false;
    self.authError = false;
    self.client = { id: undefined, firstName: '', lastName: '', username: '', emailId: '', password: '', confirmPassword: '', role: '', gender: '' };

    // once the controller loads call the jQuery
    $timeout(function () {
        load();
    }, 100);

    self.login = function () {
        AuthenticateService.login(self.credentials)
            .then(
            function (user) {
                if (user.enabled === 'FALSE') {
                    self.authError = true;
                    $scope.message = "Your account has been blocked."
                }else if(user.status === 'REJECT'){
                    self.authError = true;
                    $scope.message = "Your account has not been approved."
                } else if (user.status === 'PENDING') {
                    self.authError = true;
                    $scope.message = "Sorry! You are not been approved yet!.";
                } else if (user.userId == '' || user.userId == undefined || user.username == null) {
                    self.authError = true;
                    $scope.message = "Incorrect username or password."
                } else {
                    AuthenticateService.setUserIsAuthenticated(true);
                    AuthenticateService.setRole(user.role);
                    $scope.authenticated = true;
                    $scope.message = 'Welcome ' + user.firstName;
                    AuthenticateService.saveUser(user);

                    switch (user.role) {
                        case 'ADMIN':
                            $location.path('/user/home');
                            $scope.isAdmin = true;
                            break;
                        case 'USER':
                            $location.path('/user/home');
                            $scope.isUser = true;
                            break;
                        default:
                            $location.path('/error/403');
                    }
                    $scope.islogin = true;
                }
                console.log(user);
            },
            function (errorResponse) {
                console.log(errorResponse);
                AuthenticateService.setUserIsAuthenticated(false);
                $scope.authenticated = false;
                self.error = true;
            }
            )
    }


    self.register = function () {
        AuthenticateService.register(self.client)
            .then(
            function (user) {
                AuthenticateService.setUserIsAuthenticated(false);
                $scope.authenticated = false;
                self.register = true;
                $scope.msg = "Registration successful! You will get an email after approval.";
                $location.path('/login');
            },
            function (errorResponse) {
                console.log(errorResponse);
                AuthenticateService.setUserIsAuthenticated(false);
                $scope.authenticated = false;
                self.error = true;
            }
            )
    }

}]);