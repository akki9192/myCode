define(['angular', './sample-module'], function (angular, controllers) {
		    'use strict';

		    controllers.config(function($sceDelegateProvider) {
		    	$sceDelegateProvider.resourceUrlWhitelist(['**']);  
		    });
		    
		    controllers.controller('editFaultController', ['$scope', '$http', function($scope,$http) {	    
		    
		    	
                
                var workordertable = document.getElementById("workordertable");
                 if(workordertable!=null){
                	 workordertable.addEventListener("px-row-click", function(e) {
                		 
                               $scope.clickedRow = e.detail.row;                            
                                      $scope.id=$scope.clickedRow.row["id"].value
                                                  $scope.workOrderType=$scope.clickedRow.row.faultReport.value.workOrderType
                                                  $scope.workOrderNumber=$scope.clickedRow.row["workOrderNumber"].value                                                 
                                                  $scope.maintType=$scope.clickedRow.row.faultReport.value.maintType
                                                  $scope.planId=$scope.clickedRow.row.faultReport.value.planId
                                                  $scope.planStartMonth=$scope.clickedRow.row.faultReport.value.planStartMonth
                                                  $scope.smsFlag=$scope.clickedRow.row.faultReport.value.smsFlag
                                                  $scope.widsequence=$scope.clickedRow.row.faultReport.value.widsequence
                                                  $scope.createdDate=$scope.clickedRow.row.faultReport.value.createdDate
                                                  $scope.lastUpdatedDate=$scope.clickedRow.row.faultReport.value.lastUpdatedDate                                             
                                                  $scope.faultDescription=$scope.clickedRow.row.faultReport.value.faultDescription                                             
                                                  $scope.createdDate=$scope.clickedRow.row.faultReport.value.createdDate
                                                  $scope.safetyInvolved=$scope.clickedRow.row.faultReport.value.safetyInvolved
                                                  $scope.shutdownFlag=$scope.clickedRow.row.faultReport.value.shutdownFlag   
                                                  $scope.equipNameId=$scope.clickedRow.row.faultReport.value.equipmentInfo.equipNameInfo.equipNameId
                                                  
                                                 //$scope.maintStartDate=$scope.clickedRow.row.latestWorkOrderMaintainance.value.maintStartDate

                               
                               });

                 }
              
	    	
		    	// COnditional Close Functionality
				$scope.condClose = function() {					
					
					if($scope.workOrderNumber == null)
					{
						alert("Please select a Work Order and then use the feature of Start, Close, Pause/resume, Conditional close, Confirm");
						return;
					}
					$scope.fault={
							
							  equipid:document.getElementById("editEquipid").value,						  						
							  creatersso:document.getElementById("editCreaterSso").value,						
							  updatersso:document.getElementById("editUpdaterSso").value,							
							  faulttype:document.getElementById("faulttype").value,
							  sparepartinvolded:document.getElementById("sparePartInvolved").checked,
							  externalservice:document.getElementById("externalServiceInvolved").checked,
							  remark:document.getElementById("remarks").value
							 
					  }
						
						$http({
							method  : 'POST',
							url     : 'http://localhost:8081/pmms-api/updateAndInsertFaultRepair',
							data    :  {
								 "id": $scope.id,
								 "workOrderNumber": $scope.workOrderNumber,
								 "workOrderType":$scope.workOrderType,
								 "maintType":$scope.maintType,
								 "wordOrderStatus":'带遗留问题运行',
								 "equipId2":$scope.fault.equipid,
								 "shutdownFlag": $scope.shutdownFlag,
								 "safetyInvolved": $scope.safetyInvolved,							 
								 "faultDescription": $scope.faultDescription,
								 "planId": $scope.planId,
								 "planStartMonth": $scope.planStartMonth,
								 "smsFlag": $scope.smsFlag,
								 "creatorSSO": $scope.fault.creatersso,
								 "createdDate": $scope.createdDate,
								 "updaterSSO": $scope.fault.updatersso,
								 "lastUpdatedDate": $scope.lastUpdatedDate,
								 "widsequence": $scope.widsequence,
								 "woMaintId":'101',
								 "workOrderNumber":$scope.workOrderNumber,
								 "mechanic": $scope.fault.updatersso,
								 "faultType":$scope.fault.faulttype,
								 "sparePartInvolved":$scope.fault.sparepartinvolded,
								 "externalServiceInvolved":$scope.fault.externalservice,
								"createdBy":$scope.fault.creatersso,
								"createdDates":$scope.createdDate,
									"lastUpdatedBy":$scope.fault.updatersso,
									"lastUpdatedDates":$scope.lastUpdatedDate,
									"remarks":$scope.fault.remark
								 
							  }
							}).success(function(status, statusCode, headers, config) {
								if (status.status == true)
									{
										$scope.success = true;										
										document.querySelector('fault-repair').refreshData();
										document.querySelector('fault-report').refreshData();

										alert("WorkOrder has been conditionally closed.");
									} 
								else
									{
										$scope.success = false;
										alert("There is an issue during conditionally closing the Work Order.");
									}
							}).error(function(data, status, headers, config) {
								$scope.success = false;
								alert("There is an issue during conditionally closing the Work Order.");
							}).finally(function() {
								$scope.finished = true;
							});
					};
					
					// Start Button Functionality
					$scope.startMaintainance = function() {					
						if($scope.workOrderNumber == null)
						{
							alert("Please select a Work Order and then use the feature of Start, Close, Pause/resume, Conditional close, Confirm");
							return;
						}
						
						$scope.fault={
							
								  equipid:document.getElementById("editEquipid").value,						  						
								  creatersso:document.getElementById("editCreaterSso").value,						
								  updatersso:document.getElementById("editUpdaterSso").value,							
								  faulttype:document.getElementById("faulttype").value,
								  sparepartinvolded:document.getElementById("sparePartInvolved").checked,
								  externalservice:document.getElementById("externalServiceInvolved").checked,
								  remark:document.getElementById("remarks").value
								  
						  }
							
						/*$http({
							method  : 'POST',
							url     : 'http://localhost:8081/pmms-api/validateMantainTechSSO',
							data    :  { updaterSSO: $scope.fault.creatersso}
						
							}).error(function (status, statusCode, headers, config) {
								alert("Your operation failed");
							}).success(function(status, statusCode, headers, config) {
								if(status.data == "FAIL")
									{
										alert("Closer SSO does not exist");
										return;
									}
								else if(status.data == "SUCCESS")
									{*/
											$http({
												method  : 'POST',
												url     : 'http://localhost:8081/pmms-api/updateAndInsertFaultRepair',
												data    :  {
													 "id": $scope.id,
													 "workOrderNumber": $scope.workOrderNumber,
													 "workOrderType":$scope.workOrderType,
													 "maintType":$scope.maintType,
													 "wordOrderStatus":'进行中',
													 "equipId2":$scope.fault.equipid,
													 "shutdownFlag": $scope.shutdownFlag,
													 "safetyInvolved": $scope.safetyInvolved,							 
													 "faultDescription": $scope.faultDescription,
													 "planId": $scope.planId,
													 "planStartMonth": $scope.planStartMonth,
													 "smsFlag": $scope.smsFlag,
													 "creatorSSO": $scope.fault.creatersso,
													 "createdDate": $scope.createdDate,
													 "updaterSSO": $scope.fault.updatersso,
													 "lastUpdatedDate": $scope.lastUpdatedDate,
													 "widsequence": $scope.widsequence,
													 "woMaintId":'101',
													 "mechanic": $scope.fault.updatersso,
													 "faultType":$scope.fault.faulttype,
													 "sparePartInvolved":$scope.fault.sparepartinvolded,
													 "externalServiceInvolved":$scope.fault.externalservice,
													"createdBy":$scope.fault.creatersso,
													"createdDates":$scope.createdDate,
														"lastUpdatedBy":$scope.fault.updatersso,
														"lastUpdatedDates":$scope.lastUpdatedDate,
														"remarks":$scope.fault.remark
													 
													
													
													
												  }
													
												}).success(function(status, statusCode, headers, config) {
													if (status.status == true) {
															$scope.success = true;		
															document.querySelector('fault-repair').refreshData();
															document.querySelector('fault-report').refreshData();
															alert("Work Order has been Started.");
														}
													else 
														{
															$scope.success = false;
															alert("There is an issue during Starting the Work Order.");
														}
												}).error(function(data, status, headers, config){
													$scope.success = false;
													alert("There is an issue during Starting the Work Order.");
												}).finally(function() {
													$scope.finished = true;
												});
									
										
		
										/*};*/
									/*});*/
							};
										
							
						
						
						// close() button Functionality
						$scope.closeMaintainance = function() {	
							
							if($scope.workOrderNumber == null)
							{
								alert("Please select a workorder and then use the feature of Start, Close, Pause/resume, Conditional close, Confirm");
								return;
							}
							
							$scope.fault={
									  equipid:document.getElementById("editEquipid").value,						  						
									  creatersso:document.getElementById("editCreaterSso").value,						
									  updatersso:document.getElementById("editUpdaterSso").value,							
									  faulttype:document.getElementById("faulttype").value,
									  sparepartinvolded:document.getElementById("sparePartInvolved").checked,
									  externalservice:document.getElementById("externalServiceInvolved").checked,
									  remark:document.getElementById("remarks").value
									 
									 
							  }
							$http({
								method  : 'POST',
								url     : 'http://localhost:8081/pmms-api/validateMantainTechSSO',
								data    :  { updaterSSO: $scope.fault.creatersso}
							
								}).error(function (status, statusCode, headers, config) {
									alert("Your operation failed");
								}).success(function(status, statusCode, headers, config) {
									if(status.data == "FAIL")
										{
											alert("Closer SSO does not exist");
											return;
										}
									else if(status.data == "SUCCESS")
										{
							
								
								$http({
									method  : 'POST',
									url     : 'http://localhost:8081/pmms-api/updateAndInsertFaultRepair',
									data    :  {
										 "id": $scope.id,
										 "workOrderNumber": $scope.workOrderNumber,
										 "workOrderType":$scope.workOrderType,
										 "maintType":$scope.maintType,
										 "wordOrderStatus":'关闭',
										 "equipId2":$scope.fault.equipid,
										 "shutdownFlag": $scope.shutdownFlag,
										 "safetyInvolved": $scope.safetyInvolved,							 
										 "faultDescription": $scope.faultDescription,
										 "planId": $scope.planId,
										 "planStartMonth": $scope.planStartMonth,
										 "smsFlag": $scope.smsFlag,
										 "creatorSSO": $scope.fault.creatersso,
										 "createdDate": $scope.createdDate,
										 "updaterSSO": $scope.fault.updatersso,
										 "lastUpdatedDate": $scope.lastUpdatedDate,
										 "widsequence": $scope.widsequence,
										 "woMaintId":'101',
										 "workOrderNumber":$scope.workOrderNumber,
										 "mechanic": $scope.fault.updatersso,
										 "faultType":$scope.fault.faulttype,
										 "sparePartInvolved":$scope.fault.sparepartinvolded,
										 "externalServiceInvolved":$scope.fault.externalservice,
										"createdBy":$scope.fault.creatersso,
										"createdDates":$scope.createdDate,
											"lastUpdatedBy":$scope.fault.updatersso,
											"lastUpdatedDates":$scope.lastUpdatedDate,
											"remarks":$scope.fault.remark
										
									 }
								
								}).success(function(status, statusCode, headers, config) {
										if (status.status == true) {
											$scope.success = true;
											document.querySelector('fault-repair').refreshData();
											document.querySelector('fault-report').refreshData();
											alert("WorkOrder has been closed.");
											} else {
											$scope.success = false;
											alert("There is an issue during closing the Work Order.");
											}
											})
											.error(function(data, status, headers, config) {
											$scope.success = false;
											alert("There is an issue during closing the Work Order.");
											})
											.finally(function() {
											$scope.finished = true;
											});
							

							};
						});

				};
							
							// Outage Button Functionality
							
							$scope.outageMaintainance = function() {					
								
								if($scope.workOrderNumber == null)
								{
									alert("Please select a Work Order and then use the feature of Start, Close, Pause/resume, Conditional close, Confirm");
									return;
								}
								
								$scope.fault={
										  equipid:document.getElementById("editEquipid").value,						  						
										  creatersso:document.getElementById("editCreaterSso").value,						
										  updatersso:document.getElementById("editUpdaterSso").value,							
										  faulttype:document.getElementById("faulttype").value,
										  sparepartinvolded:document.getElementById("sparePartInvolved").checked,
										  externalservice:document.getElementById("externalServiceInvolved").checked,
										  remark:document.getElementById("remarks").value,
										  status: document.getElementById("workOrderStatusId").value
										 
								  }
								
								if($scope.fault.status == "暂停")
									{
										$scope.changeStatus = {
											  woStatus: "进行中"						  						
									  }
									}
								else{
									$scope.changeStatus = {
											  woStatus: "暂停"						  						
									  }
									}
								
									$http({
										method  : 'POST',
										url     : 'http://localhost:8081/pmms-api/updateAndInsertFaultRepair',
										data    :  {
											 "id": $scope.id,
											 "workOrderNumber": $scope.workOrderNumber,
											 "workOrderType":$scope.workOrderType,
											 "maintType":$scope.maintType,
											 "wordOrderStatus":$scope.changeStatus.woStatus,
											 "equipId2":$scope.fault.equipid,
											 "shutdownFlag": $scope.shutdownFlag,
											 "safetyInvolved": $scope.safetyInvolved,							 
											 "faultDescription": $scope.faultDescription,
											 "planId": $scope.planId,
											 "planStartMonth": $scope.planStartMonth,
											 "smsFlag": $scope.smsFlag,
											 "creatorSSO": $scope.fault.creatersso,
											 "createdDate": $scope.createdDate,
											 "updaterSSO": $scope.fault.updatersso,
											 "lastUpdatedDate": $scope.lastUpdatedDate,
											 "widsequence": $scope.widsequence,
											 "woMaintId":'101',
											 "workOrderNumber":$scope.workOrderNumber,
											 "mechanic": $scope.fault.updatersso,
											 "faultType":$scope.fault.faulttype,
											 "sparePartInvolved":$scope.fault.sparepartinvolded,
											 "externalServiceInvolved":$scope.fault.externalservice,
											"createdBy":$scope.fault.creatersso,
											"createdDates":$scope.createdDate,
											"lastUpdatedBy":$scope.fault.updatersso,
											"lastUpdatedDates":$scope.lastUpdatedDate,
											"remarks":$scope.fault.remark
											 					
										  }
									
										}).success(function(status, statusCode, headers, config) {
											if (status.status == true) {
												$scope.success = true;
												document.querySelector('fault-repair').refreshData();
												document.querySelector('fault-report').refreshData();
												
												if($scope.changeStatus.woStatus == "进行中")
													alert("Work Order resumed to In Progress.");
												else
													alert("Work Order has been paused.");
												
												} else {
												$scope.success = false;
												alert("There is an issue during the operation.");
												}
												})
												.error(function(data, status, headers, config) {
												$scope.success = false;
												alert("There is an issue during the operation.");
												})
												.finally(function() {
												$scope.finished = true;
												});
								}
							
                    $scope.confirmed = function() {					
								
                    	if($scope.workOrderNumber == null)
						{
                    		alert("Please select a Work Order and then use the feature of Start, Close, Pause/resume, Conditional close, Confirm");
							return;
						}
								
								$scope.fault={
										  equipid:document.getElementById("editEquipid").value,						  						
										  creatersso:document.getElementById("editCreaterSso").value,						
										  updatersso:document.getElementById("editUpdaterSso").value,							
										  faulttype:document.getElementById("faulttype").value,
										  sparepartinvolded:document.getElementById("sparePartInvolved").checked,
										  externalservice:document.getElementById("externalServiceInvolved").checked,
										  remark:document.getElementById("remarks").value									
										 
								  }
								
									$http({
										method  : 'POST',
										url     : 'http://localhost:8081/pmms-api/updateAndInsertFaultRepair',
										data    :  {
											 "id": $scope.id,
											 "workOrderNumber": $scope.workOrderNumber,
											 "workOrderType":$scope.workOrderType,
											 "maintType":$scope.maintType,
											 "wordOrderStatus":'确认',
											 "equipId2":$scope.fault.equipid,
											 "shutdownFlag": $scope.shutdownFlag,
											 "safetyInvolved": $scope.safetyInvolved,							 
											 "faultDescription": $scope.faultDescription,
											 "planId": $scope.planId,
											 "planStartMonth": $scope.planStartMonth,
											 "smsFlag": $scope.smsFlag,
											 "creatorSSO": $scope.fault.creatersso,
											 "createdDate": $scope.createdDate,
											 "updaterSSO": $scope.fault.updatersso,
											 "lastUpdatedDate": $scope.lastUpdatedDate,
											 "widsequence": $scope.widsequence,
											 "woMaintId":'101',
											 "workOrderNumber":$scope.workOrderNumber,
											 "mechanic": $scope.fault.updatersso,
											 "faultType":$scope.fault.faulttype,
											 "sparePartInvolved":$scope.fault.sparepartinvolded,
											 "externalServiceInvolved":$scope.fault.externalservice,
											"createdBy":$scope.fault.creatersso,
											"createdDates":$scope.createdDate,
												"lastUpdatedBy":$scope.fault.updatersso,
												"lastUpdatedDates":$scope.lastUpdatedDate,
												"remarks":$scope.fault.remark
											 					
										  }
									
										}).success(function(status, statusCode, headers, config) {
											if (status.status == true) {
												$scope.success = true;
												document.querySelector('fault-repair').refreshData();
												document.querySelector('fault-report').refreshData();
												alert("Work Order confirmed.");
												
												} else {
												$scope.success = false;
												alert("There is an issue during the confirmation.");
												}
												})
												.error(function(data, status, headers, config) {
												$scope.success = false;
												alert("There is an issue during the confirmation.");
												})
												.finally(function() {
												$scope.finished = true;
												});
								};
		    }]);
		    
		});
