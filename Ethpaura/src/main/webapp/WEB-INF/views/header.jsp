<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://efsavage.com/twitter-bootstrap" prefix="bs"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>EthPaura</title>
<link rel="stylesheet"
      href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
     href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
				href="<c:url value="/resources/css/theme.css"/>">
				
				
				

<link type="text/css"
	href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
	
		<link rel="stylesheet" type="text/css"
			href="<c:url value="/resources/css/bootstrap-responsive.css"/>">
			<link rel="stylesheet" type="text/css"
				href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>">
				
			<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js"/>"></script>



	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>


	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/modal.js"/>"></script>
			
				
				
</head>
<style>
  .bootstrap-demo{margin:0px;}
  
  .dropdown-toggle{
	padding: 0px;
	margin-right: 10px;}
</style>
</head>

<body>
<div class="bootstrap-demo">
  <nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid" style="padding-left: 15%;
padding-right: 15%;">
        <!--Group to be responsive for Handheld Devices-->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse"
                  data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          <img src="<c:url value="/resources/img/log.png"/>" width="45px" height="45px" style="margin-right: 40px;"/>
         
        </div>

      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Link 2</a></li>
            
          </ul>
          <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Search</button>
          </form>
          <ul class="nav navbar-nav navbar-right">
        
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" style="padding: 0px;" data-toggle="dropdown"><img src="<c:url value="/resources/img/profile_image.jpg"/>" width="45" height="45"/><b class="caret"></b></a>
              <ul class="dropdown-menu" role="menu" style="width:260px;">
              
              
                <div class="port-weight">
						<div class="port-weight-head">	
							<div class="img pull-left">			
								<img src="<c:url value="/resources/img/img.png"/>" alt=""/>
							</div>
							<div class="text pull-right">			
								<h3>Arya Stark</h3>
								<p>Winterfell</p>
							</div>
							<div class="clearfix"></div>
						</div>
				</div> 
                <li><a href="#myModal" role="button" class="link" data-toggle="modal"
			>Change Profile Picture</a></li>
                <li><a href="#">View Profile</a></li>
                
                <li class="divider"></li>
                <li><a href="#">Log out</a></li>
             
                        
                        
                        
                        
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    </div>

</body>
</html>
