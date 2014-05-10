function Inventory($scope, $http) {
   
    $scope.fetch = function(){
    	 $http.get('http://localhost:8080/inventles/rest/inventory').
         success(function(data) {
             $scope.inventoryList = data;
         });    	
    };
    
    $scope.update = function(inventory) {
    	$http.post('http://192.168.1.2:8080/inventles/rest/inventory',inventory).success(function(response)
    			  {
    	    $scope.response = response;
    	    $scope.loading = false;
    	    $scope.fetch();
    	  });
        $scope.master = angular.copy(inventory);
      };
      
      $scope.editInventory = function(inventory) {
    	  $scope.opts = ['on', 'off'];
    	  
    	    if (inventory === 'new') {
    	      $scope.newInventory = true;
    	      $scope.inventory = {inventoryId:''};
    	    }
    	    else {
    	      $scope.newInventory = false;
    	      $scope.inventory = inventory;
    	      
    	    }
    };
    
    $scope.fetch();
}

