'use strict';

/**
 * @ngdoc function
 * # MainCtrl
 */
angular.module('BootstrapApplication')
    .controller('MainCtrl', ['$scope', '$interval', '$http', function ($scope, $interval, $http) {

        $scope.stopTime = {};

        $scope.measurements = [];

        $scope.autoUpdate = {
            on: 0
        };

        $scope.$watch('autoUpdate.on', function (autoUpdate) {
            console.log(autoUpdate);

            if (autoUpdate == "0") {
                $interval.cancel($scope.stopTime);

            } else {
                // clear measurements
                $scope.measurements = [];

                $scope.stopTime = $interval(function () {
                    $scope.getLatest();
                }, 1000);
            }

        });

        $scope.getLatest = function () {
            $scope.fetchLatestMeasurement().then(function (measurement) {
                console.log(measurement);

                $scope.measurements.push(measurement.data);

            });
        };

        $scope.fetchLatestMeasurement = function () {
            return $http.get('/measurements/latest');
        };

    }]);
