
'use strict';

var youTube = angular.module('youTube');

youTube.controller('ApplicationController',function($scope){

});

youTube.controller('SearchController',function($scope, $http, $modal, usSpinnerService){
	  
	$scope.searchForm= {
				from : '',
				to : new Date(),
				channel:"",
				searchKeyWord : "",
				searchBy : "",
				searchUrl:""
	}
	
	$scope.sortBy = 'Sort By';
	
	$scope.submitSearch = function() {
		usSpinnerService.spin('loading...');
		$http.get('/', {params:$scope.searchForm})
		.success(function(data, status, headers, config){
			    console.log(data);
			    //$('#generatedFileName').text(data+' Successfully generated!');
				usSpinnerService.stop('loading...');
		});
	}
	 

});
