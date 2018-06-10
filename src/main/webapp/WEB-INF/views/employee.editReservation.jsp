<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form:errors path="*" cssClass="alert alert-danger" element="div"/> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Updating reservation</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Updating reservation</h1>
				<p>Update reservation of id : ${reservation.reservationId}</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-6" style="padding-bottom: 10px">
				<div class="thumbnail">
					<div class="caption">
						<h3>id:
							${actualReservation.reservationId}${actualReservation.clientLogin}</h3>
						<p>
							first day:
							<fmt:formatDate value="${actualReservation.firstDay}"
								pattern="dd MMM yyyy" />
						</p>
						<p>
							last day:
							<fmt:formatDate value="${actualReservation.lastDay}"
								pattern="dd MMM yyyy" />
						</p>
						<p>price: ${actualReservation.cost} PLN</p>
						<p>Room: ${actualReservation.roomId}</p>
						<p>Board: ${actualReservation.board}</p>
						<p>Status: ${actualReservation.status}</p>
					</div>
				</div>
			</div>

			<div class="col-sm-6 col-md-6" style="padding-bottom: 10px">
				<form:form method="POST" modelAttribute="actualReservation"
					class="form-horizontal">
					<fieldset>
						<legend>Change reservation parameters</legend>

						<!--<form:input type="hidden" path="reservationId" value="reservationId" />-->

						<div class="form-group">
							<label class="control-label col-lg-2" for="newCost">Cost</label>
							<div class="col-lg-2">
								<form:input id="cost" path="cost" type="number"
									class="form:input-large" />
								<form:errors path="cost" cssClass="text-danger"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-lg-2" for="newBoard">Board</label>
							<div class="col-lg-2">
								<form:radiobutton path="board" value="true" />
								yes
								<form:radiobutton path="board" value="false" />
								no
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-lg-2" for="newStatus">Status</label>
							<div class="col-lg-2">
								<form:radiobutton path="status" value="after" />
								after
								<form:radiobutton path="status" value="during" />
								during
								<form:radiobutton path="status" value="before" />
								before
								<form:radiobutton path="status" value="canceledSystem" />
								canceledSystem
								<form:radiobutton path="status" value="canceledClient" />
								canceledClient
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-2">
								<input type="submit" id="btnAdd" class="btn btn-primary"
									value="Update" />
							</div>
						</div>

					</fieldset>
				</form:form>
			</div>
		</div>
	</section>
</body>
</html>
