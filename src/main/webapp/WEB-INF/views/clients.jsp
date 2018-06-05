<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Clients</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Clients</h1>
				<p>Client with the name elkowicz123</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${clients}" var="client">
				<div class="col-sm-18 col-md-6" style="padding- bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${client.name} ${client.surname}</h3>
							<p>login: ${client.login}</p>
							<p>pass: ${client.password}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
