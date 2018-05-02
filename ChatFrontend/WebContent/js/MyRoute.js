var myApp=angular.module("myApp",['ngRoute','ngCookies']);

myApp.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "/index.jsp"
	})
	.when("/Home",{
		templateUrl :"view/Home.html"
	})
	.when("/Login", {
		templateUrl : "c_user/Login.html"
	})
	.when("/Register", {
		templateUrl : "c_user/Register.html"
	})
	.when("/AboutUs", {
		templateUrl : "views/AboutUs.html"
	})
	.when("/ContactUs", {
		templateUrl : "views/ContactUs.html"
	})
	.when("/Blog",{
		templateUrl:"c_blog/Blog.html"
	})
   .when("/changeBlog",{
	   templateUrl:"c_blog/changeBlog.html"
    })
    .when("/Logout",{
    	templateUrl:"c_user/Logout.html"
    })
    
	 .when("/listBlogs",{
		templateUrl : "c_blog/listBlogs.html"
	})
	.when("/Forum",{
		templateUrl : "c_forum/Forum.html"
	})
	.when("/displayForum",{
		templateUrl : "c_forum/displayForum.html"
			
	})
	.when("/Job",{
		templateUrl : "c_job/Job.html"
	})
	.when("/displayJob",{
		templateUrl : "c_job/displayJob.html"
	})
	.when("/UserHome",{
		templateUrl : "c_user/UserHome.html"
	})
	.when("/chat", {
		templateUrl : "c_chat/chat.html"
	})
	.when("/friend/", {
	templateUrl : "c_friend/Friend.html"
    })
    .when("/manage",{
	templateUrl : "c_blog/manage.html"
    })
    .when("/Update",{
    	templateUrl :"c_user/Update.html"
    })
  

});


myApp.run(function($rootScope,$cookieStore)
		{
			console.log('I am in run function');
			console.log($rootScope.currentUser);
			
				if($rootScope.currentUser==undefined)
				{
				$rootScope.currentUser=$cookieStore.get('userDetails');
				//$rootScope.currentBlog=$cookieStore.get('blogDetails');
				//$rootScope.currentForum=$cookieStore.get('forumDetails');
				}
				else
				{
				console.log($rootScope.currentUser.userName);
				console.log($rootScope.currentUser.role);
				}
		});