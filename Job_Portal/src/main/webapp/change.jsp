<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile</title>
<link rel="stylesheet" href="files/common/css/bootstrap.min.css">
<link rel="stylesheet" href="files/common/css/profile.css"
	type="text/css" media="all" />
<link rel="stylesheet" href="files/common/css/bootstrap.css">
<link rel="stylesheet" href="files/menu/css/menu.css">
<link rel="stylesheet" href="files/login/css/login.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="files/common/css/nav.css">
<link rel="stylesheet" href="files/table/css/style.css">
<link rel="stylesheet" href="files/common/css/glyphicon_common.css">

<script src="files/common/js/jquery.min.js"></script>
<script src="files/common/js/bootstrap.min.js"></script>
<script src="files/common/js/bootbox.js"></script>
<script src="files/common/js/bootbox.min.js"></script>

<script src="js/change.js"></script>

<style>
html body {
	overflow-y: auto;
	height: 100%;
}
</style>

</head>
<body>

	<%
		String user_id = (String) session.getAttribute("roleID");

		System.out.println("======>" + user_id);
	%>

	<%
		if (null == user_id) {
			
			response.sendRedirect("index.jsp");
		}
	%>
	<div id="logo1">
		<jsp:include page="menu.jsp" />
		<div class="video">
			<div class="center-container">
				<div class="w3ls-agileinfo"></div>
				<div class="bg-agile">
					<div class="login-form">
						<form action="#" method="post">
							<div class="form-group">
								<label>Email:</label> 
								
								<input type="hidden" name="Name"
									 id="srNoHidden" />
									<input type="text" name="email"
									 id="email" readonly/>
							</div>
							<div class="form-group">
								<label>Previous Password:</label> <input type="password" name="previousPassword"
									 id="previousPassword" />
							</div>
							<div class="form-group">
								<label>New Password:</label><input type="password" name="newpassword"
									id="newpassword" />
							</div>
							
							<div class="form-group">
								<label>Confirm Password:</label> <input type="password" name="confirmPassword"
									 id="confirmPassword" />
							</div>
						
							<input type="button" value="Update" id="ChangePassword">
						</form>
					</div>
				</div>
				<!-- //banner -->
			</div>
		</div>
	</div>
</body>
</html>