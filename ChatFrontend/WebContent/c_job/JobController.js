myApp.controller("JobController",function($scope,$http,$location,$route)
{
	$scope.job={"company":'',"jobDescription":'',"jobTitle":'',"finalDate":'',"location":'',"salary":''}
	$scope.applyjob={"applicationId":'',"applyDate":'',"jobId":'',"userName":''}	
	
	$scope.jobdata;
	$scope.applydata;
	$scope.boolvalue;
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
	$scope.applyJob=function(jobId)
	{
		console.log("Enter into applyjob Method");
		console.log($scope.applyjob);
		$http.post('http://localhost:8081/ChatMidWare/applyJob/'+jobId,$scope.applyjob)
		.then(fetchAllApplications(),function(response)
     	{
			//console.log('Status Text:'+response.statusText);
			//$scope.msg="Data inserted sucessfully";
			//$route.reload();
		
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
	$scope.checkApplication=function(jobId)
	{
		console.log('Enter into the check job method');
		$http.get('http://localhost:8081/ChatMidWare/checkApplication/'+jobId)
		.then(function(response)
				{
			       var value=response.data;
			       if(value=='FAIL')
			    	   return false;
			       else 
			    	   return true;
			       
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

	function fetchAllApplications()
	{
		console.log('Fetching All Jobs');
		$http.get("http://localhost:8081/ChatMidWare/listApplyJobs")
		.then(function(response)
				{
			            $scope.applydata=response.data;
				});
	}
	
	fetchAllApplications();
	
	fetchAllJob();
	
});