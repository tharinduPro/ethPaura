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
	href="<c:url value="/resources/css/bootstrap-responsive.css"/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value="/resources/css/datepicker.css"/>" rel="stylesheet">





</head>

<body>


	<div class="container">

		<h2 align="center">Register</h2>

		<legend></legend>


		<form:errors path="*" cssClass="errorblock" element="div" />


		<form:form class="form-horizontal" method="post" action="addDetails"
			commandName="user">
			<form:errors path="*" cssClass="errorblock" element="div" />


			<div class="control-group">
				<label class="control-label" for="inputfName">First Name</label>
				<div class="controls">
					<form:input path="fname" cssClass="error" id="fname"
						placeholder="First Name" />
				</div>
			</div>


			<div class="control-group">
				<label class="control-label" for="inputlName">Last Name</label>
				<div class="controls">
					<form:input path="lname" cssClass="error" id="lname"
						placeholder="Last Name" />
				</div>
			</div>


			<div class="control-group">
				<label class="control-label" for="inputName">Gender</label>
				<div class="controls">
					<label class="radio"> <form:radiobutton path="gender"
							value="MALE" />Male
					</label> <label class="radio"> <form:radiobutton path="gender"
							value="FEMALE" />Female
					</label>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="inputOccupation">Age</label>
				<div class="controls">
					<form:input path="age" type="text" id="inputAge" placeholder="AGE" />
				</div>
			</div>


			<div class="control-group">
				<label class="control-label" for="inputOccupation">Occupation</label>
				<div class="controls">
					<form:input path="occupation" type="text" id="inputOccupation"
						placeholder="Occupation" />
				</div>
			</div>


			<div class="control-group">
				<label class="control-label" for="inputPhone">Contact Number</label>
				<div class="controls">
					<form:input path="phoneNo" type="text" id="inputPhone"
						placeholder="Contact Number" />
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="inputEmail">Email</label>
				<div class="controls">
					<form:input path="email" type="email" cssClass="error"
						id="inputEmail" placeholder="Example@example.com" />
				</div>
			</div>



			<div class="control-group">
				<label class="control-label" for="inputBiblography">Biblography</label>
				<div class="controls">
					<form:textarea path="biblography" cols="35" rows="3"
						id="inputBiblography" placeholder="" />

				</div>
			</div>




			<div class="control-group">
				<label class="control-label" for="inputReference">Reference</label>
				<div class="controls">
					<form:select path="reference" id="reference" name="reference">




						<c:if test="${!empty adminList}">


							<c:forEach items="${adminList}" var="adm">

								<option value="${adm.adminId}">${adm.name}</option>


							</c:forEach>

						</c:if>


					</form:select>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="inputUsername">Username</label>
				<div class="controls">
					<form:input path="username" type="text" id="inputUsername"
						placeholder="Ex:John123" />
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="inputPassword">Password</label>
				<div class="controls">
					<form:input type="password" path="password" id="inputPassword"
						placeholder="Password" />
				</div>
			</div>

			<legend></legend>
			<div class="control-group">
				<div class="controls">
					<label class="checkbox"> <form:checkbox path="policy"
							value="agreed" /> I agree to the Policy
					</label>
					<button type="submit" class="btn">Submit</button>
				</div>

			</div>



		</form:form>

	</div>



	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>


</body>
</html>
