myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore)
{
	$scope.user={userName:'',password:'',role:'',email:'',gender:'',status:'',dob:'',status:'',contactNo:'',age:'',firstname:'',lastname:''};
	
$scope.userdata;
	
	
	$scope.Register=function()
	{
		console.log("Enter into Register Method");
		$http.post('http://localhost:8081/ChatMidWare/addUser',$scope.user)
		.then(fetchAllUser(),function(response)
     	{
			console.log('Status Text:'+response.statusText);
			$scope.msg="Data inserted sucessfully";
			$route.reload();
		
	     });			
	};
	$scope.updateUser=function(userName)
	{
		console.log('Enter into the update  method');
		console.log(userName);
		$http.put('http://localhost:8081/ChatMidWare/UpdateUser/'+userName,$scope.user)
		.then(fetchAllUser(),function(response)
				{
			
			        console.log('Status Text:'+response.statusText);
			        //$route.reload()			   
			       // $location.path("/listBlogs");
			      
				});
	};
	$scope.editUser = function(userName){
        alert("ello");
        console.log("edit Function");
		$http.get('http://localhost:8081/ChatMidWare/getUserById/'+userName)
		.then(function(response){
			//console.log('In edit blog');
			console.log(userName);
			$scope.user = response.data;			
			//$location.path('/changeBlog');
		});
	};
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
					if($rootScope.currentUser.role=="ROLE_ADMIN")
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
	function fetchAllUser()
	{
		console.log('Fetching All Users');
		$http.get("http://localhost:8081/ChatMidWare/listUsers")
		.then(function(response)
				{
			            $scope.userdata=response.data;
				});
	}
	
	
	
	
	fetchAllUser();
	
});

