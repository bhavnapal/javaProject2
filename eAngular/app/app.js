var app = angular.module('chatApp', ['ngRoute', 'ngCookies','LoginModule','AdminModule','BlogModule','UserModule']);

var app=angular.module('chatApp');

app.controller('MainController',function($cookieStore,$route,$scope,$rootScope,$location,$cookies){
    $scope.name='eallianz';
    this.name='eallianz';
    $rootScope.userrole=$cookies.get('role');
    $rootScope.authentiated=$cookies.get('authentiated');

    this.logout=function()
    {
        $cookies.remove('authentiated');
        $cookies.remove('role');
        $cookieStore.remove('currentUser');
        $rootScope.currentUser={};
        $rootScope.authentiated=false;
        $rootScope.userrole='';
        $route.reload();
        $location.path("/");
        
        
    }

});

app.constant('BASE_URL','http://localhost:9090/onlinecollaboration');

app.config(function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl : './app/components/user/myhome.html',
    controller : 'UserController',
    //controllerAs: 'home'
  })

   .when('/register', {
    templateUrl : './app/components/user/register.html',
    controller : 'RegController',
    controllerAs:'regCtrl'
  })

  .when('/login', {
    templateUrl : './app/components/user/login.html',
    controller : 'LoginController',
   controllerAs:'loginctrl'
  })

  .when('/myProfile',{
		templateUrl:'./app/components/user/myProfile.html',
		controller : 'UserController'
	})

.when('/myhome',{
		templateUrl:'./app/components/user/myhome.html',
		controller : 'UserController',
    controllerAs:'userCtrl'
	})

  .when('/adminhome',{
		templateUrl:'./app/components/admin/adminhome.html',
		controller : 'AdminController',
    controllerAs: 'adminCtrl'
	})

   .when('/update-user',{
		templateUrl:'./app/components/user/update-user.html',
		controller : 'UserController',
    controllerAs:'userCtrl'
	})

  .when('/blog', {
    templateUrl : './app/components/blog/blog.html',
    controller : 'BlogController',
    controllerAs: 'blogCtrl'
  })

  .when('/createblog', {
    templateUrl : './app/components/blog/createblog.html',
    controller : 'BlogController',
   controllerAs: 'blogCtrl'
  })

  .when('/listblog', {
    templateUrl : './app/components/blog/listblog.html',
    controller : 'BlogController',
    controllerAs: 'blogCtrl'
  })

  .when('/myblog', {
    templateUrl : './app/components/blog/myblog.html',
    controller : 'BlogController',
    controllerAs: 'blogCtrl'
  })

  .when('/sortblog', {
    templateUrl : './app/components/blog/sortblog.html',
    controller : 'BlogController',
    controllerAs: 'blogCtrl'
  })

  .when('/viewblog', {
    templateUrl : './app/components/blog/viewblog.html',
    controller : 'BlogController',
    controllerAs: 'blogCtrl'
  })

  .when('/friend', {
    templateUrl : './app/components/user/friend.html',
    controller : 'FriendController'
   
  })
  
   .when('/post_job', {
    templateUrl : './app/components/job/post_job.html',
    controller : 'JobController'
   
  })

  .when('/search_job', {
    templateUrl : './app/components/job/search_job.html',
    controller : 'JobController'
   
  })

  .when('/sortjob', {
    templateUrl : './app/components/job/sortjob.html',
    controller : 'JobController'
   
  })

  .when('/applied_job', {
    templateUrl : './app/components/job/view_applied_job.html',
    controller : 'JobController'
   
  })
  //For assigning role to the user and to update or delete user
   .when('/manage/users', {
        templateUrl : './app/components/user/manageUser.html',
        controller : 'AdminController',
        controllerAs : 'adminCtrl'
   })

  .when('/job_detail', {
    templateUrl : './app/components/job/view_job_detail.html',
    controller : 'JobController'
   
  })

  .otherwise({
    redirectTo: '/index.html'
  });
});


