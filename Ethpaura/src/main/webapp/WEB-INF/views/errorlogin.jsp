<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://efsavage.com/twitter-bootstrap" prefix="bs"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>



<link type="text/css"
	href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
	<link rel="stylesheet" type="text/css"
		href="<c:url value="/resources/css/bootstrap.min.css" />">
		<link rel="stylesheet" type="text/css"
			href="<c:url value="/resources/css/bootstrap-responsive.css"/>">
			<link rel="stylesheet" type="text/css"
				href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>">
</head>

<style>
.modal-backdrop,.modal-backdrop.fade.in {
	opacity: .2;
	filter: alpha(opacity = 80);
	margin-top: 80px;
}


</style>


<body>
	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js"/>"></script>



	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/bootstrap/js/jquery.slimscroll.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/modal.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/modal.js"/>"></script>







	<script>
		$(function() {
			$('#inner-content-div').slimScroll({
				height : '500px'
			});
		});
	</script>

	<script>
		$(".alert").alert();
	</script>




	<div class="login" align="right" style="background: rgba(226,226,226,1);
background: -moz-linear-gradient(left, rgba(226,226,226,1) 0%, rgba(219,219,219,1) 1%, rgba(254,254,254,1) 41%, rgba(209,209,209,1) 93%, rgba(209,209,209,1) 100%);
background: -webkit-gradient(left top, right top, color-stop(0%, rgba(226,226,226,1)), color-stop(1%, rgba(219,219,219,1)), color-stop(41%, rgba(254,254,254,1)), color-stop(93%, rgba(209,209,209,1)), color-stop(100%, rgba(209,209,209,1)));
background: -webkit-linear-gradient(left, rgba(226,226,226,1) 0%, rgba(219,219,219,1) 1%, rgba(254,254,254,1) 41%, rgba(209,209,209,1) 93%, rgba(209,209,209,1) 100%);
background: -o-linear-gradient(left, rgba(226,226,226,1) 0%, rgba(219,219,219,1) 1%, rgba(254,254,254,1) 41%, rgba(209,209,209,1) 93%, rgba(209,209,209,1) 100%);
background: -ms-linear-gradient(left, rgba(226,226,226,1) 0%, rgba(219,219,219,1) 1%, rgba(254,254,254,1) 41%, rgba(209,209,209,1) 93%, rgba(209,209,209,1) 100%);
background: linear-gradient(to right, rgba(226,226,226,1) 0%, rgba(219,219,219,1) 1%, rgba(254,254,254,1) 41%, rgba(209,209,209,1) 93%, rgba(209,209,209,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e2e2e2', endColorstr='#d1d1d1', GradientType=1 );padding:4px;">

		
<img src="<c:url value="/resources/img/lg.png"/>" style="resize: none; float:left" />


		<form:form method="post" action="authenticate" commandName="login"
			class="form-inline" style="margin-right: 20px; margin-top: 5px;">
			<form:input path="username" type="text" name="Username"
				placeholder="Username" />
			<form:input path="password" type="password" name="password"
				placeholder="Password" />
				
				
				
			<button type="submit" class="btn">Login</button>




		</form:form>
		
	<div class="alert alert-error">
	
	Incorrect UserName or Password
	
	</div>
		
			





	</div>




	<div class="footer"
		style="position: absolute; top: 80px; height: 530px;">


	


		<img src="<c:url value="/resources/img/eln51.jpg"/>" style="resize: none; margin-top:50px;" />




	</div>


	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="margin-top: 40px; margin-left: 160px; margin-right: 20px; opacity: .8; width: 500px; height: 500px;">

		<div class="some-content-related-div">
			<div id="inner-content-div"
				style="width: 500px; height: 500px; overflow: scroll;">



				<!-- starting registering form -->
				<form:form class="form-horizontal" method="post" action="addDetails"
					commandName="user">


					<div class="control-group">
						<label class="control-label" for="inputName">Name</label>
						<div class="controls">
							<form:input path="name" id="name" placeholder="Name" />
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
						<label class="control-label" for="inputAge">Age</label>
						<div class="controls">

							<form:input path="age" id="inputAge" placeholder="Age" />
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
						<label class="control-label" for="inputPhone">Contact
							Number</label>
						<div class="controls">
							<form:input path="phoneNo" type="text" id="inputPhone"
								placeholder="Contact Number" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputEmail">Email</label>
						<div class="controls">
							<form:input path="email" id="inputEmail"
								placeholder="Example@example.com" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputphoto">Photo</label>
						<div class="controls">
							<form:input path="photo" id="inputPhoto" placeholder="photo" />
						</div>
					</div>


					<div class="control-group">
						<label class="control-label" for="inputBiblography">Biblography</label>
						<div class="controls">
							<form:textarea path="biblography" cols="35" rows="3"
								id="inputPhoto" placeholder="" />

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
		</div>
	</div>




	<!--End of registering form-->

</body>
</html>
