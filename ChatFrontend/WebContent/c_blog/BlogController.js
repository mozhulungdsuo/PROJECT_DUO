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
	
	$scope.blogcomment={
			
			"blogId":'',
			"commentDate":'',
		    "username":'',			
			"commentText":''
					
	}
	$scope.blogcommentData;
	

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
			console.log(blogId);
			$scope.blog = response.data;			
			
		});
	};
	
	$scope.updateBlog=function(blogId)
	{
		console.log('Enter into the update blog method');
		console.log(blogId);
		$http.put('http://localhost:8081/ChatMidWare/UpdateBlog/'+blogId,$scope.blog)
		.then(fetchAllBlogs(),function(response)
				{
			
			        console.log('Status Text:'+response.statusText);
			        $route.reload()			   
			        $location.path("/listBlogs");
			      
				});
	};
	$scope.approveBlog=function(blogId)
	{
		console.log('Enter into the approve blog method');
		console.log(blogId);
		$http.put('http://localhost:8081/ChatMidWare/approve/'+blogId)
		.then(function(response)
				{
			
			        console.log('Status Text:'+response.statusText);
			        $route.reload();
					  $location.path('/listBlogs');
			   
			      
				});
	};
	$scope.rejectBlog=function(blogId)
	{
		console.log('Enter into the reject blog method');
		console.log(blogId);
		$http.put('http://localhost:8081/ChatMidWare/rejectBlog/'+blogId)
		.then(function(response)
				{
			
			        console.log('Status Text:'+response.statusText);
			        $route.reload();
					  $location.path('/listBlogs');
			   
			      
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
	$scope.listblogComments = function(blogId){

		$http.get('http://localhost:8081/ChatMidWare/listBlogComments/'+blogId)
		.then(function(response){
			console.log('In edit blog');
			console.log(blogId);
			$scope.blogcommentData = response.data;			
			//$location.path('/changeBlog');
		});
	};
	$scope.deleteBlogComment = function(commentId){
		//alert("in delete blog");
		$http.delete('http://localhost:8081/ChatMidWare/deleteBlogComment/'+commentId)
		.then(fetchAllBlogs(), function(response){
			
		    console.log('Response Status ' + response.statusText);
		    $route.reload();
			
			
		});
	};
	
	
	
	
	$scope.insertblogComment = function(blogId) {
		alert("In insert blog comment ");
		
		$http.post('http://localhost:8081/ChatMidWare/addBlogComment/'+blogId,
				$scope.blogcomment).then( function(response) {
					console.log('Status Text ' + response.statusText);
					$route.reload();					
					$location.path('/listBlogs');
			
		});
	};
	
	/*function fetchAllBlogComments(blogId) {
		console.log('In coomment method');
		$http.get('http://localhost:8081/ChatMidWare/listBlogComments/{blogid}').then(
				function(response) {
					//console.log('Status Text ' + response.statusText);
					$scope.blogcommentData = response.data;
				});
	};*/
	
	
	fetchAllBlogs();
});