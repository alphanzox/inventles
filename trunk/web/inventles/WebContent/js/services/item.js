function Item($scope, $http) {
   
    $scope.fetch = function(){
    	 $http.get('http://localhost:8080/inventles/rest/item').
         success(function(data) {
             $scope.itemList = data;
         });    	
    };
    
    $scope.update = function(item) {
    	$http.post('http://localhost:8080/inventles/rest/item',item).success(function(response)
    			  {
    	    $scope.response = response;
    	    $scope.loading = false;
    	    $scope.fetch();
    	  });
        $scope.master = angular.copy(item);
      };
      
      $scope.editItem = function(item) {
    	  $scope.opts = ['on', 'off'];
    	  
    	    if (item === 'new') {
    	      $scope.newItem = true;
    	      $scope.item = {itemId:'',name:'',type:'',sku:'',maker:''};
    	    }
    	    else {
    	      $scope.newItem = false;
    	      $scope.item = item;
    	      
    	    }
    };
    
    $scope.fetch();
}

