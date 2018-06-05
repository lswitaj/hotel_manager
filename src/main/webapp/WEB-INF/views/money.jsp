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
				<h1>Summary</h1>
				<p>incomes and outcomes of our business</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col-sm-12 col-md-12" style="padding- bottom: 20px">
				<div class="thumbnail">
					<div class="caption">
							<h4>${outcomes}</h4>
       						<h3>sum of sad money to salaries</h3>
					</div>
				</div>
			</div>
			<div class="col-sm-12 col-md-12" style="padding- bottom: 20px">
				<div class="thumbnail">
					<div class="caption">
							<h4>${incomes}</h4>
       						<h3>sum of happy money from reservations</h3>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
