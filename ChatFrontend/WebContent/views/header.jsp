<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a class="navbar-brand" href="#">ChatZies</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      <li ><a href="#!Home">Home</a></li>	
     				
				<li ng-if="currentUser!=undefined" ng-show="currentUser.role=='ROLE_USER' ||currentUser.role=='ROLE_ADMIN'"><a href="#!Blog">Blog</a></li>
				<li ng-if="currentUser!=undefined" ng-show="currentUser.role=='ROLE_USER'||currentUser.role=='ROLE_ADMIN'"> <a href="#!listBlogs"> List Blogs</a></li>				
				<li ng-if="currentUser!=undefined" ng-show="currentUser.role=='ROLE_USER'||currentUser.role=='ROLE_ADMIN'" ><a href="#!Forum">Forum</a>	</li>
				<li ng-if="currentUser!=undefined" ng-show="currentUser.role=='ROLE_USER'||currentUser.role=='ROLE_ADMIN'"><a href="#!displayForum">List Forums</a></li>
				<li ng-if="currentUser!=undefined"  ng-show="currentUser.role=='ROLE_ADMIN'"><a href="#!Job">Job</a></li>
				<li ng-if="currentUser!=undefined" ng-show="currentUser.role=='ROLE_ADMIN'|| currentUser.role=='ROLE_USER'"><a href="#!displayJob">Job Lists</a></li>
				<li ng-if="currentUser!=undefined"  ng-show="currentUser.role=='ROLE_ADMIN'"><a href="#!applicationList">Applications</a></li>	
				 <li ng-if="currentUser!=undefined" ng-show="currentUser.role=='ROLE_USER'||currentUser.role=='ROLE_ADMIN'">
				 <a href="#!Update">Profile</a></li>  					
				<li ng-if="currentUser!=undefined"  ng-show="currentUser.role=='ROLE_USER'||currentUser.role=='ROLE_ADMIN' "><a href="#!chat">Chat</a></li>
				<li ng-if="currentUser!=undefined"  ng-show="currentUser.role=='ROLE_USER'||currentUser.role=='ROLE_ADMIN'"><a href="#!friend">Friends</li>
				
      </ul>
      <ul class="nav navbar-nav navbar-right" >
      <li ng-show="currentUser==undefined"><a href="#!AboutUs">About Us</a></li>
	  <li ng-show="currentUser==undefined"><a href="#!ContactUs">Contact Us</a></li>
      <li ng-show="currentUser==undefined"><a href="#!Register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
      <li ng-show="currentUser==undefined"><a href="#!Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
         <ul class="nav navbar-nav navbar-right"  ng-if="currentUser!=undefined">
         <font color="white">Welcome {{currentUser.userName}}</font>
		<img id="img1" class="avatar" src="http://localhost:8081/ChatMidWare/getImage/{{currentUser.userName}}"   width="40" height="40"></img>		 		
		<form ng-controller="UserController"><input type="submit" value="logout" ng-click="logout()" class="btn btn-info"/></form>
      </ul>
    </div>
  </div>
</nav>
      
		           