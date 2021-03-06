<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FairDeal</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="Menu/CategoryBarFirst.jsp"></jsp:include>
<script>
document.body.style.backgroundImage = "url('resources/images/header.jpg')";
</script>
<jsp:include page="Menu/CategoryMenu.jsp"></jsp:include> 

<!-- ====================================================================================================== -->

<h3 style="color: white;"><b>
${Message}
${SuccessRegister}
${errorMessage}
</b></h3>

<!-- ====================================================================================================== -->

<c:if test="${isAdmin != true}">
<jsp:include page="Menu/Carousel.jsp"></jsp:include>
</c:if><br><br>&nbsp;&nbsp;



<c:if test="${isUserClickedLogin == true}">
	<jsp:include page="Login.jsp"></jsp:include>
	</c:if>

<c:if test="${isUserClickedRegistration==true}">
	<jsp:include page="Registration.jsp"></jsp:include>
	</c:if>

<c:if test="${UserClickedshowproduct}">
<jsp:include page="/WEB-INF/Views/ShowProduct.jsp"></jsp:include>
</c:if>

<c:choose>
	 <c:when test="${Clickedcatproduct}">
			<c:import url="/WEB-INF/Views/CatProducts.jsp"></c:import>
		</c:when>
	</c:choose> 
	
<!-- ==================================================================================================== -->

				<c:if test="${isUserClickedCart != true}">
<c:if test="${empty LoggedIn}">
		<c:choose>
			<c:when test="${!isAdmin}">
				<c:if test="${!empty productList}">
					<div id="product">
						<!-- <ul> -->
						<div class="row" id="product"
							style="padding-top: 20px; padding-botton: 20px; padding-left: 20px; padding-bottom: 20px;">
							<!-- <h3 style="margin-left: 15px">Latest Products</h3> -->
							<c:forEach items="${productList}" var="product">
								<div class="col-xs-2 w3-animate-zoom">
									<div class="img" style="margin: 5px">
										<a href="ShowProduct/${product.id}"> <img height="192px"
							                                width="192px" alt="${product.id}"
							src="<c:url value="/resources/images/${product.id}.jpg"></c:url>"></a>
							<c:url var="action" value="addtoCart/${userid}/${product.id}"></c:url>
							<form:form action="${action}" modelAttribute="cart">
								<td id="td1"><c:out value="${product.name}" /><br>
								<td id="td1"><c:out value="${product.price}" /> 								
								<input type="submit" class="btn btn-primary" value="Add To Cart"/><br>
							</form:form>
							</div>
								</div>
							</c:forEach>
						</div>
						<!-- </ul> -->
					</div>
					</c:if>
					</c:when>
					</c:choose>
					</c:if>
					</c:if>
		
	
 <br>
 <br>
              <!------------------------------------ Starting of Footer ------------------------------------->

<nav class="navbar navbar-inverse">
  <div class="container-fluid">

<footer>
    <div class="footer" id="footer">
    
        <div class="container">
            <div class="row">
               <div class="col-lg-3 col-md-3">
                <ul class="list-unstyled clear-margins">
                <li class="widget-container widget_nav_menu">
                    
                    <h3 style="color: white;"><b> Get to Know Us </b></h3>
                    
                       <a href="#"> About Us </a><br>
                        <a href="#"> Careers </a><br> 
                         <a href="#"> Press Releases </a><br>
                         <a href="#"> FairDeal Cares </a><br>
                          <a href="#"> Gift a Smile </a>
                          </li></ul>
                </div>
                
                 <div class="col-lg-3 col-md-3">
                <ul class="list-unstyled clear-margins">
                <li class="widget-container widget_nav_menu">
                    
                    <h3 style="color: white;"><b> Policy Info </b></h3>
                    
                       <a href="#"> Privacy Policy </a><br>
                        <a href="#"> Terms of Sale </a><br> 
                         <a href="#"> Terms of Use </a><br>
                         
                          </li></ul>
                </div>
                
                  <div class="col-lg-3 col-md-3">
                <ul class="list-unstyled clear-margins">
                <li class="widget-container widget_nav_menu">
                
                 <h3 style="color: white;"><b> Let Us Help You </b></h3>
                    
                       <a href="#"> Your Account </a><br>
                        <a href="#"> Returns Centre </a><br> 
                         <a href="#"> 100% Purchase Protection </a><br>
                         <a href="#"> FairDeal Assistant </a><br>
                          <a href="#"> Help </a>
                          </li></ul>
                </div>
                
                
                 <div class="col-lg-3 col-md-3">
                  <ul class="list-unstyled clear-margins">
                  <li class="widget-container widget_recent_news">
                    
                  <h3 class="title-widget"><b style="color: white;">Contact Detail </b></h3>
                                
                   <div class="footerp"> 
                                
                   <h2 class="title-median" style="color: white;"><font style="border-bottom-style: double;">FairDeal Pvt. Ltd.</font></h2>
                                <p><b style="color: white;">Email id:</b> <a href="#">FairDeal@gmail.com</a></p>
                                <p><b style="color: white;">Helpline Numbers </b>
         <b style="color:#ffc106;">(10AM to 10PM):</b><br><b style="color: white;">  +91-0987654321, +91-1234567890 </b></p>
    
                    <p><b style="color: white;">Corp Office / Postal Address</b></p>
                     <p><b style="color: white;">Phone Numbers : 1234567890, </b></p>
                      <p><b style="color: white;"> 011-12345678, 1234567890</b></p>
                        </div>
                                
                <div class="social-icons">                                    
                <a href="https://www.facebook.com"><i class="fa fa-facebook-square fa-2x" id="social"></i></a>
	            <a href="https://twitter.com"><i class="fa fa-twitter-square fa-2x" id="social"></i></a>
	            <a href="https://plus.google.com"><i class="fa fa-google-plus-square fa-2x" id="social"></i></a>
	            <a href="#"><i class="fa fa-envelope-square fa-2x" id="social"></i></a>
                 </div>             
                 </ul>
                 </div>
                 </div>
                </div>
                 </div>
               </footer><hr>
    <div class="footer-bottom">
        <div class="container">
            <p class="pull-left" style="color: white;"> Copyright � 2018. FairDeal Pvt Ltd. All Rights Reserved. </p>
            <div class="pull-right">
                <ul class="nav nav-pills payments" style="color: white;">
                	<li><i class="fa fa-cc-visa"></i></li>
                    <li><i class="fa fa-cc-mastercard"></i></li>
                    <li><i class="fa fa-cc-amex"></i></li>
                    <li><i class="fa fa-cc-paypal"></i></li>
                </ul>  
            </div>
   </div>
   </div>
   </div>
   </nav>
                                
                   <!------------------------------------ Ending of Footer ------------------------------------->
</body>
</html>
