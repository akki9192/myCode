/**
 * Load controllers, directives, filters, services before bootstrapping the
 * application. NOTE: These are named references that are defined inside of the
 * config.js RequireJS configuration file.
 */
define([
    'jquery',
    'angular',
    'main',
    'routes',
    'interceptors',
    'px-datasource',
    'ng-bind-polymer'
], function ($, angular) {
    'use strict';

    /**
	 * Application definition This is where the AngularJS application is defined
	 * and all application dependencies declared.
	 * 
	 * @type {module}
	 */
    var predixApp = angular.module('predixApp', [
        'app.routes',
        'app.interceptors',
        'sample.module',
        'predix.datasource',
        'px.ngBindPolymer'
    ]);

    predixApp.config(function($sceDelegateProvider) {
    	$sceDelegateProvider.resourceUrlWhitelist(['**']);  
    	});
    /**
	 * Main Controller This controller is the top most level controller that
	 * allows for all child controllers to access properties defined on the
	 * $rootScope.
	 */
    predixApp.controller('MainCtrl', ['$scope', '$rootScope', '$http', 'PredixUserService', function ($scope, $rootScope, $http, predixUserService) {
    	$scope.roleId=1;
    	$scope.roleModuleAccess=[];
    	
    	$scope.roleModuleAccessJSON={};
   	 $scope.callUserAccessDtlsPerRole = function(){
            $http({
          		method  : 'GET',
          		url     : 'http://localhost:8081/pmms-api/getRoleModuleAccess?roleId='+$scope.roleId,
          		
          		}).success(function(data, statusCode, headers, config) {
          		if (statusCode == 200 || status.status == true) {
          		$scope.success = true;
          		$scope.roleModuleAccess =data;
          	    window.App.session.roleModuleAccess=$scope.roleModuleAccess;// $scope.roleModuleAccessJSON
																			// ;
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
        // Global application object
        window.App = $rootScope.App = {
            version: '1.0',
            name: 'Predix Seed',
            session: {
            	roleModuleAccess:$scope.roleModuleAccessJSON	 
            },
            tabs: [
                /******************************************1st TAB********************************************************/
                {icon: 'fa-file-o', state: 'equipmentdocmgmt', label: '设备和设施和文件管理', subitems: [
                                                                                              
                      {state: 'equipMgmt', label: 'Equipment'},
					  {state: 'document', label: 'Document'},                                                                                         										  
					  {state: 'pictureUpload', label: 'Picture Upload'},
					  {state: 'facilityMainpage', label: 'Facility'},
					  {state: 'Equipment-FacilityUI', label: 'Equipment Facility'}
					  ]},
			/******************************************2nd TAB********************************************************/
					  {icon: 'fa-file-o', state: 'sparepartmgmt', label: '备件管理', subitems: [
					        {state: 'sparePart', label: 'Equipment'},
					        {state: 'facilitySparePart', label: ' Facility'},
					        {state: 'sparePartView', label: 'View'},                   
					        {state: 'operationLogMainpage', label: 'Operation Log'}
					    ]},
			/******************************************3rd TAB********************************************************/
                {icon: 'fa-file-o', state: 'MeasuringInstruments', label: '测量仪器库存管理', subitems: [
                     {state: 'measuringToolinventoryManagement', label: '量具台账管理页'},
                     {state: 'measuringToolStocktransactions', label: '量具库存事务页'},
                     {state: 'calibrationScheme', label: '检定计划页'},
                     {state: 'scrappedMeasuringToolsList ', label: '报废量具清单'},
                     {state: 'measuringToolInventoryViewMode', label: '测量工具库存查看模式'}
                   ]},
              /******************************************4th TAB********************************************************/
                   {icon: 'fa-file-o', state: 'WorkOrder', label: 'BM管理', subitems: [
                     {state: 'breakdownWO-mainpage', label: 'BM工作单'},
                     {state: 'facility', label: '设施工作命令'}
                 ]},
                 /******************************************5th TAB********************************************************/
                {icon: 'fa-file-o', state: 'inspectionnsmmmgmt', label: '检查和计划维护管理', subitems: [
                   {state: 'ScheduleMaintenance', label: 'Scheduled Mainatainance'},
                   {state: 'operatorInspectionWO', label: 'Operators Inspection'},
                   {state: 'MaintainanceTechnician', label: 'Maintainance Technician'},
                   {state: 'equipmentIssueList', label: 'Equipment Issue List'},
                   {state: 'SMSched', label: 'SM Scheduling'} ,  
                   {state: 'InspectionSMContentRoot', label: 'SM Content'},
                   {state: 'InspectionRecordingTracking', label: 'Current Records'},
                   {state: 'InspectionRecordingHistory', label: 'History Records'}
                ]},
                /******************************************6th TAB********************************************************/
                {icon: 'fa-file-o', state: 'systemSetting', label: '系统设置', subitems: [
                    {state: 'user', label: '用户管理'},
					{state: 'Role', label: '角色管理'},
					{state: 'system', label: '系统配置'}
                ]},
                /******************************************7th TAB********************************************************/
                {icon: 'fa-file-o', state: 'EquipmentBreakdown', label: '报告和分析', subitems: [
	                {state: 'EquipmentBreakdownTimeStatistics', label: 'Equipment Breakdown Time Statistics'},
	                {state: 'EquipmentMtbf', label: 'Equipment MTBF statistics and report'},                                                                                        
	                {state: 'mspc', label: 'Maintenance Spare-part Cost statistics'},
					{state: 'mspqu', label: 'Maintenance Spare-part Quantity statistics'},
					{state: 'TopNEquipmentBreakdownCount', label: 'Equipment Breakdown Count'},
					{state: 'TopSparePartReport', label: 'Spare Part'},
					{state: 'TopNEquipmentBreakdownCount', label: 'Top N Equipment Breakdown Count'},
					{state: 'TopSparePart-Report', label: 'Top N Spare Part'},
					{state: 'EquipmentStateDiagramRpt', label: 'Equipment State Diagram'}
			 ]},
				/******************************************END********************************************************/
            ]
        };
        $rootScope.$on('$stateChangeError', function (event, toState, toParams, fromState, fromParams, error) {
            if (angular.isObject(error) && angular.isString(error.code)) {
                switch (error.code) {
                    case 'UNAUTHORIZED':
                        // redirect
                        predixUserService.login(toState);
                        break;
                    default:
                        // go to other error state
                }
            }
            else {
                // unexpected error
            }
        });
    }]);


    // Set on window for debugging
    window.predixApp = predixApp;

    // Return the application object
    return predixApp;
});


/*
 * {icon: 'fa-file-o', state: 'scheduledmaintmgmt', label:
 * '计划维修管理', subitems: [ {state: 'scheduledMaint', label:
 * 'SM工单'}, {state: 'operatorworkorder', label: '操作点检工单'},
 * {state: 'repairworkorder', label: '维修点检工单'}, {state:
 * 'equipmentproblemlist', label: '设备问题表'}, {state:
 * 'maintplanning', label: '计划维修制定'}, {state: 'planmaintinfo',
 * label: '计划维修内容'}, {state: 'maintrecords', label: '点检保养记录'},
 * {state: 'equipmentIssueList', label: 'Equipment Issue List'},
 * {state: 'maintrecords', label: '点检保养记录'}, {state:
 * 'MaintainanceTechnician', label: 'Maintainance Technician'}
 * 
 * ]},
 */


/*
	 * {state: 'facilityEquipment', label: 'Facility
	 * Equipment'}, {state: 'facilityEquipment', label:
	 * 'Facility Equipment'}, {state: 'pictureUpload',
	 * label: 'Picture Upload'},
	 */ 

/*
 * {icon: 'fa-file-o', state: 'measuremgmt', label: '量具管理',
 * subitems: [ {state: 'blanksubpage5', label: 'Blank Sub Page'}
 * ]},
 */

/*
 * ]}, {icon: 'fa-file-o', state: 'InspectionRecordingTracking',
 * label: '检查记录跟踪', subitems: [ {state: 'CurrentCycleRecord',
 * label: 'Current Records'}, {state: 'HistoryRecord', label:
 * 'History Records'}
 */

/*
 * {icon: 'fa-file-o', state: 'blankpage', label: '车间现场链接',
 * subitems: [ {state: 'dashboards', label: '故障报修'}, {state:
 * 'blanksubpage', label: '故障修理'}, {state: 'dashboards', label:
 * '操作工点检'}, {state: 'dashboards', label: '维修工点检'}, {state:
 * 'scheduledmaint', label: '计划维修'}, {state:
 * 'equipmentDashboard', label: '设施工单'}, {state:
 * 'facilities-disposal', label: 'FacilitiesWO Disposal'},
 * {state: 'breakdownWO-mainpage', label: 'BreakDown WorkOrder
 * Management'}, {state: 'Equipment-FacilityUI', label:
 * 'Equipment-Facility Management'}, {state: 'dashboards',
 * label: '设备问题表'} ]},
 */


/*{icon: 'fa-file-o', state: 'blankpage', label: '车间现场链接', subitems: [
    {state: 'dashboards', label: '故障报修'},
    {state: 'blanksubpage', label: '故障修理'},
    {state: 'dashboards', label: '操作工点检'},
    {state: 'dashboards', label: '维修工点检'},
    {state: 'scheduledmaint', label: '计划维修'},
    {state: 'equipmentDashboard', label: '设施工单'},
    {state: 'facilities-disposal', label: 'FacilitiesWO Disposal'},
    {state: 'Equipment-FacilityUI', label: 'Equipment-Facility Management'},
    {state: 'dashboards', label: '设备问题表'}
]},*/


/*
 * {icon: 'fa-tachometer', state: 'dashboards', label: '故障报修'},
 * {icon: 'fa-file-o', state: 'blankpage', label: '故障修理',
 * subitems: [ {state: 'blanksubpage', label: 'Blank Sub Page'}
 * ]}, {icon: 'fa-tachometer', state: 'dashboards1', label:
 * '操作工点检'}, {icon: 'fa-tachometer', state: 'dashboards2',
 * label: '维修工点检'}, {icon: 'fa-tachometer', state:
 * 'scheduledmaint', label: '计划维修'}, {icon: 'fa-tachometer',
 * state: 'dashboards4', label: '设施工单'}, {icon: 'fa-tachometer',
 * state: 'equipmentDashboard', label: '设备看板'}, {icon:
 * 'fa-tachometer', state: 'dashboards6', label: '设备问题表'}
 * 
 * {icon: 'fa-file-o', state: 'workordermanagement', label:
 * '故障维修管理', subitems: [ {state: 'CurrentYear', label: 'Current
 * Year Prevention Maintainance'} ]},
 */
