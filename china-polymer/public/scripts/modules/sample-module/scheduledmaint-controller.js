define(['angular', './sample-module'], function (angular, controllers) {
    'use strict';

    controllers.controller('SMCtrl', ['$scope', function($scope) {
        $scope.toggleMenu = function() {
            var selectedRows = document.getElementById("historicaltable").selectedRows;
            console.log(selectedRows.length);
            if (selectedRows.length==0) {
                 alert("Please select only one record!");
                  $scope.menuState.show=false;
            }else if(selectedRows.length>0 && selectedRows.length!=1){

                alert("Please select only one record!");
                  $scope.menuState.show=false;
            }else{
                
            }
           
            
        };
    }]);
});