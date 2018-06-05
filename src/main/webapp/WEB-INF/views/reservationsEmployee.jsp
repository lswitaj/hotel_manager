<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Updating reservations</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Updating reservations</h1>
				<p>Chose which reservation you want edit</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${reservations}" var="reservation">
				<div class="col-sm-6 col-md-6 panel" style="padding- bottom: 15px">
					<div class="thumbnail">

						<c:choose>
							<c:when test="${(reservation.status == 'before')
								or (reservation.status == 'during')}">
								<div class="caption", style="background-color: lightgreen">
							</c:when>
							
							<c:otherwise>
								<div class="caption", style="background-color: #ff9999">
							</c:otherwise>
						</c:choose>
								<center>
									<h3>id: ${reservation.reservationId}${reservation.clientLogin}</h3>
									<p>first day: ${reservation.firstDay}</p>
									<p>last day: ${reservation.lastDay}</p>
									<p>price: ${reservation.cost}</p>
									<p>Room: ${reservation.roomId}</p>

									<c:choose>
										<c:when test="${(reservation.status == 'before')
											or (reservation.status == 'during')}">
											<p> <a href="<spring:url value="/employee/reservation?id=${reservation.reservationId}"/>
													" class="btn btn-primary">
      											<span class="glyphicon-info-sign glyphicon"/></span> Details 
      										</a> </p>
										</c:when>
									</c:choose>
									
								</center>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
