
// app.controller('BlogController', function($scope) {
	
// 	console.log("This is from BlogController");
	
// 	$scope.message = "Message from Blog Controller..."
		
		
		
// 	$scope.blog={"id" : "B101",  "title" : "AngularJS" ,  "description" : "Angular js is front end MVC framework based on js"}	
		
	

// } );


'use strict';
 
app.controller('BlogController', ['$scope', 'BlogService','$location','$rootScope','$route',function($scope, BlogService,$location,$routeParams,$rootScope,$route) {
	console.log("BlogController...")
          var self = this;
          self.blog={
		  blogId:'',
		  blogName:'',
		  userId:'',
		  blogStatus:'',
		  blogDescription:''};
          self.blogs=[];
         // $scope.id = $routeParams.id;
          
          
         self.getSelectedBlog = getBlog
          
          function getBlog(blogId){
        	  console.log("->getting blog :"+blogId)
              BlogService.getBlog(blogId)
                  .then(
                               function(d) {
                                     //self.blog = d;
                            	   console.log(d)
                                     $location.path('/viewblog'); 
                               },
                                function(errResponse){
                                    console.error('Error while fetching Blogs');
                                }
                       );
          };
          
        
         //method definition
          self.fetchAllBlogs = function(){
              BlogService.fetchAllBlogs()
                  .then(
                               function(d) {
                                    self.blogs = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Blogs');
                                }
                       );
          };
            
          self.createBlog = function(blog){
              BlogService.createBlog(blog)
                      .then(
                    		  function(data) {
									self.blog = data;
									alert("Blog Created Successfully");
								}, 
                              function(errResponse){
                                   console.error('Error while creating Blog.');
                              } 
                  );
          };
 
         self.updateBlog = function(blog, blogId){
              BlogService.updateBlog(blog,blogId)
                      .then(
                              self.fetchAllBlogs, 
                              function(errResponse){
                                   console.error('Error while updating Blog.');
                              } 
                  );
          };
          
          self.accept = function(blogId) {
				console.log("accept...")
				BlogService
						.accept(id)
						.then(
								function(d) {
									self.blog = d;
									self.fetchAllBlogs
									//$location.path("/manage_jobs")
									alert(self.blog.errorMessage);
									$route.reload();
									
								},
								
								function(errResponse) {
									console
											.error('Error while accepting the blog.');
								});
			};
			
			self.reject = function(blogId) {
				console.log("reject...")
				BlogService
						.reject(blogId)
						.then(
								function(d) {
									self.blog = d;
									self.fetchAllBlogs
									//$location.path("/manage_jobs")
									alert(self.blog.errorMessage)
									$route.reload();
								},
								function(errResponse) {
									console
											.error('Error while updating User.');
								});
			};

 
               //calling the method
          //when it will be execute?
         // self.fetchAllBlogs();
 
          self.submit = function() {
           
                  console.log('Saving New Blog', self.blog);
            //      self.blog.userId=$rootScope.currentUser.userId
                  self.createBlog(self.blog);
            
              //self.reset();
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.blogs.length; i++){
                  if(self.blogs[i].id === id) {
                     self.blog = angular.copy(self.blogs[i]);
                     break;
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.blog.id === id) {//clean form if the blog to be deleted is shown there.
                 self.reset();
              }
              self.deleteBlog(id);
          };
 
           
          self.reset = function(){
        	   self.blog={id:'',title:'',userid:'',status:'',reason:'',description:'',datetime:'',errorCode : '',errorMessage : ''};
               $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);