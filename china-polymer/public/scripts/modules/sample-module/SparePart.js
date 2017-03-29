define(['angular', './sample-module'], function (angular, controllers) {
		    'use strict';

		    controllers.config(function($sceDelegateProvider) {
		    	$sceDelegateProvider.resourceUrlWhitelist(['**']);  
		    });
		    
		    controllers.controller('sparePartController', ['$scope', '$http', function($scope,$http) {

		    	console.log("Hello..........");
		    	
		    	$scope.deleteList = [];
		    	$scope.sparePartAdded=false;
		    	$scope.sparePartUpdated=false;
		    	
		    	
		    		/** ********************ADD**************************** */
		    	/*console.log("******In spare part*******");
		    	$scope.openAddsparePart = function(){
		    	console.log("openAddsparePart -- modalButtonClicked");
		    	Polymer.dom(document).querySelector("#addSparePart").modalButtonClicked();
		    	};
		    	var add = document.getElementById("addSparePart");
		    	if(add!=null){
		    		add.addEventListener("btnModalPositiveClicked", function(e) {
		    	console.log(" ----addsparepart clicked------->> ");
		    	if($scope.sparePartAdded==false)
		    	$scope.sparePartAdded=true;

		    	$scope.AddSparePart();
		    	});
		    	}
		    	
		    	$scope.AddSparePart = function() { 

		    		console.log("--------- Add sparePart -------");		    		
		    		if($scope.sparePartAdded == false)
		    		return;
		    		$scope.sparePartNo = document.getElementById("id").value;
		    		$scope.spareName = document.getElementById("name").value;
		    		
		    		$scope.type = document.getElementById("type").value;
		    		$scope.source = document.getElementById("manufacturer").value;
		    		$scope.measurement = document.getElementById("unit").value;
		    		$scope.price = document.getElementById("price").value;
		    		$scope.stock = document.getElementById("stock").value;
		    		$scope.safteyStock = document.getElementById("safty").value;
		    		$scope.sysSafteyStock = document.getElementById("system").value;
		    		$scope.location = document.getElementById("loc").value;
		    		$scope.remark = document.getElementById("remark").value;
		    		
		    		console.log("--------- Add sparePart again -------");
		    		
		    		
					 * if($scope.spareName==undefined || $scope.sparePartNo ==
					 * undefined || $scope.type==undefined || $scope.source ==
					 * undefined || $scope.measurement==undefined ||
					 * $scope.price == undefined || $scope.stock==undefined ||
					 * $scope.safteyStock == undefined ||
					 * $scope.sysSafteyStock==undefined || $scope.location ==
					 * undefined || $scope.remark==undefined) return;
					 
		    	
		    		console.log("--------- Add sparePart once more -------");	
		    		
		    		$http({
		    			method  : 'POST',
		    			url     : 'http://localhost:8081/pmms-api/SaveSpare', 
		    			data    :  {
		    			"sparePartNo":$scope.sparePartNo,
		    			"name": $scope.spareName,
		    			"type": $scope.type,
		    			"source": $scope.source,
		    			"measurement":$scope.measurement,
		    			"price": $scope.price,
		    			"stock":$scope.stock,
		    			"safteyStock": $scope.safteyStock,
		    			"sysSafteyStock":$scope.sysSafteyStock,
		    			"location": $scope.location,	
		    			"remark":$scope.remark		    			    			
		    			}		    	
		    			}).success(function(status, statusCode, headers, config) {
		    			if (statusCode == 200 || status.status == true) {
		    				console.log("added successfully ");	
		    				 alert("Added Successfully"); 
		    			$scope.success = true;

		    			document.querySelector('spare-elem').refreshData(); 
		    			} else {
		    				console.log("added unsuccessfully ");	
		    				 alert("Try Again!!!!!") 
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
		    	
		    	/** *******************************EDIT************************************** */
	    		
				console.log("********editing************");
				
				var edit = document.getElementById("editspart");
				if(edit!=null){
					edit.addEventListener("btnModalPositiveClicked", function(e) {
						console.log(" ----editModal clicked------->> ");
						if($scope.sparePartUpdated==false)
							$scope.sparePartUpdated=true;
					
						$scope.EditSparePart();
						});
				}
				
				$scope.EditSparePart = function(){
					console.log("edit Sapare Part ---- ");
					if($scope.sparePartUpdated == false){
						return;
					}
					$scope.Id=document.getElementById("sid").value;
		    		$scope.modelNo=document.getElementById("id").value;
		    		$scope.sparePartName=document.getElementById("spareName").value;
		    		$scope.type=document.getElementById("typ").value;
		    		$scope.manufacturerName=document.getElementById("mnfctr").value;
		    		$scope.unit=document.getElementById("unt").value;
		    		$scope.price=document.getElementById("prc").value;
		    		$scope.stock=document.getElementById("stck").value;
		    		$scope.safteyStock=document.getElementById("safty").value;
		    		$scope.systemSafteyStock=document.getElementById("sss").value;
		    		$scope.Location=document.getElementById("location").value;
		    		$scope.remark=document.getElementById("rmrk").value;
		    			
		    		/*
					 * console.log(" rolename: "+$scope.roleName +"
					 * roeldescription: "+$scope.roleDescription);
					 * 
					 * if($scope.roleName==undefined || $scope.roleDescription ==
					 * undefined) return;
					 */
		    		
					$http({
						method  : 'POST',
						url     : 'http://localhost:8081/pmms-api/SaveSpare',
						data    :  {
						"id":  $scope.clickedRow.row.sid.value,
						"sparePartNo": $scope.modelNo,
						"name":$scope.sparePartName,
						"type": $scope.type,
						"source": $scope.manufacturerName,
						"measurement":$scope.unit,
						"price": $scope.price,
						"stock": $scope.stock,
						"safteyStock":$scope.safteyStock,
						"sysSafteyStock": $scope.systemSafteyStock,
						"location": $scope.Location,
						"remark":$scope.remark
						 }
						
						}).success(function(status, statusCode, headers, config) {
						if (statusCode == 200 || status.status == true) {
						$scope.success = true;
						document.querySelector('spare-elem').refreshData(); 
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
				
		    	/** **********************************DELETE************************************* */
				
			var deleteSparePart = document.getElementById("RemoveSparePart");
			if(deleteSparePart!=null){
				
				deleteSparePart.addEventListener("px-row-click", function(e) 
					{
						console.log(" ----------->> "+document.getElementById("RemoveSparePart"));
						$scope.clickedRow = e.detail.row;
						console.log("Row clicked", $scope.clickedRow, " _selected: ", $scope.clickedRow._selected);
						var index = $scope.deleteList.indexOf(($scope.clickedRow.row.id.value));
			  
						if($scope.clickedRow._selected==false && index == -1)
							$scope.deleteList.push($scope.clickedRow.row.id.value);
						else if(index > -1)
							$scope.deleteList.splice(index,1); 
				});
			}
			$scope.DeleteSparePart=function()
			{
				console.log("$scope.deleteList : "+$scope.deleteList);
				if ($scope.deleteList.length == 0) {
					return;
				}
				$http({
					method  : 'POST',
					url     : 'http://localhost:8081/pmms-api/deleteSparePart',
					data    :  $scope.deleteList
					
					}).success(function(status, statusCode, headers, config) {
					if (statusCode == 200 || status.status == true) {
						alert("Deleted successfully!!!");
					$scope.success = true;
					document.querySelector('spare-elem').refreshData(); 						
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
					});
			};
		    }]);
});		   

		    	
		    	