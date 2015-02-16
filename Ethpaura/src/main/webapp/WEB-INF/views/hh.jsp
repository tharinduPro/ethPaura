<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://efsavage.com/twitter-bootstrap" prefix="bs"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- HTML5 shim for IE backwards compatibility -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<title>Untitled Document</title>

<link type="text/css"
	href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
<link type="text/css"
	href="<c:url value="/resources/css/bootstrap-responsive.css"/>" rel="stylesheet">
<link type="text/css"
	href="<c:url value="/resources/css/style-start.css"/>" rel="stylesheet">



	
	
</head>

<body>


<div class="container">

<h2 align="center">${rankList.[0].heartbeat}</h2>
				
				
	

</div>


<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js"/>"></script>
		
		<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>


</body>
</html>
