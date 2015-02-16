<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://efsavage.com/twitter-bootstrap" prefix="bs"%>
<html>
<head>
<!-- CSS ===================== -->
<!-- load bootstrap -->
<link type="text/css"
	href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
<link type="text/css"
	href="<c:url value="/resources/css/bootstrap-responsive.css"/>"
	rel="stylesheet">
<style>
body {
	padding-top: 30px;
}
</style>

<!-- JS ===================== -->
<!-- load angular -->
<script src="http://code.angularjs.org/1.2.6/angular.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/app.js"/>"></script>



</head>




<!-- apply angular app and controller to our body -->
<body ng-app="validationApp" ng-controller="mainController">
	<div class="container">
		<div class="col-sm-8 col-sm-offset-2">

			<!-- PAGE HEADER -->
			<div class="page-header">
				<h1>Registration Form</h1>
			</div>



			<!-- FORM -->
			<!-- pass in the variable if our form is valid or invalid -->
			<!-- novalidate prevents HTML5 validation since we will be validating ourselves -->
			<form:form name="userForm" method="post" action="addDetails"
				ng-submit="submitForm(userForm.$valid)" commandName="user">
				<!-- index.html -->

				<!-- FNAME -->
				<div class="form-group"
					ng-class="{ 'has-error' : userForm.name.$invalid && !userForm.name.$pristine }">
					<label>First Name</label>
					<form:input path="fname" type="text" name="fname"
						class="form-control" ng-model="user.fname" required="true" />
					<p ng-show="userForm.fname.$invalid && !userForm.fname.$pristine"
						class="help-block">You name is required.</p>
				</div>

				<!-- LNAME -->
				<div class="form-group"
					ng-class="{ 'has-error' : userForm.name.$invalid && !userForm.name.$pristine }">
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
						class="form-control" ng-model="user.phoneNo" min="9" max="11" />
					<p ng-show="userForm.phoneNo.$error.number" class="help-block">number
						required.</p>
					<p ng-show="userForm.phoneNo.$error.min" class="help-block">Phone
						Number is too short.</p>
					<p ng-show="userForm.phoneNo.$error.max" class="help-block">Phone
						Number is too long.</p>
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
					<form:select path="reference" name="reference" class="form-control"
						ng-model="user.reference" required="true">

						<c:if test="${!empty adminList}">


							<c:forEach items="${adminList}" var="adm">

								<option value="${adm.adminId}">${adm.name}</option>


							</c:forEach>

						</c:if>

					</form:select>
				</div>





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
				<div class="form-group">
					<label>Policy</label>
					<form:checkbox path="policy" name="policy" value="agreed"
						class="form-control" ng-model="user.policy" required="true" />
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

		</div>
		<!-- col-sm-8 -->
	</div>
	<!-- /container -->


	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>


</body>
</html>
