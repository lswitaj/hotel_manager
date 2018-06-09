<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 

<html>
<head>
<meta http-equiv="Content-Type"	content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Registration</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Sign in</h1>
				<p>and be next happy client of our hotel!</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form method="POST" modelAttribute="newClient"
			class="form-horizontal">
			<fieldset>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="login">Login</label>
					<div class="col-lg-10">
						<form:input id="login" path="login" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<form:input id="password" path="password" type="password" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="surname">Surname</label>
					<div class="col-lg-10">
						<form:input id="surname" path="surname" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="phoneNumber">Telephone number</label>
					<div class="col-lg-10">
						<form:input id="phoneNumber" path="phoneNumber" type="tel" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="email">Email address</label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="email" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<a href="<spring:url value="/welcome"/>" class="btn btn-success">
    						<span class="glyphicon-chevron-left glyphicon"/></span> Back 
						</a>
						<input type="submit" id="btnSignIn"
							class="btn btn-primary" value="Sign in" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
