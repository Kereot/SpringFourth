angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.changePrice = function (productId, cost) {
        $http({
            url: contextPath + '/products/change_cost',
            method: 'GET',
            params: {
                productId: productId,
                cost: cost
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.addProduct = function (newProductId, newProductName, newProductCost) {
        $http({
            url: contextPath + '/products/add',
            method: 'GET',
            params: {
                newProductId: newProductId,
                newProductName: newProductName,
                newProductCost: newProductCost
            }
        }).then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.loadProducts();
});