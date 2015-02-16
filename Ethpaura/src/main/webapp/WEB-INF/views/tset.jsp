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

<title>Start Bootstrap - SB Admin Version 2.0 Demo</title>
<!-- Core CSS - Include with every page -->
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


<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">


<!-- load angular -->
<script type="text/javascript"
	src="<c:url value="/resources/js/angular.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/app.js"/>"></script>
</head>

<body ng-app="validationApp" ng-controller="mainController">

	<div id="wrapper">

		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
			style="margin-bottom: 0; background-color:#066;">
		<div class="navbar-header">



			<a class="navbar-brand" href="index.html"><img
				src="<c:url value="/resources/img/logo.png" />" height="35" /></a>
			<div class="input-group custom-search-form"
				style="width: 50%; margin-top: 8px; z-index: 100;">
				<input type="text" class="form-control" placeholder="Search..."
					style="margin-left: 10px;"> <span class="input-group-btn">
					<button class="btn btn-default" type="button">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>

			<nav class="navbar navbar-default navbar-inverse" role="navigation">
			<div class="container">


				<!-- I don't want it apart of the collapsible portion -->
				<div class="navbar-header pull-right">

					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse navbar-right">

					<div class="navbar-collapse">
						<ul class="nav navbar-nav">

							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> <i
									class="fa fa-envelope fa-lg"></i>
							</a>
								<ul class="dropdown-menu dropdown-messages">
									<li><a href="#">
											<div>
												<strong>John Smith</strong> <span
													class="pull-right text-muted"> <em>Yesterday</em>
												</span>
											</div>
											<div>Lorem ipsum dolor sit amet, consectetur adipiscing
												elit. Pellentesque eleifend...</div>
									</a></li>
									<li class="divider"></li>
									<li><a href="#">
											<div>
												<strong>John Smith</strong> <span
													class="pull-right text-muted"> <em>Yesterday</em>
												</span>
											</div>
											<div>Lorem ipsum dolor sit amet, consectetur adipiscing
												elit. Pellentesque eleifend...</div>
									</a></li>
									<li class="divider"></li>
									<li><a href="#">
											<div>
												<strong>John Smith</strong> <span
													class="pull-right text-muted"> <em>Yesterday</em>
												</span>
											</div>
											<div>Lorem ipsum dolor sit amet, consectetur adipiscing
												elit. Pellentesque eleifend...</div>
									</a></li>
									<li class="divider"></li>
									<li><a class="text-center" href="#"> <strong>Read
												All Messages</strong> <i class="fa fa-angle-right"></i>
									</a></li>
								</ul> <!-- /.dropdown-messages --></li>
							<!-- /.dropdown -->

							<!-- /.dropdown -->
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-lg"></i>
							</a>
								<ul class="dropdown-menu dropdown-alerts">
									<li><a href="#">
											<div>
												<i class="fa fa-comment fa-fw"></i> New Comment <span
													class="pull-right text-muted small">4 minutes ago</span>
											</div>
									</a></li>
									<li class="divider"></li>
									<li><a href="#">
											<div>
												<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
													class="pull-right text-muted small">12 minutes ago</span>
											</div>
									</a></li>
									<li class="divider"></li>
									<li><a href="#">
											<div>
												<i class="fa fa-envelope fa-fw"></i> Message Sent <span
													class="pull-right text-muted small">4 minutes ago</span>
											</div>
									</a></li>
									<li class="divider"></li>
									<li><a href="#">
											<div>
												<i class="fa fa-tasks fa-fw"></i> New Task <span
													class="pull-right text-muted small">4 minutes ago</span>
											</div>
									</a></li>
									<li class="divider"></li>
									<li><a href="#">
											<div>
												<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
													class="pull-right text-muted small">4 minutes ago</span>
											</div>
									</a></li>
									<li class="divider"></li>
									<li><a class="text-center" href="#"> <strong>See
												All Alerts</strong> <i class="fa fa-angle-right"></i>
									</a></li>
								</ul> <!-- /.dropdown-alerts --></li>
							<!-- /.dropdown -->
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> <i class="fa fa-user fa-lg"></i>
							</a>
								<ul class="dropdown-menu dropdown-user">
									<li><a href="#"><i class="fa fa-user fa-fw"></i> User
											Profile</a></li>
									<li><a href="#"><i class="fa fa-gear fa-fw"></i>
											Settings</a></li>
									<li class="divider"></li>
									<li><a href="login.html"><i
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

		</div>
		<!-- /.navbar-header -->

		<div class="navbar-default navbar-static-side" role="navigation">

			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

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

									<h3 class="prof-name">Tharindu Thilanka</h3>
									<h4 class="prof-sub">Software Engeneer</h4>

								</div>

								<img src="<c:url value="/resources/img/prof.jpg"/>" width="80"
									class="img-circle img-responsive prof-left" /> <a href="#"><h5
										class="edit">Edit Profile</h5></a>

							</div>



							<div class="list-group">
								<a href="#" class="list-group-item"> <i
									class="fa fa-comment fa-fw"></i>Ask </span>
								</a> <a href="#" class="list-group-item"> <i
									class="fa fa-twitter fa-fw"></i> 3 New Followers </span>
								</a> <a href="#" class="list-group-item"> <i
									class="fa fa-envelope fa-fw"></i> Message Sent </span>
								</a>

							</div>
							<!-- /.list-group -->
							<a href="#" class="btn btn-default btn-block">View Profile</a>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->



					<div class="chat-panel panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-comments fa-fw"></i> New Events

						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<ul class="chat">
								<li class="left clearfix"><span class="chat-img pull-left">
										<img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar"
										class="img-circle" />
								</span>
									<div class="chat-body clearfix">
										<div class="header">
											<strong class="primary-font">Jack Sparrow</strong> <small
												class="pull-right text-muted"> <i
												class="fa fa-clock-o fa-fw"></i> 12 mins ago
											</small>
										</div>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Curabitur bibendum ornare dolor, quis ullamcorper
											ligula sodales.</p>
									</div></li>
								<li class="right clearfix"><span
									class="chat-img pull-right"> <img
										src="http://placehold.it/50/FA6F57/fff" alt="User Avatar"
										class="img-circle" />
								</span>
									<div class="chat-body clearfix">
										<div class="header">
											<small class=" text-muted"> <i
												class="fa fa-clock-o fa-fw"></i> 13 mins ago
											</small> <strong class="pull-right primary-font">Bhaumik
												Patel</strong>
										</div>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Curabitur bibendum ornare dolor, quis ullamcorper
											ligula sodales.</p>
									</div></li>
								<li class="left clearfix"><span class="chat-img pull-left">
										<img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar"
										class="img-circle" />
								</span>
									<div class="chat-body clearfix">
										<div class="header">
											<strong class="primary-font">Jack Sparrow</strong> <small
												class="pull-right text-muted"> <i
												class="fa fa-clock-o fa-fw"></i> 14 mins ago
											</small>
										</div>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Curabitur bibendum ornare dolor, quis ullamcorper
											ligula sodales.</p>
									</div></li>
								<li class="right clearfix"><span
									class="chat-img pull-right"> <img
										src="http://placehold.it/50/FA6F57/fff" alt="User Avatar"
										class="img-circle" />
								</span>
									<div class="chat-body clearfix">
										<div class="header">
											<small class=" text-muted"> <i
												class="fa fa-clock-o fa-fw"></i> 15 mins ago
											</small> <strong class="pull-right primary-font">Bhaumik
												Patel</strong>
										</div>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Curabitur bibendum ornare dolor, quis ullamcorper
											ligula sodales.</p>
									</div></li>
							</ul>

							<!-- /.panel-body -->

							<!-- /.panel-footer -->

						</div>

						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
					<div class="chat-panel panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-comments fa-fw"></i> Map
							<div class="btn-group pull-right">
								<button type="button"
									class="btn btn-default btn-xs dropdown-toggle"
									data-toggle="dropdown">
									<i class="fa fa-chevron-down"></i>
								</button>
								<ul class="dropdown-menu slidedown">
									<li><a href="#"> <i class="fa fa-refresh fa-fw"></i>
											Refresh
									</a></li>
									<li><a href="#"> <i class="fa fa-check-circle fa-fw"></i>
											Available
									</a></li>
									<li><a href="#"> <i class="fa fa-times fa-fw"></i>
											Busy
									</a></li>
									<li><a href="#"> <i class="fa fa-clock-o fa-fw"></i>
											Away
									</a></li>
									<li class="divider"></li>
									<li><a href="#"> <i class="fa fa-sign-out fa-fw"></i>
											Sign Out
									</a></li>

								</ul>
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body"></div>
						<!-- /.panel-body -->

						<!-- /.panel-footer -->
					</div>
					<!-- /.panel .chat-panel -->
				</div>
				<!-- /.col-lg-4 -->

				<div class="col-lg-8">
					<div class="panel panel-default">

						<div class="panel-body">

							<!-- content             -->



							<div class="page-header">
								<h1>Registration Form</h1>
							</div>



							<!-- FORM -->
							<!-- pass in the variable if our form is valid or invalid -->
							<!-- novalidate prevents HTML5 validation since we will be validating ourselves -->
							<form:form name="userForm" method="post" action="tester" commandName="tset">
								<!-- index.html -->

								<!-- FNAME -->
								<div class="form-group">
									<label>First Name</label>
									<form:input path="name" type="text" class="form-control" />
								</div>
								
								<div class="form-group">
									<label>Date</label>
									<form:input path="date" type="date" class="form-control" />
								</div>


								<!-- SUBMIT BUTTON -->
								<button type="submit" class="btn btn-primary">Submit</button>

							</form:form>







							<!-- /content             -->


						</div>
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
