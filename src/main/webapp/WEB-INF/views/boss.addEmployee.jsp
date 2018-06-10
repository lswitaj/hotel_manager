<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 

<form:errors path="*" cssClass="alert alert-danger" element="div"/>

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
				<p>Add new employee</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form method="POST" modelAttribute="newEmployee"
			class="form-horizontal">
			<fieldset>
				<legend>Add new employee</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="pesel">Employee pesel</label>
					<div class="col-lg-10">
						<form:input id="pesel" path="pesel" type="text" class="form:input-large" />
						<form:errors path="pesel" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<form:input id="password" path="password" type="password" class="form:input-large" />
						<form:errors path="password" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large" />
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="surname">Surname</label>
					<div class="col-lg-10">
						<form:input id="surname" path="surname" type="text" class="form:input-large" />
						<form:errors path="surname" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="position">position</label>
					<div class="col-lg-10">
						<form:radiobutton path="position" value="intern" />
						intern
						<form:radiobutton path="position" value="receptionist" />
						receptionist
						<form:radiobutton path="position" value="manager" />
						manager
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="phoneNumber">Telephone number</label>
					<div class="col-lg-10">
						<form:input id="phoneNumber" path="phoneNumber" type="tel" class="form:input-large" />
						<form:errors path="phoneNumber" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="email">Email address</label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="email" class="form:input-large" />
						<form:errors path="email" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="salary">Salary</label>
					<div class="col-lg-10">
						<form:input id="salary" path="salary" type="number" class="form:input-large" />
						<form:errors path="salary" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<a href="<spring:url value="/boss/menu"/>" class="btn btn-success">
    						<span class="glyphicon-chevron-left glyphicon"/></span> Back 
						</a>
						<input type="submit" id="btnAdd"
							class="btn btn-primary" value="Add" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
