myApp.controller("Friend_duo",function($scope,$http,$location,$rootScope)
{
	$scope.users={"userName":'',"password":'',"role":'',"email":'',"gender":'',"status":'',"dob":'',"status":'',"contactNo":'',"age":'',"firstname":'',"lastname":''};
	
	$scope.suggestedFriend;
	$scope.showFriends=function(){
		$http.get('http://localhost:8081/ChatMidWare/testFriends')
		.then(function(response){
			
	       
			$scope.suggestedFriend = response.data;	
		});
	};
	
	
	
});