<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">


<style>
	.card{
	    height: 400px;
	}


</style>

</head>
<body>
<jsp:include page="header.jsp"/>
	
	 <div style="padding:70px">
		<div class="container">
		<div class="card-columns">
		<c:forEach var="tempProduct" items="${products}">
						<div class="card text-center" style="width: 20rem;">								
							<a id="${tempProduct.proId}" class="productPage" href="productPage?proId=${tempProduct.proId}"><img src="<c:url value="/resources/images/2.jpg" />" alt="image" /></a>
							<div class="card-body">
								<h6 class="card-title  text-truncate">${tempProduct.title}</h6>
							</div>
							<div class="row">
								<div class="col-xs-12 col-md-6">
                            		<p class="text-danger"><strong>&nbsp;&nbsp;$&nbsp;${tempProduct.price}</strong></p>                  
                        		</div>
                        		<div class="col-xs-12 col-md-6">
                            		<a id="${tempProduct.proId}" class="btn btn-success" href="productPage?proId=${tempProduct.proId}">More....</a>
                        		</div>
							</div>							
						</div>
		</c:forEach>		
		</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
