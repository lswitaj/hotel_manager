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
				<h1>Summary of your reservation</h1>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-6" style="padding-bottom: 10px">
				<div class="thumbnail">
					<div class="caption">
						<h3>id:
							${reservation.reservationId}</h3>
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
						<p>Board: ${reservation.board}</p>
						<p>Status: ${reservation.status}</p>
						<p>User: ${reservation.clientLogin}</p>
					</div>
				</div>
			</div>
	</section>
</body>
</html>
