var app = angular.module('myApp2', ['ngRoute','ngCookies']);

app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : './app/components/user/home.html',
    controller : 'UserController'
   
  })

   .when('/register', {
    templateUrl : './app/components/user/register.html',
    controller : 'UserController'
   
  })

  .when('/login', {
    templateUrl : './app/components/user/login.html',
    controller : 'UserController'
   
  })

  .when('/myProfile',{
		templateUrl:'./app/components/user/myProfile.html',
		controller : 'UserController'
	})

.when('/myhome',{
		templateUrl:'./app/components/user/myhome.html',
		controller : 'UserController'
	})

  .when('/adminhome',{
		templateUrl:'./app/components/user/adminhome.html',
		controller : 'UserController'
	})

   .when('/update-user',{
		templateUrl:'./app/components/user/update-user.html',
		controller : 'UserController'
	})

  .when('/blog', {
    templateUrl : './app/components/blog/blog.html',
    controller : 'BlogController'
   
  })

  .when('/createblog', {
    templateUrl : './app/components/blog/createblog.html',
    controller : 'BlogController'
   
  })

  .when('/listblog', {
    templateUrl : './app/components/blog/listblog.html',
    controller : 'BlogController'
   
  })

  .when('/myblog', {
    templateUrl : './app/components/blog/myblog.html',
    controller : 'BlogController'
   
  })

  .when('/sortblog', {
    templateUrl : './app/components/blog/sortblog.html',
    controller : 'BlogController'
   
  })

  .when('/viewblog', {
    templateUrl : './app/components/blog/viewblog.html',
    controller : 'BlogController'
   
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

  .when('/job_detail', {
    templateUrl : './app/components/job/view_job_detail.html',
    controller : 'JobController'
   
  })

 

  .otherwise({redirectTo: '/'});
});



// app.run(function($rootScope,$location,$cookieStore,$http){

// 	 $rootScope.$on('$locationChangeStart', function (event, next, current) {
		 
// 		 console.log("$locationChangeStart");
// 		 //http://localhost:8080/Collaboration/addjob
// 	        // redirect to login page if not logged in and trying to access a restricted page
	     
// 		 var userPages = ['/myProfile','/createblog','/updateuser','/searchFriend','/homme','/chat','/search','/chatp','/view_applied_job','/register','/sortblog','/view_job_details'];
// 		 var adminPages = ['/post_job','/adminhome','/manageusers','/rest','/sortjob'];
		 
// 		 var currentPage = $location.path();
		 
// 		 var isUserPage = $.inArray(currentPage, userPages) ===0;
// 		 var isAdminPage = $.inArray(currentPage, adminPages) ===0;
		 
// 		 var isLoggedIn = $rootScope.currentUser.userid;
// 	       // var privatefriend=$rootScope.friend;
// 	     console.log("isLoggedIn:" +isLoggedIn);
// 	     console.log("isUserPage:" +isUserPage);
// 	     console.log("isAdminPage:" +isAdminPage);
	        
// 	        if(!isLoggedIn)
// 	        	{
	        	
// 	        	 if (isUserPage || isAdminPage) {
// 		        	  console.log("Navigating to login page:")
// 		        	  alert("You need to loggin to do this operation")

// 						            $location.path('/');
// 		                }
// 	        	}
	        
// 			 else //logged in
// 	        	{
	        	
// 				 var role = $rootScope.currentUser.role;
				 
// 				 if(isAdminPage===0 && role!='admin' )
// 					 {
					 
// 					  alert("You can not do this operation as you are logged as : " + role )
// 					   $location.path('/login');
					 
// 					 }
				     
	        	
// 	        	}
	        
// 	 }
// 	       );
	 
	 
// 	 // keep user logged in after page refresh
//     $rootScope.currentUser = $cookieStore.get('currentUser') || {};
//     if ($rootScope.currentUser) {
//         $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser; 
//     }

// });


