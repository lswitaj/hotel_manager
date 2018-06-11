<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Make a reservation</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Chose date</h1>
				<h4>Type date in format: DD-MM-YYYY</h4>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form class="form-horizontal" modelAttribute="reservation" >
			<fieldset>
				<legend>First day</legend>

				<div class="form-group">
					<div class="col-lg-10">
						<fmt:formatDate value="${reservation.firstDay}" pattern="dd-MM-yyyy" var="myDate" />
						<form:input path="firstDay" id="firstDay" value="${myDate}" class="form:input-large"/>
					</div>
				</div>

				<legend>Last day</legend>

				<div class="form-group">
					<!-- <label class="control-label col-lg-2" for="name">Name</label> -->
					<div class="col-lg-10">						
						<fmt:formatDate value="${reservation.lastDay}" pattern="dd-MM-yyyy" var="myDate" />
						<form:input path="lastDay" id="lastDay" value="${myDate}" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<a href="<spring:url value="/client/myReservations"/>"
							class="btn btn-default"><span
							class="glyphicon glyphicon-chevron-left" /></span> Cancel </a>
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Next"/>
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
