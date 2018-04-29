myApp.controller("BlogCommentController", function($scope, $http, $location,$route) {
	console.log("In comment controoler");

$scope.blogcomment={
			"commentDate":'',
			"blogId":'',
			"username":'',
			"commentText":''
					
	}
	$scope.blogcommentData;



function fetchBlogComments() {
	console.log('In fetchAllBlogs method');
	$http.get('http://localhost:8081/ChatMidWare/listBlogs').then(
			function(response) {
				//console.log('Status Text ' + response.statusText);
				$scope.blogData = response.data;
			});
};


fetchAllBlogs();
});