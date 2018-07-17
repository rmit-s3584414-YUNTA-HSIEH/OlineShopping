<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>



<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#modalOrder").click(function(){
		var address=$("#shipAddress").val();
		var phone=$("#phone").val();
		console.log(address,phone);
		$.post("checkOut",{address:address,phone:phone,
			"${_csrf.parameterName}":"${_csrf.token}"});
		window.location.href = "index";
	});
});

</script>
<!-- Modal -->
<div class="modal fade" id="orderDetail" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Order Detail</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<label for="address" class="col-form-label">ship address</label>
				<input type="text" class="form-control" id="shipAddress">
				<label for="phone" class="col-form-label">contact phone</label>
				<input type="text" class="form-control" id="phone">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</div>
				<div class="modal-footer">
				<button id="modalOrder" type="button" class="btn btn-primary" data-dismiss="modal">Submit</button>
				</div>
			</div>
	</div>
</div>
<jsp:include page="header.jsp"/>
<div style="padding:70px">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header bg-dark text-light">
			        	Shipping cart
			            <a href="index" class="btn btn-outline-info btn-sm pull-right">Continue shopping</a>
			        </div>
			        
					<div class="card-body">
						<c:forEach var="cartitems" items="${sessionScope.cart}">
			                    <!-- PRODUCT -->
			      			<div class="row">
			            		<div class="col-12 col-sm-12 col-md-2 text-center">
			                		<img src="<c:url value="/resources/images/2.jpg" />" alt="image" width="120" height="80"/>
			                	</div>
			                	<div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
			                		<h4 class="product-name"><strong>${cartitems.product.title}</strong></h4>
			                	</div>
			                	<div class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
			                		<div class="col-3 col-sm-3 col-md-6 text-md-right" style="padding-top: 5px">
			                        	<h6><strong>${cartitems.product.price} <span class="text-muted">x&nbsp;${cartitems.quantity}&nbsp;=&nbsp;${cartitems.total}</span></strong></h6>
			                    	</div>
			                        <div class="col-2 col-sm-2 col-md-2 text-right">
			                        	<a class="btn btn-outline-danger btn-sm" href="deleteCart?proId=${cartitems.product.proId}" role="button">remove</a>
			                       	</div>
			                 	</div>
			        		</div>
			        		<div class="row">
			        			<div class="col-md-12">
			        			<span><hr style="border:1px dashed #0000fff"/></span>
			        			</div>
			        		</div>
			   			</c:forEach>
					</div>
					<div class="card-footer text-muted">
					<c:set var="total" value="${0}"/>
					<c:forEach var="cartitems" items="${sessionScope.cart}">
					<c:set var="total" value="${total+cartitems.total}"/>
					</c:forEach>
						<div class="row">
							<div class="col-md-6">
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#orderDetail">checkout</a>
							</div>
							<div class="col-md-4">
								<h5 class="text-right text-info">Total:&nbsp;$&nbsp;${total}</h5>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>







	<!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>