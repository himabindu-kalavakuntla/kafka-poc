
var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/kafka-poc',
    USER_SERVICE_API : 'http://localhost:8080/kafka-poc/get-employees'
    CREATE_USER_SERVICE_API : 'http://localhost:8080/kafka-poc/create-user'

});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'get-employees',
                controller:'EmployeeController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, EmployeeService) {
                        console.log('Load all Employees');
                        var deferred = $q.defer();
                        EmployeeService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);