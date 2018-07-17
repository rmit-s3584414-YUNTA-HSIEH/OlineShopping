<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"/>
<script>
/*
$(function(){
	
	$("#addToCart").click(function(){
		var quantity= $("#quantity").val();	
		console.log(quantity);
		$.ajax({
			url:"addToCart",
			data:{
				quantity:$("#quantity").val()
			}
		});
	});
	
});
*/
$(function(){
	var quantity=0;
	var inventory=parseInt("${productDetail.inventory}");
	$("#plus").click(function(e){
		
		// Stop acting like a button
        e.preventDefault();
		var quantity=parseInt($("#quantity").val());
		if(quantity<inventory){
		$("#quantity").val(quantity+1);
		}
		//
	});
	
	$("#reduce").click(function(e){
		
		// Stop acting like a button
        e.preventDefault();
		
		var quantity=parseInt($("#quantity").val());
		
		if(quantity>1){
			$("#quantity").val(quantity-1);
		}
		
	})
	
});

</script>
<div style="padding:40px"></div>
	<div class="container ">
		<div class="row">
			<div class="col-md-3">
			<img src="<c:url value="/resources/images/2.jpg" />" alt="image" />

			</div>
			<c:set var="productItems" value="${productDetail}"/>
			<div class="col-md-9">
				<div class="card bg-light">
					<div  class="card-title m-1 p-1"><h5><strong>Product Name: ${productItems.title}</strong></h5></div>
					<div  class="card-text text-success m-1 p-1"><h4><strong>Price: $${productDetail.price}</strong></h4></div>
					<div  class="card-text m-auto p-2">Detail:${productDetail.descript}</div>
					<hr style="border:1px dashed #0000fff"/>
					
					<div class="row">
						<div class="col-md-3">
							<div class="btn-group m-3 p-1" role="group">
								<button id="reduce" type="button" class="btn btn-primary btn-md">-</button>
								 <input type="number" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="${productDetail.inventory}">
								<button id="plus" type="button" class="btn btn-primary btn-md">+</button>
								
							</div>
							<p><strong><small class="text-muted m-3 p-1">數量:&nbsp;${productDetail.inventory}&nbsp;件</small></strong></p>
						</div>
						<div class="col-md-3  m-3 p-1">
						
						<a id="addToCart" href='' onclick="this.href='addToCart?proId=${productDetail.proId}&quantity='+document.getElementById('quantity').value" class="btn btn-primary btn-md">Add to cart</a>
						</div>
						<div class="col-md-3 m-3 p-1">
							<a href="index" class="btn btn-danger btn-md">back to shopping</a>
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