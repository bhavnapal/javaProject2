var UserModule=angular.module('UserModule',['ngCookies','ngRoute']); 
UserModule.service('UserServices', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("UserService...")
	
	var BASE_URL='http://localhost:9090/onlinecollaboration/user'
	
           this. fetchAllUsers=function() {
            	console.log("calling fetchAllUsers ")
                    return $http.get(BASE_URL+'/all')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                   null
                            );
                             return deferred.promise;
            },
            
            this.myProfile= function() {
            	console.log("calling myProfile ")
                    return $http.get(BASE_URL+'/myProfile')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                   null
                            );
                             return deferred.promise;
            },
            
           this.accept= function(id) {
            	console.log("calling approve ")
                    return $http.get(BASE_URL+'/accept/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while accept registration');
                                       
                                    }
                            );
                             return deferred.promise;
            },
            
            this.reject=function(id) {
            	console.log("calling reject ")
                    return $http.get(BASE_URL+'/reject/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    null
                            );
                             return deferred.promise;
            },
             
            this.createUser=function(user){
            	console.log("calling create user")
                    return $http.post(BASE_URL+'/insert', user) 
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            this.updateUser= function(user){
            	console.log("calling fetchAllUsers ")
                     return $http.put(BASE_URL+'/updateUser', user) 
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
              
            this.logout= function(){
            	console.log('logout....')
                return $http.get(BASE_URL+'/logout')
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                              null
                        );
                         return deferred.promise;
        },
        
        
            this.login= function(user){
            	   console.log("Calling the method authenticate with the user :"+user)
          		return $http.post(BASE_URL+'/login',user)
                        .then(
                                function(response){
                                    return response.data;   //user json object
                                }, 
                               function(errResponse){
                                   console.error('error while login user');
                                   return $q.reject(errResponse);
                               }
                        );
                         return deferred.promise;
       }
         
    }
 
]);