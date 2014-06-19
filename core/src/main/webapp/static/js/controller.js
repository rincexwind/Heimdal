'use strict';
 
/* Controllers Module for studentDetailApp application*/
var studentControllerModule =  angular.module('studentDetailApp.controllers', ['ui.bootstrap']);
 
/*StudentController: controller for  students*/
studentControllerModule.controller('StudentController', function($rootScope, $scope, $location,$routeParams) {
 
    $scope.studentName = "Sandeep Kumar Patel";
    $scope.studentMark = 75;
 
});