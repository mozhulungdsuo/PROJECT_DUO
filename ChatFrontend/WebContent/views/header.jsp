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
      <li class="active"><a href="#!Home">Home</a></li>	
     				
				<li ng-hide="currentUser==undefined" ng-show="currentUser.role=='ROLE_USER'"><a href="#!Blog">Blog</a></li>
				<li ng-hide="currentUser==undefined" ng-show="currentUser.role=='ROLE_USER'"> <a href="#!listBlogs"> List Blogs</a></li>
				
				<li ng-hide="currentUser==undefined" ng-show="currentUser.role=='ROLE_USER'" ><a href="#!Forum">Forum</a>	</li>
				<li ng-hide="currentUser==undefined" ng-show="currentUser.role=='ROLE_USER'"><a href="#!displayForum">List Forums</a></li>
				<li ng-hide="currentUser==undefined" ng-show="currentUser.role=='ROLE_ADMIN'"><a href="#!Job">Job</a></li>
				<li ng-hide="currentUser==undefined" ng-show="currentUser.role=='ROLE_ADMIN'"><a href="#!displayJob">Job Lists</a></li>	
				 <li ng-hide="currentUser==undefined" ng-show="currentUser.role=='ROLE_USER'||currentUser.role=='ROLE_ADMIN'">
				 <a href="#!Update">Update Profile</a></li>
              
                
				
				
				
				
					
				<li ng-hide="currentUser==undefined"  ng-show="currentUser.role=='ROLE_USER'"><a href="#!chat">Chat</a></li>
				<li ng-hide="currentUser==undefined"  ng-show="currentUser.role=='ROLE_USER'"><a href="#!friend">Find Friends</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right" >
      <li ng-hide="currentUser.role=='ROLE_USER'|| currentUser.role=='ROLE_ADMIN'"><a href="#!AboutUs">About Us</a></li>
	  <li ng-hide="currentUser.role=='ROLE_USER'|| currentUser.role=='ROLE_ADMIN'"><a href="#!ContactUs">Contact Us</a></li>
        <li ng-hide="currentUser.role=='ROLE_USER'|| currentUser.role=='ROLE_ADMIN'"><a href="#!Register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
        <li ng-hide="currentUser.role=='ROLE_USER'|| currentUser.role=='ROLE_ADMIN'"><a href="#!Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
         </ul>
         <ul class="nav navbar-nav navbar-right"  ng-hide="currentUser==undefined">
         <font color="white">Welcome {{currentUser.userName}}</font>
		<img id="img1" class="avatar" src="http://localhost:8081/ChatMidWare/getImage/{{currentUser.userName}}" width="20 height=20"></img>		 		
		<form ng-controller="UserController"><input type="submit" value="logout" ng-click="logout()" class="btn btn-info"/></form>
      </ul>
    </div>
  </div>
</nav>
      
		           