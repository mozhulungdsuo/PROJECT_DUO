myApp.controller("ForumController",function($scope,$http,$location,$route)
{
	$scope.forum={"forumName":'',"forumContent":'',"createdate":'',"username":'',"status":''}
		
	
	
	$scope.forumdata;
	

	$scope.forumcomment={
			
			"forumId":'',
			"commentDate":'',
		    "userName":'',			
			"commentText":''
					
	}
	$scope.forumcommentData;
	
	$scope.insertForum=function()
	{
		console.log("Enter inside insertForum Method");
		$http.post('http://localhost:8081/ChatMidWare/addForum',$scope.forum)
		.then(fetchAllForum(),function(response)
     	{
			console.log('Status Text:'+response.statusText);
			$scope.msg="Data inserted sucessfully";
		    $route.reload();
	     });			
	};
	
	
	
	$scope.deleteForum=function(forumId)
	{
		console.log('Enter into the delete forum method');
		$http.delete('http://localhost:8081/ChatMidWare/deleteforum/'+forumId)
		.then(fetchAllForum(),function(response)
				{
			        console.log('Deleted');
			        $route.reload();
			        $location.path("/displayForum");
				});
	};
	
	$scope.editForum = function(forumId){

		$http.get('http://localhost:8081/ChatMidWare/getForumById/'+forumId)
		.then(function(response){
			console.log('In edit blog');
			console.log(forumId);
			$scope.forum = response.data;			
			
		});
	};
	$scope.insertForumComment = function(forumId) {
		alert("In insert forum comment ");
		
		$http.post('http://localhost:8081/ChatMidWare/addForumComment/'+forumId,
				$scope.forumcomment).then( function(response) {
					console.log('Status Text ' + response.statusText);
					$route.reload();					
					$location.path('/displayForum');
			
		});
	};
	
	$scope.deleteForumComment = function(commentId){
		
		$http.delete('http://localhost:8081/ChatMidWare/deleteForumComment/'+commentId)
		.then(fetchAllForum(), function(response){
			
		    console.log('Response Status ' + response.statusText);
		    $route.reload();
			
			
		});
	};
	$scope.listForumComments = function(forumId){

		$http.get('http://localhost:8081/ChatMidWare/listForumComments/'+forumId)
		.then(function(response){
			
			console.log(forumId);
			$scope.forumcommentData = response.data;			
			
		});
	};
	
	function fetchAllForum()
	{
		console.log('Fetching All Forums');
		$http.get('http://localhost:8081/ChatMidWare/listForums')
		.then(function(response)
				{
			            $scope.forumdata=response.data;
				});
	}
	
	
	
	
	fetchAllForum();
	
});