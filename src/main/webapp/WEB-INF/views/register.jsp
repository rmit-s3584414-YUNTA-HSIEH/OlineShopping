<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<title>Register</title>
	<style>
	 	.error{color:red}
	</style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div style="padding:150px 100px 10px">		
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6"> 
	      		<div class="card">
	      			<div class="card-header"><h3><strong>Sign up</strong></h3></div>
					<div class="card-body">
						<form:form action="saveUser" modelAttribute="newUser" method="post" class="form-horizontal">
							<div class="form-group">
								         <label for="userName">userName：</label>
								         <form:input path="userName" type="text" class="form-control"/>
								         <span><form:errors path="userName" cssClass="error" /></span>
							</div>
							<div class="form-group">
								         <label for="passwrod">password：</label>
								         <form:input path="password" class="form-control"/>
								         <span><form:errors path="password" cssClass="error" /></span>
							</div>
							<div class="form-group">
								       <label for="email">Email：</label>
								         <form:input path="email" class="form-control"/>
								         <span><form:errors path="email" cssClass="error" /></span>
							</div>
							<div class="form-group">
								       <label for="address">address:<small class="text-muted"> (optional)</small></label>
								         <form:input path="address" class="form-control"/>
								         <span><form:errors path="address" cssClass="error" /></span>
							</div>
							<button type="submit" class="btn btn-outline-success">Save</button>
						</form:form>
			  		</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>