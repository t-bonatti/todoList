angular.module('todoApp', []).controller('TodoController',
		[ '$scope', '$http', function($scope, $http) {

			$scope.loadData = function() {
				$http.get('rest/todo').success(function(data) {
					$scope.todos = data;
				});
			};
			
			$scope.switchStatus = function(todo) {
				$http.post('rest/todo/', todo);
			};
			
			$scope.addTodo = function() {
				$http.put('rest/todo', {
					description : $scope.newTodo,
					done : false
				}).success(function(data) {
					$scope.todos.push(data);
					$scope.newTodo = '';
				});
			};
			
			$scope.removeTodo = function(todo) {
				$http.delete('rest/todo/'+ todo.id).success($scope.loadData);
			};
			
			$scope.loadData();

		}
	]
);