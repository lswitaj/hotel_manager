<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Rooms</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Rooms</h1>
				<p>All rooms free in chosen period</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${rooms}" var="room">
				<div class="col-sm-10 col-md-15" style="padding-bottom: 10px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${room.roomNumber}</h3>
							<h2>price: ${room.price} PLN</h2>
							<p>size: ${room.size}</p>
							<p> <a href="<spring:url value="/client/pay/room=${room.roomNumber}/first=${dates.firstDay}/last=${dates.lastDay}"/>" class="btn btn-warning">
    							Next <span class="glyphicon-chevron-right glyphicon"/></span>  
							</a> </p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<input type="hidden" name="reservation" value="${reservation}" />
	</section>
</body>
</html>
