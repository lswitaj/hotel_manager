<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 

<html>
<head>
<meta http-equiv="Content-Type"	content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Boss Panel</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Boss Panel</h1>
				<p>Give an increment or promote ones</p>
			</div>
		</div>
	</section>
	<section class="container">
	
		<div class="row">
				<div class="col-sm-6 col-md-6" style="padding-bottom: 10px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${actualEmployee.name} ${actualEmployee.surname}</h3>
							<p>pesel: ${actualEmployee.pesel}</p>
							<p>actual position: ${actualEmployee.position}</p>
							<h1>actual salary: ${actualEmployee.salary}PLN</h1>
						</div>
					</div>
				</div>

			<div class="col-sm-4 col-md-6" style="padding- bottom: 10px">
		<form:form method="POST" modelAttribute="actualEmployee"
			class="form-horizontal">
			<fieldset>
				<legend>Give a payrise or promote ${actualEmployee.name}</legend>

				<div class="form-group">
					<label class="control-label col-lg-2" for="newPosition">New position</label>
					<div class="col-lg-2">
						<form:radiobutton path="position" value="intern" />
						intern
						<form:radiobutton path="position" value="receptionist" />
						receptionist
						<form:radiobutton path="position" value="manager" />
						manager
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="salary">New salary</label>
					<div class="col-lg-2">
						<form:input id="salary" path="salary" type="number" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-2">
						<a href="<spring:url value="/boss/bossPanel"/>" class="btn btn-success">
    						<span class="glyphicon-chevron-left glyphicon"/></span> Cancel </a>
    					
						<input type="submit" id="btnAdd"
							class="btn btn-primary" value="Update" />
					</div>
				</div>
			</fieldset>
		</form:form>
		</div>
		</div>
	</section>
</body>
</html>
