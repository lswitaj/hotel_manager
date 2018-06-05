<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Updating resevation</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Updating resevation</h1>
				<p>Update reservation of id : ${reservation.reservationId}</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col-sm-10 col-md-10" style="padding- bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<center>
							<h3>id:
								${reservation.reservationId}${reservation.clientLogin}</h3>
							<p>first day: ${reservation.firstDay}</p>
							<p>last day: ${reservation.lastDay}</p>
							<p>price: ${reservation.cost}</p>
							<p>Room: ${reservation.roomId}</p>
							
							<p> <a href="<spring:url value="/employee/reservations/${reservation.clientLogin}"/>
								" class="btn btn-info">
      							<span class="glyphicon-chevron-left glyphicon"/></span> Details 
      						</a> </p>
      														
						</center>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
