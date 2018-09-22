

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="springs" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

<nav class="navbar navbar-default">
  <div class="container-fluid">
  
    <ul class="nav navbar-nav">
      <li><a href="../temp"><img src="<c:url value="/resources/images/ShoppingCartPic.jpg"></c:url>" alt="ShoppingCartPic" width="60px" height="60px" align="left"> </a>
        </ul>
        
        <ul class="nav navbar-nav">
       <li> <h3><b>AliExpress</b><small> <br> 
		Smarter Shopping,Better Living</small></h3>
		</li>
		</ul>
		
		<form class="navbar-form navbar-right">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
		
		 <ul class="nav navbar-nav navbar-right">
      <li><a href="../HomePage"><b>Home </b><span class="glyphicon glyphicon-home"></span> </a>
        </ul>
		
		 <div class="container">
    <ul class="nav navbar-nav navbar-right">
     <security:authorize access="!isAuthenticated()">
      <li><a href="../login"><b>Login </b><span class="glyphicon glyphicon-user"></span> </a>
      <li><a href="../Registration"><b>New Customer? Register Here </b><span class="glyphicon glyphicon-log-in"></span> </a>
      </li>
      </security:authorize>
        </ul>
      
    <ul class="nav navbar-nav navbar-right">
    <security:authorize access="isAuthenticated()">
    <li><a href="../perform_logout"><b>Logout </b><span class="glyphicon glyphicon-log-out"></span></a>
    </li>

    <li class="nav navbar-nav">
    <li style="float: right"><a href="../Cart" class="w3-hover-none w3-text-sand w3-hover-text-white"><b>MyCarts </b>
  <i class="fa fa-shopping-cart"></i> <span class="w3-badge w3-white"></span></a></li>
    </security:authorize>
    </ul>
    </div>
		

</div>
 </nav>



    
</nav>
<div style="color:red">${msg}</div>
<br/>
	<h1>Address Form</h1>
	<springs:form action="${contextRoot}/addAddress" method="post" modelAttribute="addressObj">
  	<div class="form-group">
    <label for="houseNumber">House Number:</label>
    <springs:input type="text" class="form-control" path="houseNumber"/>
  	</div>
    <div class="form-group">
    <label for="locality">Locality:</label>
    <springs:input type="text" class="form-control" path="locality"/>
  	</div>
  	<div class="form-group">
    <label for="city">City:</label>
    <springs:input type="text" class="form-control" path="city"/>
  	</div>
  	<div class="form-group">
    <label for="state">State:</label>
    <springs:input type="text" class="form-control" path="state"/>
  	</div>
  	<div class="form-group">
    <label for="pinCode">Pincode:</label>
    <springs:input type="text" class="form-control" path="pinCode"/>
  	</div>
   <button type="submit" class="btn btn-default">Add Address</button>
</springs:form>
</div>


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
                         <a href="#"> Report Abuse and Takedown Policy </a><br>
                          <a href="#"> CSR Policy </a>
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
         <b style="color:#ffc106;">(8AM to 10PM):</b><br><b style="color: white;">  +91-0987654321, +91-1234567890 </b></p>
    
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
            <p class="pull-left" style="color: white;"> Copyright © 2018. FairDeal Pvt. Ltd. All Rights Reserved. </p>
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
