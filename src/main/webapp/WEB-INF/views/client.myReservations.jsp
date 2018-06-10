<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="date" class="java.util.Date" />

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
				<p>
					<a href="<spring:url value="/logout"/>"
						class="btn btn-info pull-right"> Logout </a>
				</p>
				<h1>All your reservations</h1>
				<p>Look at the history or visit us again!</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="table-responsive">
			<table class="table table-striped table-bordered text-center">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Status</th>
						<th scope="col">Cost</th>
						<th scope="col">First day</th>
						<th scope="col">Last day</th>
						<th scope="col">Board</th>
						<th scope="col">Room number</th>
						<!-- <th>Size</th>  -->
					</tr>
				</thead>
				<c:forEach items="${reservations}" var="reservation">
					<tr>
						<td>${reservation.reservationId}</td>
						<td>${reservation.status}</td>
						<td>${reservation.cost}PLN</td>
						<td><fmt:formatDate value="${reservation.firstDay}"
								pattern="dd MMM yyyy" /></td>
						<td><fmt:formatDate value="${reservation.lastDay}"
								pattern="dd MMM yyyy" /></td>
						<td>${reservation.board}</td>
						<td>${reservation.roomId}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<p>
			<a href="<spring:url value="/client/makeReservation"/>"
				class="btn btn-success pull-right"> Make a next reservation <span
				class="glyphicon-chevron-right glyphicon" /></span>
			</a>
		</p>

	</section>
</body>
</html>
