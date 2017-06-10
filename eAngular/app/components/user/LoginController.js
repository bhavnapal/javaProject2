LoginModule.controller('LoginController', function (LoginServices, $rootScope, $cookies, $location, $cookieStore) {
    this.user = {};
    var login = this;
    this.userrole = '';
    this.invalid = '';
    this.login = function () {
        console.log(login.user);
        LoginServices.login(login.user).then(
            function (response) {

                console.log(response);
                console.log('user as' + response.data.role);

                $cookieStore.put('currentUser', response.data);
                $rootScope.currentStore = $cookieStore.get('currentUser');
                $cookies.put("authentiated", true);

                $rootScope.authentiated = true;
                if (response.data.role == 'admin') {
                    $cookies.put('role', response.data.role);
                    $rootScope.userrole = $cookies.get('role');
                    $location.path("/adminhome");
                } else if (response.data.role == 'user') {
                    $cookies.put('role', response.data.role);
                    $rootScope.userrole = $cookies.get('role');
                    $location.path("/myhome");
                }
                else {
                    alert("not a valid credentials");
                    $cookies.put('role', response.data.role);
                    $rootScope.userrole = $cookies.get('role');
                    $location.path('/index');
                }
            },
            function (error) {
                console.log(error);
                if (error.status == '401') {
                    login.invalid = true;
                }
                if (error.status == '304') {
                    login.notVerified = true;
                }

            }
        )



    }

});

LoginModule.controller('RegController', function (RegService, $location) {

    this.user = {};
    var register = this;
    this.regis = function () {
        alert("You are registered");
        console.log(register.user);
        RegService.register(register.user).then(
            function (response) {
                console.log(response);
                alert("Thank you for registration.your user id is:" + response.data.userId);
                $location.path("/login");

            },
            function (error) {
                console.log(error);
            }
        );
    }
})