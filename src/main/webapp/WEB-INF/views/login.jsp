<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
    <body> 
    <jsp:include page="header.jsp"/>
    <div style="padding:150px 100px 10px">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6"> 
      				<div class="card">
      					<div class="card-header"><h3><strong>Sign In</strong></h3></div>
						<div class="card-body">
	                        <c:url var="loginUrl" value="/login" />  
	                        <form action="login" method="post" class="form-horizontal">  
	                            <c:if test="${param.error != null}">  
	                                <div class="alert alert-danger">  
	                                    <p>Invalid username and password.</p>  
	                                </div>  
	                            </c:if>  
	                            <c:if test="${param.logout != null}">  
	                                <div class="alert alert-success">  
	                                    <p>You have been logged out successfully.</p>  
	                                </div>  
	                            </c:if>
	                            <div class="form-group">  
	                                <label for="username"></label>  
	                                <input type="text" class="form-control" id="username" name="userName" placeholder="Enter Username" required>  
	                            </div>  
	                            <div class="form-group">  
	                                <label for="password"></label>   
	                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>  
	                            </div>  
	                            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />  
	                                   
								<div class="row">
								<div class="col-md-3">
	                                <button type="submit" class="btn btn-primary">Login</button>
	                             </div>
	                             <div class="col-md-3">
	                             <div class="text-center">
	                             	<a href="newUser">Register</a> 
	                             </div>
	                             </div> 
	                   			</div>
	                  		</form> 
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