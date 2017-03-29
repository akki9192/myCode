define(['angular', './sample-module'], function (angular, controllers) {
	    'use strict';

	    controllers.config(function($sceDelegateProvider) {
	     $sceDelegateProvider.resourceUrlWhitelist(['**']);  
	    });
	    
	    controllers.controller('documentCtrl', ['$scope', '$http', function($scope,$http) {
	    console.log("Inside documentCtrl..........");
	     
	$scope.newDocument = {};
/*	$scope.sso_chkbox="";*/
	$scope.deleteList = [];
	$scope.documentAdded=false;
	$scope.documentUpdated=false;
	$scope.openAddModal = function(){
		console.log("openAddModal -- modalButtonClicked");
		Polymer.dom(document).querySelector("#addModal").modalButtonClicked();
	};
	
	var addDocModal = document.getElementById("addDocModal");
	if(addDocModal!=null){
		addDocModal.addEventListener("btnModalPositiveClicked", function(e) {
			console.log(" ----addDocModal clicked------->> ");
			if($scope.documentAdded==false)
				$scope.documentAdded=true;
			
			$scope.addDocument();
			});
	}
	
	var editDocModal = document.getElementById("editDocModal");
	if(editDocModal!=null){
		editDocModal.addEventListener("btnModalPositiveClicked", function(e) {
			console.log(" ----editDocModal clicked------->> ");
			if($scope.documentUpdated==false)
				$scope.documentUpdated=true;
		
			$scope.editDocument();
			});
	}
	
	var deleteDocModal = document.getElementById("deleteDocModal");
	if(deleteDocModal!=null){
		deleteDocModal.addEventListener("btnModalPositiveClicked", function(e) {
			console.log(" ----deleteDocModal clicked------->> ");
			$scope.removeDocument();
			});
	}
	
	var documentTable = document.getElementById("documenttable");
	if(documentTable!=null){
		documentTable.addEventListener("px-row-click", function(e) {
			console.log(" ----------->> "+document.getElementById("documenttable"));
			$scope.clickedRow = e.detail.row;
			  console.log("Row clicked", $scope.clickedRow, " _selected: ", $scope.clickedRow._selected);
			  var index = $scope.deleteList.indexOf(($scope.clickedRow.row.id.value));
			  
			  if($scope.clickedRow._selected==false && index == -1)
				  $scope.deleteList.push($scope.clickedRow.row.id.value);
			  else if(index > -1)
				  $scope.deleteList.splice(index,1); 
			});

	}
	
	$scope.addDocument = function() { 
	
	console.log("Adding Document ---- ");
	if($scope.documentAdded == false)
		return;
	
	$scope.fileName = document.getElementById("uploadfilename").value;
	$scope.fileType = document.getElementById("fileType").value;
	$scope.memo = document.getElementById('memo').value;
	$scope.fileSize = document.getElementById("uploadfilesize").value;
	/*$scope.description = document.getElementById("description").value*/;
	console.log(" fileName: "+$scope.fileName +"  fileSize: "+$scope.fileSize );
	/*if($scope.language == 'English')
		$scope.language='En';
	else if($scope.language == 'Chinese')
		$scope.language='Cn';
	*/
	if($scope.fileName==undefined || $scope.fileType == undefined || $scope.memo== undefined)
		return;
	
	$http({
	method  : 'POST',
	url     : 'http://localhost:8081/pmms-api/saveDocDetails',
	data    :  {
	"fileName": $scope.fileName,
	"fileSize":$scope.fileSize,
	"description" : $scope.memo,
	"fileType" : $scope.fileType	
	 }
	
	}).success(function(status, statusCode, headers, config) {
	if (statusCode == 200 || status.status == true) {
	$scope.success = true;
	
	document.querySelector('document-mngt').refreshData(); 
	document.querySelector('document-mngt').refreshData(); 
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
	
	$scope.editDocument = function(){
		console.log("Edit Document ---- ");
		//clearing delete list as records are selected for edit not for delete
		$scope.deleteList = [];
		
		if($scope.documentUpdated == false)
			return;
		
		$scope.fileName = document.getElementById("edfileName").value;
		$scope.fileType = document.getElementById("edfileType").value;
		$scope.memo = document.getElementById('eddescription').value;
	/*	$scope.fileSize = document.getElementById("uploadfilesize").value;*/
		
		
		console.log(" fileName in Edit function: "+$scope.fileName +"  fileType in Edit function: "+$scope.fileType);
		/*console.log(" emailId: "+$scope.emailId +"  contactNo: "+$scope.contactNo);*/
		
		/*if($scope.fileName==undefined || $scope.fileType==undefined)
			return;*/
		
		
		$http({
			method  : 'POST',
			url     : 'http://localhost:8081/pmms-api/editDoc',
			data    :  {
			"id": $scope.clickedRow.row.id.value,
			"fileName": $scope.fileName,
			"fileType":$scope.fileType,
			"description": $scope.memo			
			 }
			
			}).success(function(status, statusCode, headers, config) {
			if (statusCode == 200 || status.status == true) {
			$scope.success = true;
			document.querySelector('document-mngt').refreshData(); 
			document.querySelector('document-mngt').refreshData(); 
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
	}
	
	$scope.removeDocument=function(){
		console.log("$scope.deleteList : "+$scope.deleteList);
		if ($scope.deleteList.length == 0) {
			return;
		}
		$http({
			method  : 'POST',
			url     : 'http://localhost:8081/pmms-api/deleteDocument',
			data    :  $scope.deleteList
			
			}).success(function(status, statusCode, headers, config) {
			if (statusCode == 200 || status.status == true) {
			$scope.success = true;
			$scope.deleteList = [];
			document.querySelector('document-mngt').refreshData(); 
			document.querySelector('document-mngt').refreshData(); 
			document.querySelector('document-mngt').refreshData(); 
			} else {
			$scope.success = false;
			}
			})
			.error(function(data, status, headers, config) {
			$scope.success = false;
			})
			.finally(function() {
			$scope.finished = true;
			$scope.deleteList = [];
			});
	}
	
	    }]);
	});


