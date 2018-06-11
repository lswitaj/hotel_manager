<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
				<p>Chose which reservation you want to edit</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${reservations}" var="reservation">
				<div class="col-sm-6 col-md-6 panel" style="padding- bottom: 15px">
					<div class="thumbnail">

						<c:choose>
							<c:when
								test="${(reservation.status == 'before')
								or (reservation.status == 'during')}">
								<div class="caption" style="background-color: lightgreen">
							</c:when>

							<c:otherwise>
								<div class="caption" style="background-color: #ff9999">
							</c:otherwise>
						</c:choose>
						<h3>id:
							${reservation.reservationId}${reservation.clientLogin}</h3>

						<p>
							first day:
							<fmt:formatDate value="${reservation.firstDay}"
								pattern="dd MMM yyyy" />
						</p>
						<p>
							last day:
							<fmt:formatDate value="${reservation.lastDay}"
								pattern="dd MMM yyyy" />
						</p>

						<p>price: ${reservation.cost} PLN</p>
						<p>Room: ${reservation.roomId}</p>

						<c:choose>
							<c:when
								test="${(reservation.status == 'before')
											or (reservation.status == 'during')}">
								<p>
									<a
										href="<spring:url value="/employee/editReservation/id=${reservation.reservationId}"/>"
										class="btn btn-info"> Edit <span
										class="glyphicon-pencil glyphicon" /></span>
									</a>
								</p>
							</c:when>
						</c:choose>
					</div>
				</div>
		</div>
		</c:forEach>
		</div>
	</section>
</body>
</html>
