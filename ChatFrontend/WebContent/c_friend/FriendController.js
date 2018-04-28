myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
{
	$scope.friend={"friendId":0,"userName":'',"frienduserName":'',"status":''};
	$scope.acceptfrienddata;
	$scope.pendingFriendRequest;
	
	
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
	friendData();
});