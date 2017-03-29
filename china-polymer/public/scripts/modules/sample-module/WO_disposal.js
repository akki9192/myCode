define(['angular', './sample-module'], function (angular, controllers) {
		    'use strict';

		    controllers.config(function($sceDelegateProvider) {
		    	$sceDelegateProvider.resourceUrlWhitelist(['**']);  
		    });
		    
		
		    controllers.controller('WO_DisposalController', ['$scope', '$http', function($scope,$http) {
		    	
		    	$scope.entryUpdated=false;
		    	
		    		console.log("********editing************");
				
				var edit = document.getElementById("editEntry");
				if(edit!=null){
					edit.addEventListener("btnModalPositiveClicked", function(e) {
						console.log(" ----editModal clicked------->> ");
						if($scope.entryUpdated==false)
							$scope.entryUpdated=true;
					
						$scope.entryEdit();
						});
				}
				
				$scope.entryEdit = function(){
					console.log("editRole ---- ");
					if($scope.entryUpdated == false)
						return;
					
					$scope.sso=document.getElementById("sso").value;
		    		$scope.comments=document.getElementById("comments").value;
		    		
		    			
		    		console.log(" sso: "+$scope.sso +"  comments: "+$scope.comments);
		    		if($scope.sso==undefined || $scope.comments == undefined)
		    			return;
		    		
					$http({
						method  : 'POST',
						url     : 'http://localhost:8081/pmms-api/getDisposalDetails',
						data    :  {
						"created_by": $scope.sso,
						"wo_status": $scope.comments,					
						 }
						
						}).success(function(status, statusCode, headers, config) {
						if (statusCode == 200 || status.status == true) {
						$scope.success = true;
						document.querySelector('WO-elem').refreshData(); 
						} else {
						$scope.success = false;
						}
						})
						.error(function(data, status, headers, config) {
						$scope.success = false;
						})
						.finally(function() {
						$scope.finished = true;
						});
				};
				
		    }