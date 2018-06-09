<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
				<p>Choose client to display its reservations</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-6" style="padding-bottom: 10px">
				<form:form method="POST" modelAttribute="client"
					class="form-horizontal">
					<fieldset>
						<legend>Type login of chosen client</legend>

						<div class="form-group">
							<label class="control-label col-lg-2" for="login">Login</label>
							<div class="col-lg-2">
								<form:input id="login" path="login" type="text"
									class="form:input-large" />
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
