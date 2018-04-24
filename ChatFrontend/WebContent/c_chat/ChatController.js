myApp.controller("ChatController", function($scope,$rootScope,chatService)
{
    $scope.messages=[];
    $scope.message="";
    $scope.max=140;
    
    $scope.addMessage=function()
    {  
    	console.log("in messaging ");
    	
        chatService.send($rootScope.currentUser.userName+":" +$scope.message);
        $scope.message="";
    };
    chatService.receive().then(null,null,function(message)
    {
        $scope.messages.push(message);
    }); 
});