<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
		<form:form modelAttribute="reservation" class="form-horizontal">
			<fieldset>
				<legend>First day</legend>

				<div class="form-group">
					<!-- <label class="control-label col-lg-2" for="name">Name</label> -->
					<div class="col-lg-10">
						<form:input id="firstDay" path="firstDay" type="text"
							class="form:input-large" />
					</div>
				</div>

				<legend>Last day</legend>

				<div class="form-group">
					<!-- <label class="control-label col-lg-2" for="name">Name</label> -->
					<div class="col-lg-10">						
						<form:input id="lastDay" path="lastDay" type="text"
							class="form:input-large" />
					</div>
				</div>

				<input type="hidden" name="_flowExecutionKey"
					value="${flowExecutionKey}" />

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Next" name="_eventId_chosenDate" />
						<button id="btnCancel" class="btn btn-default"
							name="_eventId_cancel">Cancel</button>
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
