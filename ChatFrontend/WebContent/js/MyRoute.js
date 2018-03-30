
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
   .when("/UpdateBlog",{
	   templateUrl:"c_blog/UpdateBlog.html"
    })
    .when("/Logout",{
    	templateUrl:"c_user/Logout.html"
    })
    .when("/displayBlog",{
		templateUrl : "c_blog/DisplayBlog_page.html"
	})
});

