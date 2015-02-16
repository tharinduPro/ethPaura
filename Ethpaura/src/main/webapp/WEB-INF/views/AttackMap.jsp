<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://efsavage.com/twitter-bootstrap" prefix="bs"%>

<html>

<head>

<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>Start Bootstrap - SB Admin Version 2.0 Demo</title> <!-- Core CSS - Include with every page -->
		<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
			rel="stylesheet">
			<link
				href="<c:url value="/resources/font-awesome/css/font-awesome.css"/>"
				rel="stylesheet">

				<!-- Page-Level Plugin CSS - Dashboard -->
				<link
					href="<c:url value="/resources/css/plugins/morris/morris-0.4.3.min.css"/>"
					rel="stylesheet">
					<link
						href="<c:url value="/resources/css/plugins/timeline/timeline.css"/>"
						rel="stylesheet">

						<!-- SB Admin CSS - Include with every page -->
						<link href="<c:url value="/resources/css/sb-admin.css"/>"
							rel="stylesheet">


							<link href="<c:url value="/resources/css/style.css"/>"
								rel="stylesheet">

								<c:set var="contextPath"
									value="${pageContext.request.contextPath}" />

								<script
									src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
									
								</script>

								<script>
									function setMarker(arr) {

										var mapProp = {
											center : new google.maps.LatLng(
													6.536980, 81.494541),
											zoom : 10,
											mapTypeId : google.maps.MapTypeId.ROADMAP
										};
										var map = new google.maps.Map(document
												.getElementById("googleMap"),
												mapProp);

										for (var i = 0; i < arr.length; i++) {

											var marker = new google.maps.Marker(
													{
														position : new google.maps.LatLng(
																arr[i].latitute,
																arr[i].longitude),
														map : map,

														title : arr[i].date,

													});
										}

										//	window.alert();

									}

									function initialize() {

										var xmlhttp = new XMLHttpRequest();
										var url = "http://localhost:8080/ethpaura/AttackMapData/";

										xmlhttp.onreadystatechange = function() {
											if (xmlhttp.readyState == 4
													&& xmlhttp.status == 200) {
												var myArr = JSON
														.parse(xmlhttp.responseText);

												setMarker(myArr);
											}
										}
										xmlhttp.open("GET", url, true);
										xmlhttp.send();

										//-----------------------------------------------

									}

									google.maps.event.addDomListener(window,
											'load', initialize);
								</script>
</head>

<body>


<div id="wrapper">

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
	style="margin-bottom: 0; background-color:#066;"> 

		<div class="navbar-header">



			<a class="navbar-brand" href="index.html">
				<img src="<c:url value="/resources/img/logo.png" />" height="35" />
			</a>

			<form:form method="POST" action="search" commandName="timeline">

				<div class="input-group custom-search-form" style="width: 50%; margin-top: 8px; z-index: 100; padding-left: 10px;">
					<form:input path="title" type="text" class="form-control" placeholder="Search..."/>
					<span class="input-group-btn"> 
		
						<button class="btn btn-default" type="submit" style="padding: 9px;">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>

			</form:form>

			<nav class="navbar navbar-default navbar-inverse" role="navigation">
				<div class="container">


				<!-- I don't want it apart of the collapsible portion -->
					<div class="navbar-header pull-right">

						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse navbar-right">

						<div class="navbar-collapse">
							<ul class="nav navbar-nav" style="margin-top: 5px;">

							<!-- /.dropdown -->
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> <i class="fa fa-user fa-lg"></i>
							</a> <ul class="dropdown-menu dropdown-user">
							<li><a href="${contextPath}/PanelPassword"><i
								class="fa fa-user fa-fw"></i> Change Password</a></li>

							<li class="divider"></li>
							<li><a href="<c:url value="/j_spring_security_logout" />"><i
								class="fa fa-sign-out fa-fw"></i> Logout</a></li>
							</ul> <!-- /.dropdown-user --></li>
							<!-- /.dropdown -->
							</ul>
							<!-- /.navbar-top-links -->
						</div>
					</div>
				</div> 
			</nav>


		<!-- /input-group -->

		</div> <!-- /.navbar-header --> 


		<div class="navbar-default navbar-static-side" role="navigation">

		<!-- /.sidebar-collapse -->
		</div> <!-- /.navbar-static-side --> 

	</nav>

	<div id="page-wrapper">
		<div class="row">
		<br> 
<!-- /.col-lg-12 -->
		</div>
<!-- /.row -->
	<div class="row">


		<div class="col-lg-4">
			<div class="panel panel-default">

				<div class="panel-body">

					<div class="prof-back-main">

						<div class="prof-back-wall">

							<h3 class="prof-name">${myprof.fname}${myprof.lname}</h3>
							<h4 class="prof-sub">${myprof.occupation}</h4>

						</div>

						<img src="<c:url value="/img_resources/${myprof.photo}"/>" width="80" class="img-circle img-responsive prof-left" /> <a href="${contextPath}/editProfile"><h5 class="edit">Edit Profile</h5></a>

					</div>


					<ul class="nav" id="side-menu">

						<li><a href="${contextPath}/header" class="list-group-item"> <i
							class="fa fa-comment fa-fw"></i>Home

						</a></li>
						<li><a href="#" class="list-group-item"><i
							class="fa fa-eye fa-fw"></i> Elephant Details<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
						<li><a href="${contextPath}/Elephants" class="list-group-item">
						Elephant Details </a></li>
						<li><a href="${contextPath}/SelectHealthData"
							class="list-group-item"> Health Data </a></li>

						<li><a href="${contextPath}/DeathIncidents" class="list-group-item">
						Death Incidents </a></li>
						<li><a href="${contextPath}/HeathInfo" class="list-group-item">
						Elephant Health Info </a></li>
						</ul> <!-- /.nav-second-level --></li>
						<li><a href="tables.html" class="list-group-item"><i
							class="fa fa-table fa-fw"></i> Attacks <span class="fa arrow"></span></a> <ul
							class="nav nav-second-level">
						<li><a href="${contextPath}/Attacks" class="list-group-item">
						Recent Attacks </a></li>
						<li><a href="${contextPath}/AttackMap" class="list-group-item">
						Attack Area Map </a></li>
						</ul></li>

						<li><a href="#" class="list-group-item"><i
							class="fa fa-wrench fa-fw"></i> Position Maps <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
						<li><a href="${contextPath}/PositionMap" class="list-group-item">
						Position Maps </a></li>
						<li><a href="${contextPath}/SelectPosition" class="list-group-item">
						Position Data </a></li>

						</ul> <!-- /.nav-second-level --></li>

					</ul>

					<!-- /.list-group -->
					<a href="${contextPath}/userProfile" class="btn btn-default btn-block">View
					Profile</a>
				</div>
<!-- /.panel-body -->
			</div>
<!-- /.panel -->



			<div class="chat-panel panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Recent Attacks

				</div>
<!-- /.panel-heading -->
				<div class="panel-body">

					<ul class="chat">

						<c:if test="${!empty attackEleps}">


							<c:forEach items="${attackEleps}" var="re">



									<li class="left clearfix"><span class="chat-img pull-left">
										<img src="<c:url value="/img_resources/${re.getImage()}"/>"
											alt="User Avatar" class="img-circle" width="80px"/>
										</span> 

										<div class="chat-body clearfix">
											<div class="header">
												<strong class="primary-font">${re.getName()}</strong> <small
													class="pull-right text-muted"> <i class="fa fa-clock-o fa-fw"></i>
												${re.getDate()}
												</small>
											</div>
											<p>${re.getDescription()}</p>
										</div>

									</li>





							</c:forEach>

						</c:if>

					</ul>

<!-- /.panel-body -->

<!-- /.panel-footer -->

				</div>

<!-- /.panel-body -->
			</div>

<!-- /.panel .chat-panel -->
		</div>
<!-- /.col-lg-4 -->


				<div class="col-lg-8">
					<div class="panel panel-default">

						<div class="panel-body"></div>

						<div>
							<h2 align="center">Recent Attacks</h2>
							
							<h5>The following map show the latest 10 attacks and their dates</h5>


							<legend></legend>

						</div>


						<div id="googleMap" style="width: 100%; height: 400px;"></div>

						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-8 -->

			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->







	<!-- Core Scripts - Include with every page -->
	<script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugins/metisMenu/jquery.metisMenu.js"/>"></script>

	<!-- Page-Level Plugin Scripts - Dashboard -->
	<script
		src="<c:url value="/resources/js/plugins/morris/raphael-2.1.0.min.js"/>"></script>
	<script src="<c:url value="/resources/js/plugins/morris/morris.js"/>"></script>

	<!-- SB Admin Scripts - Include with every page -->
	<script src="<c:url value="/resources/js/sb-admin.js"/>"></script>

	<!-- Page-Level Demo Scripts - Dashboard - Use for reference -->
	<script src="<c:url value="/resources/js/demo/dashboard-demo.js"/>"></script>


</body>

</html>
