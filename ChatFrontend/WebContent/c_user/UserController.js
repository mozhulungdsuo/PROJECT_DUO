myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore)
{
	$scope.user={userName:'',password:'',role:'',email:'',address:'',status:''};
	
	$rootScope.login=function()
	{
		console.log("Logging Function");
		
		$http.post('http://localhost:8081/ChatMidWare/login',$scope.user)
			.then(function(response)
			{
				console.log(response.status);
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				$cookieStore.put('userDetails',response.data);
				console.log($rootScope.currentUser.role);
					if($rootScope.currentUser.role=="ROLEADMIN")
					{
						console.log('AdminPage');
					}
					else
					{
						console.log('UserPage');
					}
				$location.path("/UserHome");
			});
	};
	$rootScope.logout=function()
	{
		console.log('Logout Function');
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetails');
		$location.path("/Logout");
	}
	
});