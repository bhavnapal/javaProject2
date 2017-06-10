FriendModule.controller('FriendController',function(FriendServices,$rootScope,$cookies,$cookieStore)
{
    this.message="this is friend controller";
  	
	var  frndCtrl=this;
    this.allUsers={}
    frndCtrl.friendShip={};
    frndCtrl.currentUser=$cookieStore.get("currentUser");
    this.allUsersfun=function()
    {
         FriendServices.allUsersfun().then
         (
             function(success)
             {
                 console.log(success);
                 $cookieStore.put('allUsers',success.data);
                 frndCtrl.allUsers=success.data;

             },
             function(error)
             {
                 console.log(error);
             }
         )
    }

     this.getFriends=function()
     {
        FriendServices.getFriends(frndCtrl.currentUser).then(

            function(response)
            {
                console.log(response);
                frndCtrl.friends=response.data;

            },
            function(error)
            {
                console.log(error);
            }
        )
     }

    this.allUsersfun();
    this.getFriends();

    this.addFriend=function(friendid)
    {
        alert(friendid);
       
       angular.forEach(frndCtrl.allUsers,function(value,key)
       {
           console.log(value.userId==friendid)
           if(value.userId==friendid)
           {
               frndCtrl.friend=value;
           }
       });
       frndCtrl.friendShip.user=frndCtrl.currentUser;
       frndCtrl.friendShip.friend=frndCtrl.friend;
       FriendServices.addFriend(frndCtrl.friendShip).then(

           function(response)
           {
               console.log(response);
           },function(error)
           {
               console.log(error);
           }
       )
       
    }
});
