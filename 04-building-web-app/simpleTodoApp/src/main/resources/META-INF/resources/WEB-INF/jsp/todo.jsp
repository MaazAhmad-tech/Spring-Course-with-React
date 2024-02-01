<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link rel="stylesheet" href="webjars\bootstrap\5.3.2\css\bootstrap.min.css">
		<link rel="stylesheet" href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.css">
		<title>Add Todos page</title>
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
			<h1>Add Todo</h1>
			<form:form method="post" modelAttribute = "todo">
				<fieldset class="mb-3">
					<form:label path="description">Description</form:label>
					<form:input type="text" path="description" />
					<form:errors  path="description" cssClass="text-warning" />
				</fieldset>

				<fieldset class="mb-3">
					<form:label path="targetDate">Target Date</form:label>
					<form:input type="text" path="targetDate" />
					<form:errors  path="targetDate" cssClass="text-warning" />
				</fieldset>
				
				<form:input type="hidden" path="done" />
				<form:input type="hidden" path="id" />
				<input type="submit" class="btn btn-success">
			</form:form>
		</div>
		<script src="webjars\bootstrap\5.3.2\js\bootstrap.min.js"></script>
		<script src="webjars\jquery\3.7.1\jquery.min.js"></script>	
		<script src="webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js"></script>
		<script type="text/javascript">
			$('#targetDate').datepicker({
				format: 'dd-mm-yyyy'
			});
		</script>
	</body>
</html>


