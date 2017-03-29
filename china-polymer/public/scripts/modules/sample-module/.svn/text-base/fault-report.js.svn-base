define(['angular', './sample-module'], function (angular, controllers) {
		    'use strict';

		    controllers.config(function($sceDelegateProvider) {
		    	$sceDelegateProvider.resourceUrlWhitelist(['**']);  
		    });
		    
		    controllers.controller('addFaultController', ['$scope', '$http', function($scope,$http) {
		
     $scope.addFault = function() {		
    	 $scope.isValidEquipId = false;		
    	 
    		
			$scope.fault={
					/*
					  equipid:document.getElementById("eqsn").value,						  						
					  sso:document.getElementById("sso").value,																
					  faultdesc:document.getElementById("faultdesc").value,
					  safety:document.getElementById("safety").checked,
					  shutdown:document.getElementById("shutdown").checked*/		
					  abc:document.getElementById("abc")	
					 
			  }
					
    	 $http({
						method  : 'GET',
						url     : 'http://localhost:8081/pmms-api/isValidEquipId?equipId='+$scope.eqsn,
						data    :  {
							
							 "equipId":$scope.fault.equipid,							
							
						  }
				
						}).success(function(status, statusCode, headers, config) {
						
							if (status.length>0) {
								$scope.success = true;
								 $scope.isValidEquipId = true;
								 alert("Valid EquipID..You can add now!!! ")
								$scope.addFaultReport();
								
								} else {
								$scope.success = false;
								alert("Enter a valid equipmenet id")
								}
							})
						.error(function(data, status, headers, config) {
						$scope.success = false;
						})
						.finally(function() {
						$scope.finished = true;
						});

				};
				
		    	
				$scope.addFaultReport = function() {		
					
					$http({
						method  : 'POST',
						url     : 'http://localhost:8081/pmms-api/saveFaultReport',
						data    :  {
							 "creatorSSO": $scope.fault.sso,
							 "equipId2":$scope.fault.equipid,							
							 "faultDescription": $scope.fault.faultdesc,
							 "safetyInvolved": $scope.fault.safety,
							 "shutdownFlag": $scope.fault.shutdown
						  }
				
						}).success(function(status, statusCode, headers, config) {
							
							if (statusCode == 200 ||status.status == true) {
								$scope.success = true;
								document.querySelector('fault-report').refreshData();
								document.querySelector('fault-repair').refreshData();
								
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
				
			
				
				
				
		    }]);
		});
