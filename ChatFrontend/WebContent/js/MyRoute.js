
var myApp=angular.module("myApp",["ngRoute"]);

myApp.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "/index.jsp"
	})
	.when("/Home",{
		templateUrl :"/index.jsp"
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
});

