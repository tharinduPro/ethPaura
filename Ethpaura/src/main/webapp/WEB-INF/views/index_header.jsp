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

<title>ethPaura</title> <!-- Core CSS - Include with every page -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/slide/style.css"/>"
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

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
</head>

<body>



<div id="wrapper">

<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
	style="margin-bottom: 0; background-color:#066;"> <div
	class="navbar-header">



<a class="navbar-brand" href="index.html"><img
	src="<c:url value="/resources/img/logo.png" />" height="35" /></a>

<form:form method="POST" action="search" commandName="timeline">

	<div class="input-group custom-search-form"
		style="width: 50%; margin-top: 8px; z-index: 100; padding-left: 10px;">
	<form:input path="title" type="text" class="form-control" placeholder="Search..."/>
	<span class="input-group-btn"> 
	
	<button class="btn btn-default"
		type="submit" style="padding: 9px;">
	<i class="fa fa-search"></i>
	</button>
	</span>
	</div>

</form:form>

<nav class="navbar navbar-default navbar-inverse" role="navigation">
<div class="container">


<!-- I don't want it apart of the collapsible portion -->
<div class="navbar-header pull-right">

<button type="button" class="navbar-toggle" data-toggle="collapse"
	data-target=".navbar-collapse">
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
</div> </nav>


<!-- /input-group -->

</div> <!-- /.navbar-header --> <div class="navbar-default navbar-static-side"
	role="navigation">

<!-- /.sidebar-collapse -->
</div> <!-- /.navbar-static-side --> </nav>

<div id="page-wrapper">
<div class="row">
<br> <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">

<div class="col-lg-4">
<div class="panel panel-default">

<div class="panel-body">

<div class="prof-back-main">

<div class="prof-back-wall">

<h3 class="prof-name">${myprof.fname} ${myprof.lname}</h3>
<h4 class="prof-sub">${myprof.occupation}</h4>

</div>

<img src="<c:url value="/img_resources/${myprof.photo}"/>" width="80"
	class="img-circle img-responsive prof-left" /> <a
	href="${contextPath}/editProfile"><h5 class="edit">Edit
Profile</h5></a>

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
			alt="User Avatar" class="img-circle" width="80px; " />
		</span> <div class="chat-body clearfix">
		<div class="header">
		<strong class="primary-font">${re.getName()}</strong> <small
			class="pull-right text-muted"> <i class="fa fa-clock-o fa-fw"></i>
		${re.getDate()}
		</small>
		</div>
		<p></p>
		<p>${re.getDescription()}</p>
		</div></li>





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

<div class="panel-body">



<!-- content             -->


<div class="panel-body" style="padding: 0px;">
<!-- Nav tabs -->
<ul class="nav nav-tabs">
<li class="active"><a href="#home" data-toggle="tab">Post</a> </li>
<li><a href="#profile" data-toggle="tab">Image/Video</a></li>
<li><a href="#messages" data-toggle="tab">Questions</a></li>
<li><a href="#documents" data-toggle="tab">Documents</a></li>

</ul>

<!-- Tab panes -->
<div class="tab-content">


<!-- post -->
<div class="tab-pane fade in active" id="home">

<form:form method="post" action="posts" commandName="posts">
	<div class="form-group">
	<br />
	<form:input path="title" class="form-control" placeholder="Enter Title"
		style="margin-bottom: 5px;" />
	<form:textarea path="description" class="form-control" rows="3" />
	</div>

	<div style="text-align: right">
	<button type="submit" class="btn btn-default">post</button>

	</div>

</form:form>
</div>

<!-- /post -->


<!-- images -->
<div class="tab-pane fade" id="profile">

<form:form method="post" action="upload_m" commandName="med"
	enctype="multipart/form-data">
	<div class="form-group">
	<br />
	<form:input path="title" class="form-control" placeholder="Enter Title"
		style="margin-bottom: 5px;" />

	<form:input path="multipartFile" type="file" />

	</div>

	<div style="text-align: right">
	<button type="submit" class="btn btn-default">Upload</button>

	</div>

</form:form>
</div>

<!-- /images -->

<!-- Qs -->
<div class="tab-pane fade" id="messages">

<form:form method="post" action="ask" commandName="question">
	<br />
	<form:input path="question" class="form-control"
		placeholder="Enter Qestion" style="margin-bottom: 5px;" />
	<div style="text-align: right">
	<button type="submit" class="btn btn-default">Ask</button>

	</div>
</form:form>
</div>

<!-- /Qs -->


<div class="tab-pane fade" id="documents">
<form:form method="post" action="uploaddoc" commandName="doc"
	enctype="multipart/form-data">
	<br />
	<form:input path="title" class="form-control" placeholder="Enter Title"
		style="margin-bottom: 5px;" />


	<form:input path="multipartFile" type="file" />

	</a>

	<div style="text-align: right">
	<button type="submit" class="btn btn-default">Upload</button>

	</div>
</form:form>
</div>

</div>
</div>





<!-- /content             -->


</div>


<!-- /.panel-body -->
</div>


<c:if test="${!empty records}">


	<c:forEach items="${records}" var="re">

		<c:if test="${re.type.equals('post')}">



			<!--  +++++++++++++++++++post +++++++++++++++++++++++++    -->



			<!-- box -->
			<div class="chat-panel panel panel-default">
			<div class="panel-heading"
				style="padding-top: 0px; padding-bottom: 0px;">
			<div class="row">
			<div class="col-md-8">
			<h4>${re.title}</h4>

			</div>
			<div class="col-md-4" style="text-align: right">
			<h5>${re.username}</h5>

			</div>




			</div>
			</div>
			<div class="panel-body"
				style="height: auto; overflow-y: auto; overflow: hidden;">
			<!-- content -->



			<div class="row">



			<div class="col-md-12">

			<div class="main-post-text">
			<div class="row">

			<span class="pull-right text-muted small"> <i
				class="fa fa-clock-o fa-fw"></i> ${re.timeStamp}
			</span>
			</div>
			<div class="row" style="margin-left: -5px;">
			<p style="text-align: justify; padding-top: 5px;">${re.description}</p>
			</div>
			</div>



			</div>






			</div>
			<!--<div class="row" style="margin-top:5px;">
                                  
                                  <div class="col-md-12" >
                                  
                                  	<i class="fa fa-comment fa-fw">Comments</i>
                                  
                                  </div>
                            </div>-->

			<!--  Comments By user-->
			<div class="row">
			<div class="col-xs-3 col-sm-2 col-md-1" style="padding: 10px;">

			<img class="img-responsive"
				src="<c:url value="/img_resources/${myprof.photo}" />" />

			</div>

			<div class="col-xs-9 col-sm-10 col-md-11"
				style="padding: 10px; text-align: center; margin-top: 3px;">
			<input class="form-control" placeholder="Comments"
				style="margin-bottom: 5px;">
			</div>



			</div>
			<!--  /Comments By user-->

			<!-- old Comments-->
			<!-- <div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Rumesh Yohani</strong> This is not good this is
													good, this is bad
												</p>

											</div> -->
			<!-- /old Comments-->


			<!-- 
										</div>
										<div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Sulochan Gunarathna</strong> This is not good this
													is good, this is bad
												</p>

											</div>




										</div> old Comments-->
			<!-- /old Comments-->


			<!-- /content -->

			</div>

			</div>
			<!-- /box -->




			<!-- =+++++++++++++++++++ post +++++++++++++++++++++++++ -->







		</c:if>


		<c:if test="${re.type.equals('questions')}">



			<!--  +++++++++++++++++++ask +++++++++++++++++++++++++    -->



			<!-- box -->
			<div class="chat-panel panel panel-default">
			<div class="panel-heading"
				style="padding-top: 0px; padding-bottom: 0px;">
			<div class="row">
			<div class="col-md-8">
			<h4>Question</h4>

			</div>
			<div class="col-md-4" style="text-align: right">
			<h5>${re.username}</h5>

			</div>




			</div>
			</div>
			<div class="panel-body"
				style="height: auto; overflow-y: auto; overflow: hidden;">
			<!-- content -->



			<div class="row">



			<div class="col-md-12">

			<div class="main-post-text">
			<div class="row">

			<span class="pull-right text-muted small"> <i
				class="fa fa-clock-o fa-fw"></i> ${re.timeStamp	}
			</span>
			</div>
			<div class="row" style="margin-left: -5px;">
			<p style="text-align: justify; padding-top: 5px;">${re.title}</p>
			</div>
			</div>



			</div>






			</div>
			<!--<div class="row" style="margin-top:5px;">
                                  
                                  <div class="col-md-12" >
                                  
                                  	<i class="fa fa-comment fa-fw">Comments</i>
                                  
                                  </div>
                            </div>-->

			<!--  Comments By user-->
			<div class="row">
			<div class="col-xs-3 col-sm-2 col-md-1" style="padding: 10px;">
			<img class="img-responsive"
				src="<c:url value="/img_resources/${myprof.photo}" />" />

			</div>

			<div class="col-xs-9 col-sm-10 col-md-11"
				style="padding: 10px; text-align: center; margin-top: 3px;">
			<input class="form-control" placeholder="Comments"
				style="margin-bottom: 5px;">
			</div>



			</div>
			<!--  /Comments By user-->

			<!-- 
										<div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Rumesh Yohani</strong> This is not good this is
													good, this is bad
												</p>

											</div> old Comments-->
			<!-- /old Comments-->


			<!-- 
										</div>
										<div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Sulochan Gunarathna</strong> This is not good this
													is good, this is bad
												</p>

											</div>




										</div> old Comments-->
			<!-- /old Comments-->


			<!-- /content -->

			</div>

			</div>
			<!-- /box -->




			<!-- =+++++++++++++++++++ ask +++++++++++++++++++++++++ -->







		</c:if>




		<c:if test="${re.type.equals('image')}">





			<!--  +++++++++++++++++++image +++++++++++++++++++++++++    -->



			<!-- box -->
			<div class="chat-panel panel panel-default">
			<div class="panel-heading"
				style="padding-top: 0px; padding-bottom: 0px;">
			<div class="row">
			<div class="col-md-8">
			<h4>${re.title}</h4>

			</div>
			<div class="col-md-4" style="text-align: right">
			<h5>${re.username}</h5>

			</div>




			</div>
			</div>
			<div class="panel-body"
				style="height: auto; overflow-y: auto; overflow: hidden;">
			<!-- content -->



			<div class="row">
			<div class="col-md-6">

			<div class="main-post-img">


			<img height="200"
				src="<c:url value="/img_resources/${re.filePath}" />" alt="" />

			</div>

			</div>


			<div class="col-md-6">

			<div class="main-post-text">
			<div class="row">

			<span class="pull-right text-muted small"> <i
				class="fa fa-clock-o fa-fw"></i> ${re.timeStamp}
			</span>
			</div>



			<div class="row">
			<p style="text-align: justify; padding-top: 5px;">${re.description}</p>
			</div>
			</div>



			</div>






			</div>
			<!--<div class="row" style="margin-top:5px;">
                                  
                                  <div class="col-md-12" >
                                  
                                  	<i class="fa fa-comment fa-fw">Comments</i>
                                  
                                  </div>
                            </div>-->

			<!--  Comments By user-->
			<div class="row">
			<div class="col-xs-3 col-sm-2 col-md-1" style="padding: 10px;">
			<img class="img-responsive"
				src="<c:url value="/img_resources/${myprof.photo}" />" />

			</div>

			<div class="col-xs-9 col-sm-10 col-md-11"
				style="padding: 10px; text-align: center; margin-top: 3px;">
			<input class="form-control" placeholder="Comments"
				style="margin-bottom: 5px;">
			</div>



			</div>
			<!--  /Comments By user-->

			<!-- 
										<div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Rumesh Yohani</strong> This is not good this is
													good, this is bad
												</p>

											</div> old Comments-->
			<!-- /old Comments-->


			<!-- 
										</div>
										<div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Sulochan Gunarathna</strong> This is not good this
													is good, this is bad
												</p>

											</div>




										</div> old Comments-->
			<!-- /old Comments-->


			<!-- /content -->

			</div>

			</div>
			<!-- /box -->




			<!-- =+++++++++++++++++++ image +++++++++++++++++++++++++ -->






		</c:if>


		<c:if test="${re.type.equals('pdf')}">

			<!-- box doc -->
			<div class="chat-panel panel panel-default">
			<div class="panel-heading"
				style="padding-top: 0px; padding-bottom: 0px;">
			<div class="row">
			<div class="col-md-8">
			<h4>${re.title}</h4>

			</div>
			<div class="col-md-4" style="text-align: right">
			<h5>${re.username}</h5>

			</div>




			</div>
			</div>
			<div class="panel-body"
				style="height: auto; overflow-y: auto; overflow: hidden;">
			<!-- content -->



			<div class="row">


			<div class="col-md-12">

			<div class="main-post-text">
			<div class="row">
			<span class="pull-left"> <a
				href="<c:url value="/img_resources/${re.filePath}" />"><i
				class="fa fa-file fa-fw"></i>Download Document</a></span> <span
				class="pull-right text-muted small"> <i
				class="fa fa-clock-o fa-fw"></i> ${re.timeStamp}
			</span>
			</div>
			<div class="row">
			<p style="text-align: justify; padding-top: 5px;">${re.description}</p>
			</div>
			</div>



			</div>






			</div>
			<!--<div class="row" style="margin-top:5px;">
                                  
                                  <div class="col-md-12" >
                                  
                                  	<i class="fa fa-comment fa-fw">Comments</i>
                                  
                                  </div>
                            </div>-->

			<!--  Comments By user-->
			<div class="row">
			<div class="col-xs-3 col-sm-2 col-md-1" style="padding: 10px;">
			<img class="img-responsive"
				src="<c:url value="/img_resources/${myprof.photo}" />" />

			</div>

			<div class="col-xs-9 col-sm-10 col-md-11"
				style="padding: 10px; text-align: center; margin-top: 3px;">
			<input class="form-control" placeholder="Comments"
				style="margin-bottom: 5px;">
			</div>



			</div>
			<!--  /Comments By user-->

			<!-- 
										<div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Rumesh Yohani</strong> This is not good this is
													good, this is bad
												</p>

											</div> old Comments-->
			<!-- /old Comments-->


			<!-- 
										</div>
										<div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Sulochan Gunarathna</strong> This is not good this
													is good, this is bad
												</p>

											</div>




										</div> old Comments-->
			<!-- /old Comments-->


			<!-- /content -->

			</div>

			</div>
			<!-- /box doc -->



		</c:if>





		<c:if test="${re.type.equals('video')}">

			<!-- video -->
			<!-- box -->
			<div class="chat-panel panel panel-default">
			<div class="panel-heading"
				style="padding-top: 0px; padding-bottom: 0px;">
			<div class="row">
			<div class="col-md-8">
			<h4>${re.title}</h4>

			</div>
			<div class="col-md-4" style="text-align: right">
			<h5>${re.username}</h5>

			</div>




			</div>
			</div>
			<div class="panel-body"
				style="height: auto; overflow-y: auto; overflow: hidden;">
			<!-- content -->



			<div class="row">
			<div class="col-md-4">

			<div class="main-post-img" style="padding-top: 40px;">

			<img class="img-responsive" src="img/play.png" />

			</div>

			</div>


			<div class="col-md-8">

			<div class="main-post-text">
			<div class="row">

			<span class="pull-right text-muted small"> <i
				class="fa fa-clock-o fa-fw"></i> ${re.timeStamp}
			</span>
			</div>
			<div class="row">
			<p style="text-align: justify; padding-top: 5px;">${re.description}</p>
			</div>
			</div>



			</div>






			</div>
			<!--<div class="row" style="margin-top:5px;">
                                  
                                  <div class="col-md-12" >
                                  
                                  	<i class="fa fa-comment fa-fw">Comments</i>
                                  
                                  </div>
                            </div>-->

			<!--  Comments By user-->
			<div class="row">
			<div class="col-xs-3 col-sm-2 col-md-1" style="padding: 10px;">
			<img class="img-responsive"
				src="<c:url value="/img_resources/${myprof.photo}" />" />

			</div>

			<div class="col-xs-9 col-sm-10 col-md-11"
				style="padding: 10px; text-align: center; margin-top: 3px;">
			<input class="form-control" placeholder="Comments"
				style="margin-bottom: 5px;">
			</div>



			</div>
			<!--  /Comments By user-->

			<!-- 
										<div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Rumesh Yohani</strong> This is not good this is
													good, this is bad
												</p>

											</div> old Comments-->
			<!-- /old Comments-->


			<!-- 
										</div>
										<div class="row">
											<div class="col-xs-3 col-sm-2 col-md-1"></div>
											<div class="col-xs-3 col-sm-2 col-md-1"
												style="padding: 10px;">
												<img class="img-responsive" src="img/prof.jpg" />

											</div>

											<div class="col-xs-9 col-sm-10 col-md-10"
												style="padding: 10px; text-align: left; margin-top: 3px;">
												<p>
													<strong>Sulochan Gunarathna</strong> This is not good this
													is good, this is bad
												</p>

											</div>




										</div> old Comments-->
			<!-- /old Comments-->


			<!-- /content -->

			</div>

			</div>
			<!-- /box -->


		</c:if>




	</c:forEach>

</c:if>


















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
