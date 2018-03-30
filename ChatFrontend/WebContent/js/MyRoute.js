
var myApp = angular.module("myApp", [ "ngRoute" ]);

myApp.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "/index.jsp"
	})
	.when("/Home",{
		templateUrl :"/index.jsp"
	})
	.when("/Login", {
		templateUrl : "views/Login.html"
	})
	.when("/Register", {
		templateUrl : "views/Register.html"
	})
	.when("/AboutUs", {
		templateUrl : "views/AboutUs.html"
	})
	.when("/ContactUs", {
		templateUrl : "views/ContactUs.html"
	})

});