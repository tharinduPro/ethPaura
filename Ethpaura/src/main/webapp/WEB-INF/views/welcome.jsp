<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://efsavage.com/twitter-bootstrap" prefix="bs"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>ethPaura</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet">

<!-- Add custom CSS here -->
<link href="<c:url value="/resources/css/stylish-portfolio.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/font-awesome/css/font-awesome.css"/>"
				rel="stylesheet">

<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-modal.js"/>"></script>

<!-- load angular -->
<script type="text/javascript"
	src="<c:url value="/resources/js/angular.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/app.js"/>"></script>

</head>

<body ng-app="validationApp" ng-controller="mainController">

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="padding: 10px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Registration Form</h4>
				</div>

				<!-- FORM -->
				<!-- pass in the variable if our form is valid or invalid -->
				<!-- novalidate prevents HTML5 validation since we will be validating ourselves -->
				<form:form name="userForm" method="post" action="addDetails"
					ng-submit="submitForm(userForm.$valid)" commandName="user" enctype="multipart/form-data">
					<!-- index.html -->

					<!-- FNAME -->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.fname.$invalid && !userForm.fname.$pristine }">
						<label>First Name</label>
						<form:input path="fname" type="text" name="fname"
							class="form-control" ng-model="user.fname" required="true" />
						<p ng-show="userForm.fname.$invalid && !userForm.fname.$pristine"
							class="help-block">You name is required.</p>
					</div>

					<!-- LNAME -->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.lname.$invalid && !userForm.lname.$pristine }">
						<label>Last Name</label>
						<form:input path="lname" type="text" name="lname"
							class="form-control" ng-model="user.lname" required="true" />
						<p ng-show="userForm.lname.$invalid && !userForm.lname.$pristine"
							class="help-block">You name is required.</p>
					</div>



					<!-- GENDER -->
					<!-- RADIO BUTTONS -->
					<label>Gender</label>
					<div class="form-group">
						<div class="radio">
							<form:radiobutton path="gender" name="gender" value="Female"
								ng-model="user.gender" />
							<label>female</label>

						</div>
						<div class="radio">
							<form:radiobutton path="gender" name="gender" value="male"
								ng-model="user.gender" />
							<label>male</label>

						</div>
					</div>


					<!-- AGE -->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.age.$invalid && !userForm.age.$pristine }">
						<label>Age</label>
						<form:input path="age" type="number" name="age"
							class="form-control" ng-model="user.age" min="3" max="100"
							required="true" />
						<p ng-show="userForm.age.$error.number" class="help-block">number
							required.</p>
						<p ng-show="userForm.age.$error.min" class="help-block">age is
							too short.</p>
						<p ng-show="userForm.age.$error.max" class="help-block">age is
							too long.</p>
					</div>


					<!-- OCCUPATION -->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.occupation.$invalid && !userForm.occupation.$pristine }">
						<label>Occupation</label>
						<form:input path="occupation" type="text" name="occupation"
							class="form-control" ng-model="user.occupation" required="true" />
						<p
							ng-show="userForm.occupation.$invalid && !userForm.occupation.$pristine"
							class="help-block">Occupation Required.</p>
					</div>


					<!-- CONTACTS -->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.phoneNo.$invalid && !userForm.phoneNo.$pristine }">
						<label>Contact Number</label>
						<form:input path="phoneNo" type="number" name="phoneNo"
							class="form-control" ng-model="user.phoneNo" />

					</div>

					<!-- EMAIL -->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.email.$invalid && !userForm.email.$pristine }">
						<label>Email</label>
						<form:input path="" type="email" name="email" class="form-control"
							ng-model="user.email" />
						<p ng-show="userForm.email.$invalid && !userForm.email.$pristine"
							class="help-block">Enter a valid email.</p>
					</div>

					<!-- BIBLOGRAPHY -->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.biblo.$invalid && !userForm.biblo.$pristine }">
						<label>Biblography</label>
						<form:textarea path="biblography" cols="35" rows="3" name="biblo"
							class="form-control" ng-model="user.biblo" />
					</div>




					<!-- REFERENCE-->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.reference.$invalid && !userForm.reference.$pristine }">
						<label>Reference</label>
						<form:select path="reference" name="reference"
							class="form-control" ng-model="user.reference" required="true">

							<c:if test="${!empty adminList}">


								<c:forEach items="${adminList}" var="adm">

									<option value="${adm.adminId}">${adm.fname} ${adm.lname}</option>


								</c:forEach>

							</c:if>

						</form:select>
					</div>


				
						<label>Photograph</label>
		     					
		
		      <form:input path="photofile" type="file" class="filestyle btn btn-default btn-sm" name="photofile"/>
		                        
		                                         
		                     
				


					<!-- USERNAME -->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.username.$invalid && !userForm.username.$pristine }">
						<label>Username</label>
						<form:input path="username" type="text" name="username"
							class="form-control" ng-model="user.username" ng-minlength="3"
							ng-maxlength="8" />
						<p ng-show="userForm.username.$error.minlength" class="help-block">Username
							is too short.</p>
						<p ng-show="userForm.username.$error.maxlength" class="help-block">Username
							is too long.</p>
					</div>

					<!-- PASSWORD -->
					<div class="form-group"
						ng-class="{ 'has-error' : userForm.password.$invalid && !userForm.password.$pristine }">
						<label>Password</label>
						<form:input path="password" type="password" name="password"
							class="form-control" ng-model="user.password" ng-minlength="6"
							ng-maxlength="20" />
						<p ng-show="userForm.password.$error.minlength" class="help-block">Password
							is too short.</p>
						<p ng-show="userForm.password.$error.maxlength" class="help-block">Password
							is too long.</p>
					</div>



					<!-- POLICY-->
					<div class="form-group" style="overflow: hidden;">
						<label>Policy</label>
						<form:checkbox path="policy" name="policy" value="agreed"
							class="form-control" ng-model="user.policy" required="true" style=" float: left;margin-top: 0px;margin-right: 5px;height:20px;width:20px;"/>
						<div>

							<div class="check-element animate-show" ng-show="user.policy">
								<span class="glyphicon glyphicon-thumbs-up"></span>Accepted.
							</div>
						</div>
						<div>

							<div class="check-element animate-show" ng-hide="user.policy">
								<span class="glyphicon glyphicon-thumbs-down"></span>Please
								accept the Policy.
							</div>
						</div>
					</div>
					<!-- SUBMIT BUTTON -->
					<button type="submit" class="btn btn-primary">Submit</button>

				</form:form>
				<div class="modal-footer"></div>





			</div>
		</div>
	</div>
	</div>

	<!-- /Modal -->

	<!-- Side Menu -->

	<a id="menu-toggle" href="#" class="btn btn-primary btn-lg toggle">LOGIN</a>
	<div align="center" id="sidebar-wrapper" style="background: #D6D3D3; padding: 10px;">
		<a id="menu-close" href="#"
			class="btn btn-default btn-lg pull-right toggle"><i
			class="fa fa-times"></i></a>



		<form name="f" action="<c:url value='j_spring_security_check'/>"
			method="POST">

			<input class="form-control" type='text' name='j_username'
				placeholder="User Name" style="margin-top: 5px;" /> 
				
				<input class="form-control" style="margin-top: 5px;"
				type='password' name='j_password' placeholder="Password">

			<table style="margin: 5px;">

				<tr>
					<td><p style="margin: 0;">Remember Me: </p></td>
					<td><input type="checkbox" name="remember-me" /></td>

				</tr>
				
                
                
                
				<tr style="text-align: center;">
                	
					
				
                
					<td colspan='2'><button class="btn btn-primary" name="Login" type="submit">Login</button></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<!-- 
		<button class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">Register</button> Button trigger modal -->
			
			
		<a data-toggle="modal" data-target="#myModal" href="">Register</a>

	</div>
	<!-- /Side Menu -->

	<!-- Full Page Image Header Area -->
	<div id="top" class="header">
		<div class="vert-text">
			<h1>ETH PAURA</h1>
			<h3>
				<em>We</em> Build the HUB, <em>You</em> Make The BOND
			</h3>
			
		</div>
	</div>
	<!-- /Full Page Image Header Area -->
 
	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 text-center">
					<hr>
					<p>Copyright &copy; EthPaura org</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- /Footer -->

	<!-- JavaScript -->
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js"/>"></script>


	<!-- Custom JavaScript for the Side Menu and Smooth Scrolling -->
	<script>
		$("#menu-close").click(function(e) {
			e.preventDefault();
			$("#sidebar-wrapper").toggleClass("active");
		});
	</script>
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#sidebar-wrapper").toggleClass("active");
		});
	</script>
	<script>
		$(function() {
			$('a[href*=#]:not([href=#])')
					.click(
							function() {
								if (location.pathname.replace(/^\//, '') == this.pathname
										.replace(/^\//, '')
										|| location.hostname == this.hostname) {

									var target = $(this.hash);
									target = target.length ? target
											: $('[name=' + this.hash.slice(1)
													+ ']');
									if (target.length) {
										$('html,body').animate({
											scrollTop : target.offset().top
										}, 1000);
										return false;
									}
								}
							});
		});
	</script>

</body>

</html>
