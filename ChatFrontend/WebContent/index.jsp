
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
<script 
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>
	<script 
     src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.16.3/lodash.js"></script>
<script 
     src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script 
     src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.1/sockjs.js"></script>
<script src="js/MyRoute.js"></script>
<script src="c_blog/BlogController.js"></script>
<script src="c_user/UserController.js"></script>
<script src="c_forum/ForumController.js"></script>
<script src="c_job/JobController.js"></script>
<script src="c_chat/ChatController.js"></script>
<script src="c_chat/ChatService.js"></script>

</head>
<body ng-app="myApp">

	<%@include file="views/header.jsp" %>	

	<div ng-view> 
	
	</div>
	

</body>
</html>
