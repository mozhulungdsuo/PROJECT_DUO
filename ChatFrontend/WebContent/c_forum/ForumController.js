myApp.controller("ForumController",function($scope,$http,$location,$route)
{
	$scope.forum={"forumName":'',"forumContent":'',"createdate":'',"username":'',"status":''}
		
	
	
	$scope.forumdata;
	
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