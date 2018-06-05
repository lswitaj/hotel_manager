<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Employees</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Employees</h1>
				<p>Best worker</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col-sm-8 col-md-8" style="padding- bottom: 10px">
				<div class="thumbnail">
					<div class="caption">
						<h3>Worker of a moth is:</h3>
						<h2>${employeeOfTheMonth.name} ${employeeOfTheMonth.surname}</h2>
						<p>pesel: ${employeeOfTheMonth.pesel}</p>
						<p>position: ${employeeOfTheMonth.position}</p>
						<h1>salary: ${employeeOfTheMonth.salary}PLN</h1>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
