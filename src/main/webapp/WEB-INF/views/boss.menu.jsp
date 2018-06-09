<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Boss Panel</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Boss Panel</h1>
				<p>Hi boss, what do you want to do now?</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col-sm-8 col-md-4" style="padding-bottom: 10px">
				<div class="thumbnail">
					<div class="caption">
						<h4>Promote employee</h4>
						<p> <a href="<spring:url value="/boss/displayEmployees"/>" class="btn btn-success">
    						<span class="glyphicon-info-sign glyphicon"/></span> Update 
						</a> </p>
					</div>
				</div>
			</div>
			
			<div class="col-sm-8 col-md-4" style="padding-bottom: 10px">
				<div class="thumbnail">
					<div class="caption">
						<h4>Show statistics</h4>
						<p> <a href="<spring:url value="/boss/summary"/>" class="btn btn-success">
    						<span class="glyphicon-info-sign glyphicon"/></span> Display
						</a> </p>
					</div>
				</div>
			</div>
			
			<div class="col-sm-8 col-md-4" style="padding-bottom: 10px">
				<div class="thumbnail">
					<div class="caption">
						<h4>Add new employee</h4>
						<p> <a href="<spring:url value="/boss/addEmployee"/>" class="btn btn-success">
    						<span class="glyphicon-info-sign glyphicon"/></span> Add 
						</a> </p>
					</div>
				</div>
			</div>
			
		</div>
	</section>
</body>
</html>
