var FriendModule=angular.module('FriendModule',['ngRoute']);


FriendModule.service('FriendServices',function($http,$q,REST_URI)
{
    this.allUsersfun=function()
    {
        var deffered=$q.defer();
        $http.get(REST_URI+"allusers").then
        (
            function(success)
            {
                console.log(success);
                deffered.resolve(success);
            },
            function(error)
            {
                console.log(error);
                deffered.reject(error);
            }
        )
        return deffered.promise;
       
    }
 

    this.getFriends=function(user)
    {
        var deffered=$q.defer();
        $http.post(REST_URI+"getfriends",user)
       .then(
           function(response)
           {
               console.log(response);
               deffered.resolve(response);
           },function(error)
           {
               console.log(error);
               deffered.reject(error);
           }
       )
       return deffered.promise;
    }
    
    this.addFriend=function(friendShip)
    {
        var deffered=$q.defer();
        $http.post(REST_URI+"addfriend",friendShip).then
        (
            function(response)
            {
                console.log(response);
                deffered.resolve(response);
            },function(error)
            {
                console.log(error);
                deffered.reject(error);
            }
        )
        return deffered.promise;
    }
});