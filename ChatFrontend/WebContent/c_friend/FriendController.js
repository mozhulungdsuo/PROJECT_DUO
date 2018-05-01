myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
{
	$scope.friend={"userName":'',"frienduseName":'',"status":''};
	$scope.users={"userName":'',"password":'',"role":'',"email":'',"gender":'',"status":'',"dob":'',"status":'',"contactNo":'',"age":''};
	
	$scope.suggestedFriend;
	$scope.insertFriend = function(frienduseName) {
		
		
		$http.post('http://localhost:8081/ChatMidWare/sendFriendRequest/'+frienduseName,
				$scope.friend).then( function(response) {
					
					console.log('Status Text ' + response.statusText);
					$route.reload();					
					
			
		});
	};
	
	$scope.showFriends=function(){
		$http.get('http://localhost:8081/ChatMidWare/testFriends')
		.then(function(response){
			
	       
			$scope.users = response.data;	
		});
	};
	function friendData()
	{
		console.log('Friend data');
		$http.get('http://localhost:8081/ChatMidWare/showPendingRequest')
		.then(function(response)
				{
			      $scope.friend=response.data;
			      console.log($scope.friend);
				});
	}
	
	
});