function Employee($scope, $http) {
   
    $scope.fetch = function(){
    	 $http.get('http://localhost:8080/inventles/rest/emp').
         success(function(data) {
             $scope.employeeList = data;
         });    	
    };
    
    $scope.update = function(employee) {
    	$http.post('http://localhost:8080/inventles/rest/emp', employee).success(function(response)
    			  {
    	    $scope.response = response;
    	    $scope.loading = false;
    	    $scope.fetch();
    	  });
      };
      
      $scope.editEmployee = function(employee) {
    	    if (employee === 'new') {
    	      $scope.newEmployee = true;
    	      $scope.employee = {address:'',address2:'',cell:'',city:'',country:'',employeeId:'',email:'',firstName:'',lastName:'',phone:'',zip:''};
    	    }
    	    else {
    	      $scope.newEmployee = false;
    	      $scope.employee = employee;
    	      
    	    }
    };
    
    $scope.fetch();
}

