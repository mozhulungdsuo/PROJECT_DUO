
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index.jsp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
<script src="MyRoute.js"></script>
<style>
.navbar-brand {
	padding: 0px;
}

.navbar-brand>img {
	height: 160%;
	padding-bottom: 20px;
	width: auto;
}

.example3 .navbar-brand {
	height: 80px;
}

.example3 .nav>li>a {
	padding-top: 30px;
	padding-bottom: 30px;
}

.example3 .navbar-toggle {
	padding: 10px;
	margin: 25px 15px 25px 0;
}

span {
	color: "#3399FF";
	font-size: 20px;
	font-style: italic;
}
</style>
</head>
<body ng-app="myApp">
	<div class="example3">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar3">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				
				<!-- <ul class="nav navbar-nav navbar-left">
       <li> <a class= "navbar-brand"><span style="color:#4C9900">FrenzzCollab</span></a></li></ul> -->
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="#!Home">Home</a></li>
				<li><a href="#!Login">Login</a></li>
				<li><a href="#!Register">Register</a></li>
				<li><a href="#!About Us">About Us</a></li>
				<li><a href="#!Contact Us">Contact Us</a></li>
			</ul>
		</div>
		</nav>
	</div>
	This is index
	<div ng-view> </div>
	

</body>
</html>
