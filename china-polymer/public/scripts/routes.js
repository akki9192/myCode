/**
 * Router Config
 * This is the router definition that defines all application routes.
 */
define(['angular', 'angular-ui-router'], function(angular) {
    'use strict';
    return angular.module('app.routes', ['ui.router']).config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function($stateProvider, $urlRouterProvider, $locationProvider) {

        //Turn on or off HTML5 mode which uses the # hash
        $locationProvider.html5Mode(true).hashPrefix('!');

        /**
         * Router paths
         * This is where the name of the route is matched to the controller and view template.
         */
        $stateProvider.state('dashboards', {
                url: '/blankpage',
                templateUrl: 'views/blank-page.html',
                controller: 'DashboardsCtrl'
            })
            .state('ScheduleMaintenance', {
                url: '/ScheduleMaintenance',
                templateUrl: 'views/ScheduleMaintenance.html'
            })
            .state('blanksubpage', {
                url: '/blanksubpage',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('equipmentDashboard', {
                url: '/equipmentDashboard',
                templateUrl: 'views/equipmentDashboard.html'
            })
            .state('scheduledmaint', {
                url: '/scheduledmaint',
                templateUrl: 'views/scheduledmaint.html'
            })
            .state('workordermanagement',{
                url: '/workordermanagement',
                templateUrl: 'views/blank-page.html'
            })
            .state('MeasuringInstruments',{
                url: '/MeasuringInstruments',
                templateUrl: 'views/blank-page.html'
            })
            .state('scheduledmaintmgmt',{
                url: '/scheduledmaintmgmt',
                templateUrl: 'views/blank-page.html'
            })
            .state('sparepartmgmt',{
                url: '/sparepartmgmt',
                templateUrl: 'views/blank-page.html'
            })
            .state('analyticalstatementmgmt',{
                url: '/analyticalstatementmgmt',
                templateUrl: 'views/blank-page.html'
            })
            .state('equipmentdocmgmt',{
                url: '/equipmentdocmgmt',
                templateUrl: 'views/blank-page.html'
            })
            .state('SMSched', {
                url: '/SMSched',
                templateUrl: 'views/SMSched.html'
			})			  
            .state('document', {
                url: '/document',
                templateUrl: 'views/document.html'
			})
           
            .state('measuremgmt',{
                url: '/measuremgmt',
                templateUrl: 'views/blank-page.html'
            })
            .state('systemmgmt',{
                url: '/systemmgmt',
                templateUrl: 'views/blank-page.html'
            })
            .state('scheduledMaint', {
                url: '/scheduledMaint',
                templateUrl: 'views/scheduledMaint.html'
            })
            .state('operatorworkorder', {
                url: '/operatorworkorder',
                templateUrl: 'views/operatorworkorder.html'
            })
            .state('repairworkorder', {
                url: '/repairworkorder',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('equipmentproblemlist', {
                url: '/equipmentproblemlist',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('maintplanning', {
                url: '/maintplanning',
                templateUrl: 'views/maintplanning.html'
            })
            .state('InspectionSMContentRoot', {
                url: '/InspectionSMContentRoot',
                templateUrl: 'views/InspectionSMContentRoot.html'
            })
            .state('maintrecords', {
                url: '/maintrecords',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('blanksubpage1', {
                url: '/blanksubpage1',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('blanksubpage2', {
                url: '/blanksubpage2',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('blanksubpage3', {
                url: '/blanksubpage3',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('blanksubpage4', {
                url: '/blanksubpage4',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('blanksubpage5', {
                url: '/blanksubpage5',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('blanksubpage6', {
                url: '/blanksubpage6',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('currency', {
                url: '/currency',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('historical', {
                url: '/historical',
                templateUrl: 'views/blank-sub-page.html'
            })
            .state('user', {
                url: '/user',
                templateUrl: 'views/user.html'
				
            })
			.state('Role', {
                url: '/Role',
                templateUrl: 'views/Role.html'
            })
			.state('system', {
                url: '/system',
                templateUrl: 'views/system.html'
			})
			.state('sparePart', {
                url: '/sparePart',
                templateUrl: 'views/sparePart.html'
			})  
			.state('facilitySparePart', {
                url: '/facilitySparePart',
                templateUrl: 'views/facilitySparePart.html'
			})  
			.state('sparePartView', {
                url: '/sparePartView',
                templateUrl: 'views/sparePartView.html'
			})  
			.state('operationLogMainpage', {
                url: '/operationLogMainpage',
                templateUrl: 'views/operationLogMainpage.html'
			}) 
			.state('CurrentYear', {
                url: '/CurrentYear',
                templateUrl: 'views/CurrentYear.html'				
			})			
			.state('facilityEquipment', {
                url: '/facilityEquipment',
                templateUrl: 'views/facilityEquipment.html'						
			})
			.state('pictureUpload', {
                url: '/pictureUpload',
                templateUrl: 'views/pictureUpload.html'						
			})				
			.state('workorder', {
				url: '/workorder',
				templateUrl: 'views/workorder.html'
			})
			.state('bmworkorder', {
				url: '/bmworkorder',
				templateUrl: 'views/bmworkorder.html'
			})
			.state('facility', {
				url: '/facility',
				templateUrl: 'views/facilitywo.html'
			})
			.state('sm', {
				url: '/sm',
				templateUrl: 'views/sm.html'			
			})
            .state('breakdownWO-mainpage', {
                url: '/breakdownWO-mainpage',
                templateUrl: 'views/breakdownWO-mainpage.html'
            })
            .state('facilities-disposal', {
                url: '/facilities-disposal',
                templateUrl: 'views/facilities-disposal.html'
            })
            .state('facilityMainpage', {
                url: '/facilityMainpage',
                templateUrl: 'views/facilityMainpage.html'
            })
            .state('Equipment-FacilityUI', {
                url: '/Equipment-FacilityUI',
                templateUrl: 'views/Equipment-FacilityUI.html'
            })
             .state('measuringToolinventoryManagement', {
                url: '/measuringToolinventoryManagement',
                templateUrl: 'views/measuringToolinventoryManagement.html'
            })
             .state('measuringToolStocktransactions', {
                url: '/measuringToolStocktransactions',
                templateUrl: 'views/measuringToolStocktransactions.html'
            })
             .state('calibrationScheme', {
                url: '/calibrationScheme',
                templateUrl: 'views/calibrationScheme.html'
            })
             .state('scrappedMeasuringToolsList', {
                url: '/scrappedMeasuringToolsList',
                templateUrl: 'views/scrappedMeasuringToolsList.html'
            })
            .state('measuringToolInventoryViewMode', {
                url: '/measuringToolInventoryViewMode',
                templateUrl: 'views/measuringToolInventoryViewMode.html'
            })
            .state('equipMgmt', {
                url: '/equipMgmt',
                templateUrl: 'views/equipMgmt.html'
            })
            .state('MaintainanceTechnician', {
                url: '/MaintainanceTechnician',
                templateUrl: 'views/MaintainanceTechnician.html'
            })
            .state('operatorInspectionWO', {
                url: '/operatorInspectionWO',
                templateUrl: 'views/operatorInspectionWO.html'
            })
            .state('equipmentIssueList', {
            url: '/equipmentIssueList',
            templateUrl: 'views/equipmentIssueList.html'
            	
            })
            .state('InspectionRecordingTracking', {
            url: '/InspectionRecordingTracking',
            templateUrl: 'views/InspectionRecordingTracking.html'
            
            })            
            .state('EquipmentBreakdownTimeStatistics', {
                url: '/EquipmentBreakdownTimeStatistics',
                templateUrl: 'views/EquipmentBreakdownTimeStatistics.html'
                
                })
                
             .state('EquipmentStateDiagramRpt', {
                url: '/EquipmentStateDiagramRpt',
                templateUrl: 'views/EquipStateDiagram.html'
                
                })        
                
                
             .state('EquipmentBreakdown', {
                 url: '/EquipmentBreakdown',                
                 templateUrl: 'views/blank-page.html'
                
                })               
            
            .state('InspectionRecordingHistory', {
            url: '/InspectionRecordingHistory',
            templateUrl: 'views/InspectionRecordingHistory.html'
            	
            })
            .state('SmScheduling', {
            url: '/SmScheduling',
            templateUrl: 'views/SmScheduling.html'
            	


        })
        .state('EquipmentMtbf', {
                url: '/EquipmentMtbf',
                templateUrl: 'views/EquipmentMtbf.html'
                
                })
             .state('mspc',{
                url: '/mspc',
                templateUrl: 'views/mspc.html'
            })
            .state('TopNEquipmentBreakdownCount',{
                url: '/TopNEquipmentBreakdownCount',
                templateUrl: 'views/TopNEquipmentBreakdownCount.html'
            })
            .state('mspqu',{
                url: '/mspqu',
                templateUrl: 'views/mspqu.html'
            })
            .state('TopSparePart-Report',{
                url: '/TopSparePart-Report',
                templateUrl: 'views/TopSparePart-Report.html'
            });

        $urlRouterProvider.otherwise(function ($injector) {
				var $state = $injector.get('$state');
				document.querySelector('px-app-nav').markSelected('/dashboards');
				$state.go('dashboards');
			});

		}]);
	});
