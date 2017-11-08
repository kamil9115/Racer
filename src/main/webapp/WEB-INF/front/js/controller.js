/**
 * Created by Kamil on 26.07.2017.
 */

var app = angular.module('app', []);

app.controller('controller', function($scope, $http) {

    $scope.getUzytkownik = function() {
        $http.get("http://racer-tim.azurewebsites.net/uzytkownik")
            .then(function(response) {
                $scope.uzytkownikList = response.data;
            });
    }

    $scope.getUzytkownik();

    $scope.getUzytkownikByNazwa = function() {
        $http.get("http://racer-tim.azurewebsites.net/uzytkownik/nazwa?nazwa="+$scope.findUzytkownik.nazwa)
            .then(function(response) {
                $scope.uzytkownikList = response.data;
            });
    }

    $scope.getUzytkownikById = function() {
        $http.get("http://racer-tim.azurewebsites.net/uzytkownik/id?id="+$scope.findUzytkownik.id)
            .then(function(response) {
                $scope.uzytkownikList = response.data;
            });
    }

    var removeFromList = function (list, id) {
        var index = -1;
        for(var i = 0; i < list.length; i++) {
            if(list[i].id == id) {
                index = i;
            }
        }
        if(index != -1) {
            $scope.uzytkownikList.splice(index, 1);
            console.log(index);
        }
    }

    $scope.deleteUzytkownik = function(id) {
        $http.delete("http://racer-tim.azurewebsites.net/uzytkownik?id="+id)
            .then(function() {
                //removeFromList($scope.uzytkownikList, id);
                $scope.getUzytkownik();
            })
            .error(function() {

            });
    }

    $scope.addUzytkownik = function() {
        $http.post("http://racer-tim.azurewebsites.net/uzytkownik?nazwa="+$scope.newUzytkownik.nazwa+"&haslo="+$scope.newUzytkownik.haslo)
            .then(function() {
                alert("yea");
                $scope.newUzytkownik = "";
                //$scope.uzytkownikList.push(response);
                $scope.getUzytkownik();
            })
            .error(function() {

            });
    }
});