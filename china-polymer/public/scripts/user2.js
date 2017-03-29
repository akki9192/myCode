isValid = function(value) {
	 var validator=document.querySelector('#sso_validate'),
     error = validator.validate(value);    
	 if(value && !error.passedValidation) {
    	 document.querySelector("#validationWarning1").innerHTML = error.failedValidationErrorMessage;
    	 document.querySelector("#validationWarning1").classList.remove("hidden");
    	 document.querySelector("#example1").classList.add("validation-error");
    	 document.querySelector("#label1").classList.add("validation-error");
     }
     else {
    	 document.querySelector("#validationWarning1").classList.add("hidden");
    	 document.querySelector("#example1").classList.remove("validation-error");
    	 document.querySelector("#label1").classList.remove("validation-error");
     }
 
}

/*document.getElementById("usertable").addEventListener("px-row-click", function(e) {
console.log(" ----------->> "+document.getElementById("usertable"));
  var clickedRow = e.detail.row;

  console.log("Row clicked", clickedRow, " _selected: ", clickedRow._selected);
});*/


/*var sso_chkbox=document.getElementById("sso_chkbox");
$( document ).ready(function() {
console.log(" ----------->> "+document.getElementById("sso_chkbox"));
document.getElementById("sso_chkbox").addEventListener(
	"px-row-click",
	function(e) {
	console.log("------------------------");
	var clickedRow = e.detail.row;
	console.log("Row clicked", clickedRow, " _selected: ",
	clickedRow._selected, "Not Selected",
	!clickedRow._selected);
	if (!clickedRow._selected) {
	document.getElementById("delete").disabled = false;
	
	} else {
	document.getElementById("delete").disabled = true;
	}

	});
});*/




/*document.addEventListener('WebComponentsReady', function() {

	document.getElementById("usertable").addEventListener(
	"px-row-click",
	function(e) {
	var clickedRow = e.detail.row;
	console.log("Row clicked", clickedRow, " _selected: ",
	clickedRow._selected, "Not Selected",
	!clickedRow._selected);
	if (!clickedRow._selected) {
	document.getElementById("delete").disabled = false;
	
	} else {
	document.getElementById("delete").disabled = true;
	}

	});

	});
	
	$scope.removeRow = function(id){				
		var index = -1;		
		var comArr = eval( $scope.companies );
		for( var i = 0; i < comArr.length; i++ ) {
			if( comArr[i].id === id ) {
				index = i;
				break;
			}
		}
		if( index === -1 ) {
			alert( "Something gone wrong" );
		}
		$scope.companies.splice( index, 1 );		
	};
*/

 
