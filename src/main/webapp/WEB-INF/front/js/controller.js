/**
 * Created by Kamil on 26.07.2017.
 */

var app = angular.module('app', []);

app.controller('controller', function($scope, $http) {

    var getUzytkownikList = function() {
        $http.get("/Racer-1.0/uzytkownik").then(function(response) {
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
        $http.get("/Racer-1.0/uzytkownik/delete/"+id)
            .success(function() {
                removeFromList($scope.uzytkownikList, id);
            })
            .error(function() {

            });
    }

    $scope.addUzytkownik = function() {
        $http.get("/Racer-1.0/uzytkownik/add?nazwa="+$scope.newUzytkownik.nazwa+"&haslo="+$scope.newUzytkownik.haslo)
            .success(function(response) {
                $scope.newUzytkownik = "";
                $scope.uzytkownikList.push(response);
            })
            .error(function() {

            });
    }

    getUzytkownikList();

});