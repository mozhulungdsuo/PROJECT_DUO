
var myApp = angular.module("myApp", [ "ngRoute" ]);

myApp.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "/index.jsp"
	})
	.when("/Login", {
		templateUrl : "views/Login.html"
	})
	.when("/Register", {
		templateUrl : "views/Register.html"
	})
	.when("/About Us", {
		templateUrl : "/AboutUs.htm"
	})
	.when("/Contact Us", {
		templateUrl : "/ContactUs.htm"
	})

});