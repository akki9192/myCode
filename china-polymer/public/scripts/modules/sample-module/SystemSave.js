
	 define(['angular', './sample-module'], function (angular, controllers) {
		    'use strict';

		    controllers.config(function($sceDelegateProvider) {
		    	$sceDelegateProvider.resourceUrlWhitelist(['**']);  
		    });

		    controllers.controller('SystemController', ['$scope', '$http', function($scope,$http) {

		    	 var tab1 = new Object();
		    	 var tab2 = new Object();
		    	 var tab3 = new Object();
		    	 var tab4 = new Object();
		    	 var tab5 = new Object();
		    	 var tab6 = new Object();
		    	 var tab7 = new Object();
		    	 var ssoTab1=[];
		    	 var ssoTab2=[];
		    	 var ssoTab3=[];
		    	 var ssoTab4=[];
		    	 var ssoTab5=[];
		    	 var ssoTab6=[];
		    	 var ssoTab7=[];
		    	$scope.model1SSOList = [];
		    	
		    	
		    	var resultPxDataTable1 = document.getElementById("resultPxDataTable1");
		    	if(resultPxDataTable1!=null){
		    		resultPxDataTable1.addEventListener("px-row-click", function(e) {
		    			var finalArry=[];
		    			$scope.clickedRow = e.detail.row;
		    			  var index = $scope.model1SSOList.indexOf(($scope.clickedRow.row.sso.value));
		    			  
		    			  tab1.name =document.getElementById("tab1").value;
		    			  ssoTab1.push($scope.clickedRow.row.sso.value);
		    			  tab1.sso= ssoTab1;
		    			  $scope.jsonStringTab1= tab1;
		    			  if($scope.clickedRow._selected==false && index == -1)
		    				  $scope.model1SSOList.push($scope.clickedRow.row.sso.value);
		    			  else if(index > -1)
		    				  $scope.model1SSOList.splice(index,1); 
		    			});
		    	}
		    	
		    	var resultPxDataTable2 = document.getElementById("resultPxDataTable2");
		    	if(resultPxDataTable2!=null){
		    		resultPxDataTable2.addEventListener("px-row-click", function(e) {
		    			$scope.clickedRow = e.detail.row;
		    			  var index = $scope.model1SSOList.indexOf(($scope.clickedRow.row.sso.value));
		    			  
		    			  tab2.name =document.getElementById("tab2").value;
		    			  ssoTab2.push($scope.clickedRow.row.sso.value);
		    			  tab2.sso= ssoTab2;
		    			  $scope.jsonStringTab2= tab2;
		    			  if($scope.clickedRow._selected==false && index == -1)
		    				  $scope.model1SSOList.push($scope.clickedRow.row.sso.value);
		    			  else if(index > -1)
		    				  $scope.model1SSOList.splice(index,1); 
		    			});
		    	}
		    	
		    	var resultPxDataTable3 = document.getElementById("resultPxDataTable3");
		    	if(resultPxDataTable3!=null){
		    		resultPxDataTable3.addEventListener("px-row-click", function(e) {
		    			 
		    			$scope.clickedRow = e.detail.row;
		    			  
		    			  var index = $scope.model1SSOList.indexOf(($scope.clickedRow.row.sso.value));
		    			
		    			  tab3.name =document.getElementById("tab3").value;
		    			  ssoTab3.push($scope.clickedRow.row.sso.value);
		    			  tab3.sso= ssoTab3;
		    			  $scope.jsonStringTab3= tab3;
		    			  if($scope.clickedRow._selected==false && index == -1)
		    				  $scope.model1SSOList.push($scope.clickedRow.row.sso.value);
		    			  else if(index > -1)
		    				  $scope.model1SSOList.splice(index,1); 
		    			});
		    	}
		    	var resultPxDataTable4 = document.getElementById("resultPxDataTable4");
		    	if(resultPxDataTable4!=null){
		    		resultPxDataTable4.addEventListener("px-row-click", function(e) {
		    			$scope.clickedRow = e.detail.row;
		    			  
		    			  
		    			  var index = $scope.model1SSOList.indexOf(($scope.clickedRow.row.sso.value));
		    			  
		    			  tab4.name =document.getElementById("tab4").value;
		    			  ssoTab4.push($scope.clickedRow.row.sso.value);
		    			  tab4.sso= ssoTab4;
		    			  $scope.jsonStringTab4=tab4;
		    			  if($scope.clickedRow._selected==false && index == -1)
		    				  $scope.model1SSOList.push($scope.clickedRow.row.sso.value);
		    			  else if(index > -1)
		    				  $scope.model1SSOList.splice(index,1); 
		    			});
		    	}
		    	var resultPxDataTable5 = document.getElementById("resultPxDataTable5");
		    	if(resultPxDataTable5!=null){
		    		resultPxDataTable5.addEventListener("px-row-click", function(e) {
		    			$scope.clickedRow = e.detail.row;
		    			  
		    			  
		    			  var index = $scope.model1SSOList.indexOf(($scope.clickedRow.row.sso.value));
		    			  
		    			  tab5.name =document.getElementById("tab5").value;
		    			  ssoTab5.push($scope.clickedRow.row.sso.value);
		    			  tab5.sso= ssoTab5;
		    			  $scope.jsonStringTab5= tab5;
		    			  if($scope.clickedRow._selected==false && index == -1)
		    				  $scope.model1SSOList.push($scope.clickedRow.row.sso.value);
		    			  else if(index > -1)
		    				  $scope.model1SSOList.splice(index,1); 
		    			});
		    	}
		    	var resultPxDataTable6 = document.getElementById("resultPxDataTable6");
		    	if(resultPxDataTable6!=null){
		    		resultPxDataTable6.addEventListener("px-row-click", function(e) {
		    			$scope.clickedRow = e.detail.row;
		    			  
		    			  
		    			  var index = $scope.model1SSOList.indexOf(($scope.clickedRow.row.sso.value));
		    			  
		    			  tab6.name =document.getElementById("tab6").value;
		    			  ssoTab6.push($scope.clickedRow.row.sso.value);
		    			  tab6.sso= ssoTab6;
		    			  $scope.jsonStringTab6= tab6;
		    			  if($scope.clickedRow._selected==false && index == -1)
		    				  $scope.model1SSOList.push($scope.clickedRow.row.sso.value);
		    			  else if(index > -1)
		    				  $scope.model1SSOList.splice(index,1); 
		    			});
		    	}
		    	var resultPxDataTable7 = document.getElementById("resultPxDataTable7");
		    	if(resultPxDataTable7!=null){
		    		resultPxDataTable7.addEventListener("px-row-click", function(e) {
		    			$scope.clickedRow = e.detail.row;
		    			  console.log("Row clicked", $scope.clickedRow, " _selected: ", $scope.clickedRow._selected);
		    			  
		    			  
		    			  var index = $scope.model1SSOList.indexOf(($scope.clickedRow.row.sso.value));
		    			  
		    			  tab7.name =document.getElementById("tab7").value;
		    			  ssoTab7.push($scope.clickedRow.row.sso.value);
		    			  tab7.sso= ssoTab7;
		    			  $scope.jsonStringTab7=tab7;
		    			  if($scope.clickedRow._selected==false && index == -1)
		    				  $scope.model1SSOList.push($scope.clickedRow.row.sso.value);
		    			  else if(index > -1)
		    				  $scope.model1SSOList.splice(index,1); 
		    			});
		    	}
		    	
		    	
		    	
		    	
					$scope.submitParams = function(){	
						$scope.menuName=[];
						$scope.moduleSSOList=[];
						
						 $scope.moduleSSOList.push($scope.jsonStringTab1);
						 $scope.moduleSSOList.push($scope.jsonStringTab2);
						 $scope.moduleSSOList.push($scope.jsonStringTab3);
						 $scope.moduleSSOList.push($scope.jsonStringTab4);
						 $scope.moduleSSOList.push($scope.jsonStringTab5);
						 $scope.moduleSSOList.push($scope.jsonStringTab6);
						 $scope.moduleSSOList.push($scope.jsonStringTab7);
						 
						
						
						$http({
							method  : 'POST',
							url     : 'http://localhost:8081/pmms-api/systemSave',
							data    :  JSON.stringify($scope.moduleSSOList),				
						}).success(function(status, statusCode, headers, config) {
							if (status.status == true) {
								$scope.success = true;
								  tab1 = new Object();
						    	  tab2 = new Object();
						    	  tab3 = new Object();
						    	  tab4 = new Object();
						    	  tab5 = new Object();
						    	  tab6 = new Object();
						    	  tab7 = new Object();
						    	  ssoTab1=[];
						    	  ssoTab2=[];
						    	  ssoTab3=[];
						    	  ssoTab4=[];
						    	  ssoTab5=[];
						    	  ssoTab6=[];
						    	  ssoTab7=[];
								
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