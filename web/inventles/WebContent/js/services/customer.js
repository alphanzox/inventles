function Customer($scope, $http) {
   
    $scope.fetch = function(){
    	 $http.get('http://localhost:8080/inventles/rest/cust').
         success(function(data) {
             $scope.customerList = data;
         });    	
    };
    
    $scope.update = function(customer) {
    	$http.post('http://localhost:8080/inventles/rest/cust',customer).success(function(response)
    			  {
    	    $scope.response = response;
    	    $scope.loading = false;
    	    $scope.fetch();
    	  });
      };
      
      $scope.editCustomer = function(customer) {
    	    if (customer === 'new') {
    	      $scope.newCustomer = true;
    	      $scope.customer = {address:'',address2:'',cell:'',city:'',country:'',customerId:'',email:'',firstName:'',lastName:'',phone:'',zip:''};
    	    }
    	    else {
    	      $scope.newCustomer = false;
    	      $scope.customer = customer;
    	      
    	    }
    };
    
    $scope.fetch();
}

