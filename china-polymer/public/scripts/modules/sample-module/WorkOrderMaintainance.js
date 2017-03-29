define(['angular', './sample-module'], function (angular, controllers) {
		    'use strict';

		    controllers.config(function($sceDelegateProvider) {
		    	$sceDelegateProvider.resourceUrlWhitelist(['**']);  
		    });
		    
		    controllers.controller('maintainanceController', ['$scope', '$http', function($scope,$http) {
		    	
		    	
		    	//COnditional Close Functionality 
				/*$scope.condClose = function() {					
					
					console.log("COnd1");
					$scope.fault={
							faultid:document.getElementById("editid").value,
							  workorderid:document.getElementById("workOrderNumber").value,
							  workordrtype:document.getElementById("workordrtype").value,
							  maintType:document.getElementById("maintType").value,
							  equipid:document.getElementById("editEquipid").value,						  
							  shutdown:document.getElementById("shutdownFlag").value,
							  safetyinvolved:document.getElementById("safetyInvolved").value,
							  faultdesc:document.getElementById("faultDescription").value,
							  planid:document.getElementById("planId").value,
							  planstartmonth:document.getElementById("planStartMonth").value,
							  smsflag:document.getElementById("smsFlag").value,
							  creatersso:document.getElementById("editCreaterSso").value,
							  createddate:document.getElementById("createdDate").value,
							  updatersso:document.getElementById("editUpdaterSso").value,
							  updateddate:document.getElementById("lastUpdatedDate").value,
							  widsequence:document.getElementById("widsequence").value,
							  faulttype:document.getElementById("faulttype").value,
							  sparepartinvolded:document.getElementById("sparePartInvolved").checked,
							  externalservice:document.getElementById("externalServiceInvolved").checked,
							  remark:document.getElementById("remarks").value
							  
						
							 
					  }
						
						$http({
							method  : 'POST',
							url     : 'http://localhost:8081/pmms-api/edit',
							data    :  {
								 "id": $scope.fault.faultid,
								 "workOrderNumber": $scope.fault.workorderid,
								 "workOrderType":$scope.fault.workordrtype,
								 "maintType":$scope.fault.maintType,
								 "wordOrderStatus":'2',
								 "equipId2":$scope.fault.equipid,
								 "shutdownFlag": $scope.fault.shutdown,
								 "safetyInvolved": $scope.fault.safetyinvolved,
								 
								 "faultDescription": $scope.fault.faultdesc,
								 "planId": $scope.fault.planid,
								 "planStartMonth": $scope.fault.planstartmonth,
								 "smsFlag": $scope.fault.smsflag,
								
								 "creatorSSO": $scope.fault.creatersso,
								 "createdDate": $scope.fault.createddate,
								 "updaterSSO": $scope.fault.updatersso,
								 "lastUpdatedDate": $scope.fault.updateddate,
								 "widsequence": $scope.fault.widsequence,
								 "woMaintId":'101',
								 "workOrderNumber":$scope.fault.workorderid,
								 "mechanic": $scope.fault.updatersso,
								 "faultType":$scope.fault.faulttype,
								 "sparePartInvolved":$scope.fault.sparepartinvolded,
								 "externalServiceInvolved":$scope.fault.externalservice,
									"createdBy":$scope.fault.createddate,
									"createdDates":$scope.fault.createddate,
									"lastUpdatedBy":$scope.fault.updatersso,
									"lastUpdatedDates":$scope.fault.updateddate,
									"remarks":$scope.fault.remark
								 
								 
								 
								 "woId":$scope.workOrder.woid,
								 "mechanic":$scope.workOrder.mechanic,
						          "faultType":$scope.workOrder.faulttype,
						"sparePartInvolved":$scope.workOrder.sparepartinvolded,
						"externalServiceInvolved":$scope.workOrder.externalservice,
						"maintStartDate":$scope.workOrder.mainstartdate,
						"maintEndDate":$scope.workOrder.mainenddate,
						"remark":$scope.workOrder.remark,
						"createdBy":$scope.workOrder.createdby,
						"createdDate":$scope.workOrder.createddate,
						"lastUpdatedBy":$scope.workOrder.updatedby,
						"lastUpdatedDate":$scope.workOrder.updateddate
						        
								
								
								
								
								
								
							  }
							}).success(function(status, statusCode, headers, config) {
								if (status.status == true) {
									$scope.success = true;								
									} 
								
								
								else {
									$scope.success = false;
									}
									})
									.error(function(data, status, headers, config) {
									$scope.success = false;
									})
									.finally(function() {
									$scope.finished = true;
									});

					};*/
					
		    	
		    	var dataTable4 = document.getElementById("dataTable4");
		        if(dataTable4!=null){
		        	dataTable4.addEventListener("px-row-click", function(e) {
		        					$scope.clickedRow = e.detail.row;
		      						$scope.maintId=$scope.clickedRow.row["maintId"].value
		      						$scope.equipmentId=$scope.clickedRow.row["equipId"].value
		      						$scope.id=$scope.clickedRow.row["id"].value
		      						
		      						/*if (!$scope.clickedRow._selected) {
		      						$http({
										method  : 'GET',
										url     : 'http://localhost:8081/pmms-api/getMaintainanceinfoDtls?maintId='+$scope.maintId,
										
										}).success(function(status, statusCode, headers, config) {
											if (status.status == true) {
												$scope.success = true;
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
		      						
		      						}*/
									 // scanValue:$scope.clickedRow.row["扫描值/ScanValue"].value
							 
		                      //if(check for existing maintanance and see if it already exist then ignore else push)
		                     // $scope.maintainanceArr.push(maintainance);
		                      
		                      });

		        }
		        
					//Start Button Functionality 
					$scope.startTask = function() {					
						
						
						
							
							$http({
								method  : 'POST',
								url     : 'http://localhost:8081/pmms-api/StartMaintainance',
								cache: false,
								data    :  {
									"sso":$scope.SSO,
									 "maintId": $scope.maintId,
									 "equipId":$scope.equipmentId,
									 "maintType":'MC',
									 /*"scanValue":$scope.maintainance.scanValue,*/
									 "status":'进行中'
								}		
								}).success(function(status, statusCode, headers, config) {
									if (status.status == true) {
										$scope.success = true;
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
						
		
						
						//close() button Functionality 
						$scope.closeTask = function() {					
							var datatableObj = document.getElementById("resultPxDataTable4");
							
							/*var maintainanceMap= new Object();
							var length=datatableObj.__data__.tableData.length;
							
									for(var i=0;i< length;i++)
										{
									 var maintId=datatableObj.__data__.tableData[i]['maintId'];
									
									var scanValue=datatableObj.__data__.tableData[i]['scanValue'];
									var spendTime=datatableObj.__data__.tableData[i]['spendTime'];
									maintainanceMap[maintId]=[spendTime,scanValue];
										}*/
							
							var length=datatableObj.__data__.tableData.length;
							$scope.maintArr=[];
							
							for(var i=0;i< length;i++)
								{
								 var maintainanceArr=[
								                        	$scope.maintItemId=datatableObj.__data__.tableData[i]['maintItemId'],
								                        	$scope.scanValue=datatableObj.__data__.tableData[i]['scanValue'],
								                        	$scope.spendTime=datatableObj.__data__.tableData[i]['spendTime'],
								                        	$scope.maintId=datatableObj.__data__.tableData[i]['maintId'],
								                        	$scope.id=datatableObj.__data__.tableData[i]['id'],
								                        	$scope.createdDt=datatableObj.__data__.tableData[i]['createdDt']
								                        	
														];
								$scope.maintArr.push(maintainanceArr);
								}
									 
									
								
								$http({
									method  : 'POST',
									url     : 'http://localhost:8081/pmms-api/CloseMaintainanceTask',
									data    :  {
													"sso":$scope.SSO,
													"maintId":$scope.maintId,
													"maintItemId": $scope.maintItemId,
													"equipId":$scope.equipmentId,
													"id":$scope.id,
													"maintainanceArr":$scope.maintArr,
													"status":'关闭',
													"maintType":'MC'
										}
									}).success(function(status, statusCode, headers, config) {
										if (status.status == true) {
											$scope.success = true;
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
							
							
							// save Button Functionality 
							
							$scope.saveTask = function() {					
								var datatableObj = document.getElementById("resultPxDataTable4");
								
								var length=datatableObj.__data__.tableData.length;
								$scope.maintArr=[];
								
								for(var i=0;i< length;i++)
									{
									 var maintainanceArr=[
									                        	$scope.maintItemId=datatableObj.__data__.tableData[i]['maintItemId'],
									                        	$scope.scanValue=datatableObj.__data__.tableData[i]['scanValue'],
									                        	$scope.spendTime=datatableObj.__data__.tableData[i]['spendTime'],
									                        	$scope.maintId=datatableObj.__data__.tableData[i]['maintId'],
									                        	$scope.id=datatableObj.__data__.tableData[i]['id'],
									                        	$scope.createdDt=datatableObj.__data__.tableData[i]['createdDt']
									                        	
															];
									$scope.maintArr.push(maintainanceArr);
									}
										 
										
									
									$http({
										method  : 'POST',
										url     : 'http://localhost:8081/pmms-api/CloseMaintainanceTask',
										data    :  {
														"sso":$scope.SSO,
														"maintId":$scope.maintId,
														"maintItemId": $scope.maintItemId,
														"equipId":$scope.equipmentId,
														"id":$scope.id,
														"maintainanceArr":$scope.maintArr,
														"status":'进行中',
														"maintType":'MC'
											}
										}).success(function(status, statusCode, headers, config) {
											if (status.status == true) {
												$scope.success = true;
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