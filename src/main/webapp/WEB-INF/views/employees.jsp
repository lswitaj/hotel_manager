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
				<p>All employees</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${employees}" var="employee">
				<div class="col-sm-8 col-md-10" style="padding- bottom: 10px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${employee.name} ${employee.surname}</h3>
							<p>pesel: ${employee.pesel}</p>
							<p>position: ${employee.position}</p>
							<h1>salary: ${employee.salary}PLN</h1>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
