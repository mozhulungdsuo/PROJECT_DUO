myApp.controller("BlogController", function($scope, $http, $location,$route) {
	console.log("In BlogController");

	$scope.blog = {
		"blogName" : '',
		"blogContent" : '',
		"createDate" : '',
		"likes" : 0,
		"userName" : '',
		"status" : ''
	}

	$scope.blogData;

	$scope.insertBlog = function() {
		alert("In insert blog");
		console.log("In insertBlog method");
		$http.post('http://localhost:8081/ChatMidWare/addBlog',
				$scope.blog).then(fetchAllBlogs(), function(response) {
					$route.reload();
					console.log('Status Text ' + response.statusText);
			
		});
	};

	$scope.deleteBlog = function(blogId){
		//alert("in delete blog");
		$http.delete('http://localhost:8081/ChatMidWare/deleteBlog/'+blogId)
		.then(fetchAllBlogs(), function(response){
			console.log('Blog deleted '+ blogId);
		    console.log('Response Status ' + response.statusText);
		    $route.reload();
			$location.path('/listBlogs');
			
		});
	};
	
	$scope.incrementLike=function(blogId)
	{
            	//console.log('Enter into the incrementLike blog method');
		        $http.get('http://localhost:8081/ChatMidWare/incrementLikes/'+blogId)
		.then( fetchAllBlogs(),function(response)
		{
			  console.log('Incerement');
			  $route.reload();
			  $location.path('/listBlogs');			         
			        
				});
	};
	
	
	$scope.editBlog = function(blogId){

		$http.get('http://localhost:8081/ChatMidWare/getById/'+blogId)
		.then(function(response){
			console.log('In edit blog');
			cosole.log(blogId);
			$scope.blog = response.data;			
			$location.path('/changeBlog');
		});
	};
	$scope.updateBlog=function(blogId)
	{
		console.log('Enter into the update blog method');
		console.log(blogId);
		$http.post('http://localhost:8081/ChatMidWare/Update/'+blogId)
		.then(fetchAllBlogs(),function(response)
				{
			
			        console.log('Status Text:'+response.statusText);
			    	//$route.reload()
			        $location.path("/listBlogs");
			        
				});
	};
	
	
	function fetchAllBlogs() {
		console.log('In fetchAllBlogs method');
		$http.get('http://localhost:8081/ChatMidWare/listBlogs').then(
				function(response) {
					//console.log('Status Text ' + response.statusText);
					$scope.blogData = response.data;
				});
	};
	
	
	fetchAllBlogs();
});