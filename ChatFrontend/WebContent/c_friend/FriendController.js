myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
{
	$scope.friend={"friendId":'',"userName":'',"frienduseName":'',"status":''};
	$scope.users={"userName":'',"password":'',"role":'',"email":'',"gender":'',"status":'',"dob":'',"status":'',"contactNo":'',"age":''};
	$scope.friendnumber;
	$scope.suggestedFriend;
	$scope.pendingRequest;
	$scope.friendlist;
	$scope.friendwithlist;
	$scope.insertFriend = function(frienduseName) {
		
		
		$http.post('http://localhost:8081/ChatMidWare/sendFriendRequest/'+frienduseName,
				$scope.friend).then( function(response) {
					
					console.log('Status Text ' + response.statusText);
					$route.reload();					
				
			
		});
	};
$scope.deleteFriend = function(friendId) {
		
		
		$http.post('http://localhost:8081/ChatMidWare/deleteFriendRequest/'+friendId,
				$scope.friend).then( function(response) {
					
					console.log('Status Text ' + response.statusText);
					$route.reload();					
				
			
		});
	};
	
	$scope.acceptFriend=function(friendId){
		$http.get('http://localhost:8081/ChatMidWare/acceptFriendRequest/'+friendId)
		.then(function(response){
			console.log('in accept request');
			$route.reload();
			$location.path("/friend");
			
		});
	};
	
	$scope.showFriends=function(){
		$http.get('http://localhost:8081/ChatMidWare/testFriends')
		.then(function(response){
			
	       
			$scope.suggestedFriend = response.data;	
		});
	};
	$scope.showPendingFriends=function(userName){
		$http.get('http://localhost:8081/ChatMidWare/showPendingRequest/'+userName)
		.then(function(response){
			
	       
			$scope.pendingRequest = response.data;	
		});
	};
	$scope.showFriendsNumber=function(userName){
		$http.get('http://localhost:8081/ChatMidWare/showPendingRequestNumber/'+userName)
		.then(function(response){
			
	       
			$scope.friendnumber = response.data;	
		});
	};
	$scope.showAllFriends=function(userName){
		$http.get('http://localhost:8081/ChatMidWare/showAllFriends/'+userName)
		.then(function(response){
			
	       
			$scope.friendlist = response.data;	
		});
	};
	$scope.showAllFriendWith=function(userName){
		$http.get('http://localhost:8081/ChatMidWare/showFriendWith/'+userName)
		.then(function(response){
			
	       
			$scope.friendwithlist = response.data;	
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