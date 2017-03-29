
	 define(['angular', './sample-module'], function (angular, controllers) {
		    'use strict';

		    controllers.config(function($sceDelegateProvider) {
		    	$sceDelegateProvider.resourceUrlWhitelist(['**']);  
		    });
		    
		
		    controllers.controller('RoleController', ['$scope', '$http', function($scope,$http) {
		    	
		    	
		    	console.log("Hello..........");
		    	
		    	$scope.newRole = {};
		    	$scope.chkbox="";		    	
		    	$scope.deleteList = [];
		    	$scope.roleAdded=false;
		    	$scope.roleUpdated=false;
		    	
		    	/**********************ADD*****************************/
		    	
		    	$scope.openAddRole = function(){
		    	console.log("openAddRole -- modalButtonClicked");
		    	Polymer.dom(document).querySelector("#addRole").modalButtonClicked();
		    	};
		    	var add = document.getElementById("addRole");
		    	if(add!=null){
		    		add.addEventListener("btnModalPositiveClicked", function(e) {
		    	console.log(" ----addRole clicked------->> ");
		    	if($scope.roleAdded==false)
		    	$scope.roleAdded=true;

		    	$scope.AddRole();
		    	});
		    	}
		    	
		    	$scope.AddRole = function() { 

		    		console.log("AddRole ---- ");		    		
		    		if($scope.roleAdded == false)
		    		return;
		    		 
		    		$scope.roleName = document.getElementById("rname").value;
		    		$scope.roleDescription = document.getElementById("rdescription").value;
		    		
		    		
		    		if($scope.roleName==undefined || $scope.roleDescription == undefined)
		    		return;
		    	
		    		$http({
		    			method  : 'POST',
		    			url     : 'http://localhost:8081/pmms-api/SaveRole',
		    			data    :  {
		    			"roleName": $scope.roleName,
		    			"roleDescription":$scope.roleDescription
		    			
		    			}
		    			}).success(function(status, statusCode, headers, config) {
		    			if (statusCode == 200 || status.status == true) {
		    				console.log("added successfully ");	
		    				/* alert("Added Successfully"); */
		    			$scope.success = true;

		    			document.querySelector('role-elem').refreshData(); 
		    			} else {
		    				console.log("added unsuccessfully ");	
		    				/* alert("Try Again!!!!!") */
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
		    	
		    	/*********************************EDIT***************************************/
		    		
				console.log("********editing************");
				
				var edit = document.getElementById("editrole");
				if(edit!=null){
					edit.addEventListener("btnModalPositiveClicked", function(e) {
						console.log(" ----editModal clicked------->> ");
						if($scope.roleUpdated==false)
							$scope.roleUpdated=true;
					
						$scope.EditRole();
						});
				}
				
				$scope.EditRole = function(){
					console.log("editRole ---- ");
					if($scope.roleUpdated == false)
						return;
					
					$scope.roleId=document.getElementById("rid").value;
		    		$scope.roleName=document.getElementById("rolename").value;
		    		$scope.roleDescription=document.getElementById("roeldescription").value;
		    			
		    		console.log(" rolename: "+$scope.roleName +"  roeldescription: "+$scope.roleDescription);
		    		if($scope.roleName==undefined || $scope.roleDescription == undefined)
		    			return;
		    		
					$http({
						method  : 'POST',
						url     : 'http://localhost:8081/pmms-api/SaveRole',
						data    :  {
						"id": $scope.roleId,
						"roleName": $scope.roleName,
						"roleDescription":$scope.roleDescription						
						 }
						
						}).success(function(status, statusCode, headers, config) {
						if (statusCode == 200 || status.status == true) {
						$scope.success = true;
						document.querySelector('role-elem').refreshData(); 
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
				
				/************************************DELETE**************************************/
				
					console.log("Roleeeee..........");	
				var deleteRole = document.getElementById("removeRole");
				if(deleteRole!=null){
					deleteRole.addEventListener("px-row-click", function(e) {
				console.log(" ----------->> "+document.getElementById("removeRole"));
				$scope.clickedRow = e.detail.row;
				  console.log("Row clicked", $scope.clickedRow, " _selected: ", $scope.clickedRow._selected);
				  var index = $scope.deleteList.indexOf(($scope.clickedRow.row.id.value));
				  
				  if($scope.clickedRow._selected==false && index == -1)
				  $scope.deleteList.push($scope.clickedRow.row.id.value);
				  else if(index > -1)
				  $scope.deleteList.splice(index,1); 
					});

				}
				$scope.deleteRole=function(){
					console.log("$scope.deleteList : "+$scope.deleteList);
					if ($scope.deleteList.length == 0) {
						return;
					}
					$http({
						method  : 'POST',
						url     : 'http://localhost:8081/pmms-api/deleteRole',
						data    :  $scope.deleteList
						
						}).success(function(status, statusCode, headers, config) {
						if (statusCode == 200 || status.status == true) {
							alert("Deleted successfully!!!");
						$scope.success = true;
						document.querySelector('role-elem').refreshData(); 						
						$scope.deleteList = [];
						} else {
							alert("Try Again!!!!!")
						$scope.success = false;
						}
						})
						.error(function(data, status, headers, config) {
						$scope.success = false;
						})
						.finally(function() {
						$scope.finished = true;
						// close the add modal after save
						// document.getElementById("addModal").hidden=true;
						
						});
				};
			
			
		    	/*	
		    	$scope.roleId=1;
		    	       $scope.roleModuleAccess=[];
		    	       $scope.roleModuleAccessJSON={};
		    	        $scope.callUserAccessDtlsPerRole = function(){
		    	             console.log("inside callUserAccessDtlsPerRole");
		    	             $http({
		    	                     method  : 'GET',
		    	                     url     : 'http://localhost:8081/pmms-api/getRoleModuleAccess?roleId='+$scope.roleId,
		    	                     
		    	                     }).success(function(data, statusCode, headers, config) {
		    	                     if (statusCode == 200 || status.status == true) {
		    	                     $scope.success = true;
		    	                     $scope.roleModuleAccess =data;
		    	                     
		    	                     console.log("$scope.roleModuleAccess  : "+$scope.roleModuleAccess + $scope.roleModuleAccess.length);
		    	                if($scope.roleModuleAccess.length >0){
		    	                     var prevModuleName = "";
		    	                     var moduleName = "";
		    	                     var submoduleName = "";
		    	                     var operation = "";
		    	                     var jsonString = "{";
		    	                            for(var i=0; i<$scope.roleModuleAccess.length;i++)
		    	                            {
		    	                                   var module = $scope.roleModuleAccess[i];
		    	                                   console.log("module : "+module );
		    	                                   moduleName = module.moduleName;
		    	                                   submoduleName = module.submoduleName;
		    	                                   operation = module.operation;
		    	                                   if(moduleName != prevModuleName && jsonString=="{")
		    	                                   {
		    	                                         jsonString = jsonString +"\""+moduleName+"\"" + ":";
		    	                                         jsonString = jsonString + "{" + "\""+submoduleName+"\"" + ":";
		    	                                         jsonString = jsonString + "{" +"\""+ "operation"+"\"" + " :{["+"\""+operation+"\""+",";
		    	                                    
		    	                                   }else if(moduleName != prevModuleName && jsonString!="{")
		    	                                   {
		    	                                         jsonString = jsonString + ",{"
		    	                                         jsonString = jsonString + "\""+moduleName+"\"" + ":";
		    	                                         jsonString = jsonString + " { "  +"\""+submoduleName+"\"" + ":";
		    	                                         jsonString = jsonString + " { " + "\""+"operation"+"\"" + " :{["+"\""+operation+"\""+",";
		    	                                         
		    	                                   }
		    	                                   else
		    	                                   {
		    	                                         if(jsonString.indexOf(submoduleName)<0){
		    	                                                console.log("module already exists, new submodule case");
		    	                                                jsonString = jsonString.substring(0,jsonString.indexOf(","));
		    	                                                jsonString  =jsonString  + "] }},"; 
		    	                                                jsonString = jsonString + "\""+submoduleName+"\"" + ":";
		    	                                                jsonString = jsonString + " { " +"\""+ "operation" +"\""+ " : {["+"\""+operation+"\""+",";
		    	                                         }
		    	                                         else {
		    	                                                console.log("module and submodule already exists just add operation only");
		    	                                                jsonString = jsonString + "\""+operation+"\""+",";
		    	                                         }
		    	                                                
		    	                                   }
		    	                                   prevModuleName = module.moduleName;
		    	                            }
		    	                            jsonString = jsonString.substring(0,jsonString.length-1);
		    	                            
		    	                            jsonString = jsonString + "] }} } }";
		    	                 }
		    	                console.log(jsonString);
		    	                var test = JSON.stringify(jsonString);
		    	                $scope.roleModuleAccessJSON = JSON.parse(test);
		    	                
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
		    	      
		    	       $scope.callUserAccessDtlsPerRole($scope.roleId);
		           };*/
		    }]);
		});		   
