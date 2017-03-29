define(['angular', './sample-module'], function (angular, controllers) {
	    'use strict';

	    controllers.config(function($sceDelegateProvider) {
	     $sceDelegateProvider.resourceUrlWhitelist(['**']);  
	    });
	    
	    controllers.controller('UserCtrl', ['$scope', '$http', function($scope,$http) {
	     
	$scope.newUser = {};
	$scope.sso_chkbox="";
	$scope.deleteList = [];
	$scope.userAdded=false;
	$scope.userUpdated=false;
	$scope.openAddModal = function(){
		console.log("openAddModal -- modalButtonClicked");
		Polymer.dom(document).querySelector("#addModal").modalButtonClicked();
	};
	
	var addModal = document.getElementById("addModal");
	if(addModal!=null){
		addModal.addEventListener("btnModalPositiveClicked", function(e) {
			console.log(" ----addModal clicked------->> ");
			if($scope.userAdded==false)
				$scope.userAdded=true;
			
			$scope.addUser();
			});
	}
	
	var editModal = document.getElementById("editModal");
	if(editModal!=null){
		editModal.addEventListener("btnModalPositiveClicked", function(e) {
			console.log(" ----editModal clicked------->> ");
			if($scope.userUpdated==false)
				$scope.userUpdated=true;
		
			$scope.editUser();
			});
	}
	
	var deleteModal = document.getElementById("deleteModal");
	if(deleteModal!=null){
		deleteModal.addEventListener("btnModalPositiveClicked", function(e) {
			console.log(" ----deleteModal clicked------->> ");
			$scope.removeUser();
			});
	}
	
	var userTable = document.getElementById("usertable");
	if(userTable!=null){
		userTable.addEventListener("px-row-click", function(e) {
			console.log(" ----------->> "+document.getElementById("usertable"));
			$scope.clickedRow = e.detail.row;
			  console.log("Row clicked", $scope.clickedRow, " _selected: ", $scope.clickedRow._selected);
			  var index = $scope.deleteList.indexOf(($scope.clickedRow.row.id.value));
			  
			  if($scope.clickedRow._selected==false && index == -1)
				  $scope.deleteList.push($scope.clickedRow.row.id.value);
			  else if(index > -1)
				  $scope.deleteList.splice(index,1); 
			});

	}
	
	$scope.hello = function() {
		alert("hello");
	};
	
	$scope.isValid = function(value) {
		alert("hello"+value);
	};
	$scope.addUser = function() { 
	
	console.log("addUser ---- ");
	if($scope.userAdded == false)
		return;
	
	$scope.role = document.getElementById("role").value;
	$scope.language = document.getElementById("language").value;
	console.log(" role: "+$scope.role +"  language: "+$scope.language );
	if($scope.language == 'English')
		$scope.language='En';
	else if($scope.language == 'Chinese')
		$scope.language='Zh';
	
	if($scope.firstName==undefined || $scope.lastName == undefined || $scope.sso == undefined || $scope.passwd == undefined || $scope.emailId == undefined || $scope.contactNo==undefined)
		return;
	
	$http({
	method  : 'POST',
	url     : 'http://localhost:8081/pmms-api/save',
	data    :  {
	"firstname": $scope.firstName,
	"lastname":$scope.lastName,
	"sso": $scope.sso,
	"password": $scope.passwd,
	"emailid": $scope.emailId,
	"contactno": $scope.contactNo,
	"role": $scope.role,
	"language":$scope.language
	 }
	
	}).success(function(status, statusCode, headers, config) {
	if (statusCode == 200 || status.status == true) {
	$scope.success = true;
	
	document.querySelector('user-mngt').refreshData(); 
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
	
	$scope.editUser = function(){
		console.log("editUser ---- ");
		//clearing delete list as records are selected for edit not for delete
		$scope.deleteList = [];
		
		if($scope.userUpdated == false)
			return;
		
		$scope.firstName = document.getElementById("firstName").value;
		$scope.lastName = document.getElementById("lastName").value;
		$scope.contactNo = document.getElementById("contactNo").value;
		$scope.emailId = document.getElementById("emailId").value;
		
		$scope.role = document.getElementById("editRole").value;
		$scope.language = document.getElementById("editLanguage").value;
		
		
		console.log(" role: "+$scope.role +"  language: "+$scope.language +" sso_chkbox "+$scope.sso_chkbox+" firstName : "+$scope.firstName+" lastName : "+$scope.lastName);
		console.log(" emailId: "+$scope.emailId +"  contactNo: "+$scope.contactNo);
		
		if($scope.firstName==undefined || $scope.lastName == undefined || $scope.sso == undefined || $scope.passwd == undefined || $scope.emailId == undefined || $scope.contactNo==undefined)
			return;
		
		if($scope.language == 'English')
			$scope.language='En';
		else if($scope.language == 'Chinese')
			$scope.language='Zh';
		
		$http({
			method  : 'POST',
			url     : 'http://localhost:8081/pmms-api/save',
			data    :  {
			"id": $scope.clickedRow.row.id.value,
			"firstname": $scope.firstName,
			"lastname":$scope.lastName,
			"sso": $scope.clickedRow.row.sso.value,
			"password": $scope.clickedRow.row.password.value,
			"emailid": $scope.emailId,
			"contactno": $scope.contactNo,
			"role": $scope.role,
			"language":$scope.language
			 }
			
			}).success(function(status, statusCode, headers, config) {
			if (statusCode == 200 || status.status == true) {
			$scope.success = true;
			document.querySelector('user-mngt').refreshData(); 
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
	
	$scope.removeUser=function(){
		console.log("$scope.deleteList : "+$scope.deleteList);
		if ($scope.deleteList.length == 0) {
			return;
		}
		$http({
			method  : 'POST',
			url     : 'http://localhost:8081/pmms-api/deleteUser',
			data    :  $scope.deleteList
			
			}).success(function(status, statusCode, headers, config) {
			if (statusCode == 200 || status.status == true) {
			$scope.success = true;
			$scope.deleteList = [];
			document.querySelector('user-mngt').refreshData(); 
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


