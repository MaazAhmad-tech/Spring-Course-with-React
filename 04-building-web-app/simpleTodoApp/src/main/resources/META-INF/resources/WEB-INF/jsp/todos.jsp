<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
	<head>
		<link rel="stylesheet" href="webjars\bootstrap\5.3.2\css\bootstrap.min.css">
		<title>My Todos Page</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-3 p-1">
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
				</ul>
			</div>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>	
		</nav>
		<div class = "container">
			<h1>Your Todos</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items = "${todos}" var = "todo">
						<tr>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
							<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/add-todos" class="btn btn-success">Add</a>
		</div>
		<script src="webjars\bootstrap\5.3.2\js\bootstrap.min.js"></script>
		<script src="webjars\jquery\3.7.1\jquery.min.js"></script>	
	</body>
</html>