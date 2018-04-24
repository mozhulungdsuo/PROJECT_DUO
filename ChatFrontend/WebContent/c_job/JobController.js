myApp.controller("JobController",function($scope,$http,$location,$route)
{
	$scope.job={"company":'',"jobDescription":'',"jobTitle":'',"finalDate":'',"location":'',"salary":''}
		
	
	$scope.jobdata;
	
	$scope.insertJob=function()
	{
		console.log("Enter into insertjob Method");
		console.log($scope.job);
		$http.post('http://localhost:8081/ChatMidWare/addJob',$scope.job)
		.then(fetchAllJob(),function(response)
     	{
			console.log('Status Text:'+response.statusText);
			$scope.msg="Data inserted sucessfully";
			$route.reload();
		
	     });			
	};
	
	
	
	$scope.deleteJob=function(jobId)
	{
		console.log('Enter into the delete job method');
		$http.delete('http://localhost:8081/ChatMidWare/deletejob/'+jobId)
		.then(fetchAllJob(),function(response)
				{
			        console.log('Deleted');
			        $route.reload();
			        $location.path("/displayJob");
				});
	};
	
	
	
	
	
	
	
	function fetchAllJob()
	{
		console.log('Fetching All Jobs');
		$http.get("http://localhost:8081/ChatMidWare/listJobs")
		.then(function(response)
				{
			            $scope.jobdata=response.data;
				});
	}
	
	
	
	
	fetchAllJob();
	
});