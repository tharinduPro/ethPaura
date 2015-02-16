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
</head>

<body>




	<div class="container">

		<h2>PRIVACY POLICY</h2>

		<div style="width: 50px; overflow: hidden">

			<p>On our site we collect the following: 
			Name 
			Email address 
			Phone number 
			
			Information is collected from you when you: 
			Register on our site Fill out a form 
			
			The information collected from you is used in the following ways: 
			To personalize user's experience To administer contests, 
			promotions, 
			or a survey 
			or other site feature To send periodic emails 
				
			How do we protect visitor information? 
			We use vulnerability scanning and/or scanning to PCI standards. 
			We do not use an SSL certificate 
				• We only provide articles and information,and we never ask for personal or private information 
				
			We use cookies to: 
				• Compile aggregate data about site
				traffic and site interactions in order to offer better site
				experiences and tools in the future. We may also use trusted third
				party services that track this information on our behalf. It won't
				affect the users experience Third Party Disclosure We do not sell,
				trade, or otherwise transfer Personally Identifiable Information.

				Third party links We do not include or offer third party products or
				services on our website. Google We have not enable Google Adwords on
				our site but we may do so on the future. California Online Privacy
				Protection Act According to CalOPPA we agree to the following: Users
				can visit our site anonymously Once this privacy policy is created,
				we will add a link to it on our home page, or as a minimum on the
				first significant page after entering our website. Our Privacy
				Policy link includes the word 'Privacy', and can be easily be found
				on the page specified above. Users will be notified of any privacy
				policy changes: • On our Privacy Policy Page Users are able to
				change their personal information: • By logging in to their account

				How does our site handle do not track signals? We honor them and do
				not track, plant cookies, or use advertising when a Do Not Track
				(DNT) browser mechanism is in place. Does our site allow third party
				behavioral tracking? We do not allow COPPA (Children Online Privacy
				Protection Act) We do not specifically market to children under 13

				Fair Information Practices In order to be in line with Fair
				Information Practices we will take the following responsive action,
				should a data breach occur: We will notify the users via in site
				notification • Within 1 business day We agree to the individual
				redress principle, which requires that individuals have a right to
				pursue legally enforceable rights against data collectors and
				processors who fail to adhere to the law. This principle requires
				not only that individuals have enforceable rights against data
				users, but also that individuals have recourse to courts or a
				government agency to investigate and/or prosecute non-compliance by
				data processors CAN SPAM Act We collect your email address: To send
				information, respond to inquiries, and/or other requests or
				questions. To be accordance with CANSPAM we agree to the following:
				We will NOT use false, or misleading subjects or email addresses We
				will identify the message as an advertisement in some reasonable way
				We will include the physical address of our business or site
				headquarters We will monitor third party email marketing services
				for compliance, if one is used. We will honor opt-out/unsubscribe
				requests quickly We will give an 'opt-out' or 'unsubscribe' option

				If at any time you would like to unsubscribe from receiving future
				emails, 
				you can • Follow the instructions at the bottom of each
				email. 
				
				Contact Information 
				EthPaura.com 
				Anuradhapura SriLanka
				RUSL,Mihinthale,Anuradhapura,SriLanka NorthCentral 
				00600
				ryohani89@gmail.com</p>

		</div>


	</div>

	<script>
		function checkPass() {
			//Store the password field objects into variables ...
			var pass1 = document.getElementById('pass1');
			var pass2 = document.getElementById('pass2');
			//Store the Confimation Message Object ...
			var message = document.getElementById('confirmMessage');
			//Set the colors we will be using ...
			var goodColor = "#66cc66";
			var badColor = "#ff6666";
			//Compare the values in the password field 
			//and the confirmation field
			if (pass1.value == pass2.value) {
				//The passwords match. 
				//Set the color to the good color and inform
				//the user that they have entered the correct password 
				message.style.color = goodColor;
				message.innerHTML = "Passwords Match!"
			} else {
				//The passwords do not match.
				//Set the color to the bad color and
				//notify the user.
				message.style.color = badColor;
				message.innerHTML = "Passwords Do Not Match!"
			}
		}
	</script>


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
