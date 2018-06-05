<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Reservations</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Reservations</h1>
				<p>All reservations made so far in our hotel #fuckRODO</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${reservations}" var="reservation">
				<div class="col-sm-6 col-md-3" style="padding- bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${reservation.clientLogin}</h3>
							<p>first day: ${reservation.firstDay}</p>
							<p>last day: ${reservation.lastDay}</p>
							<p>price: ${reservation.cost}</p>
							<p>Room: ${reservation.roomId}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
