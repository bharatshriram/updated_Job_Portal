<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register Form</title>
<link rel="stylesheet" href="files/common/css/bootstrap.min.css">
<link rel="stylesheet" href="files/common/css/register.css" type="text/css" media="all" />
<link rel="stylesheet" href="files/common/css/bootstrap.css">
<link rel="stylesheet" href="files/menu/css/menu.css">
<link rel="stylesheet" href="files/login/css/login.css" type="text/css" media="all" />
<link rel="stylesheet" href="files/common/css/nav.css">
<link rel="stylesheet" href="files/table/css/style.css">
<link rel="stylesheet" href="files/common/css/glyphicon_common.css">


<script src="files/common/js/jquery.min.js"></script>
<script src="files/common/js/bootstrap.min.js"></script>
<script src="files/common/js/bootbox.min.js"></script>
<script src="files/common/js/bootbox.js"></script>
<script src="files/common/js/jquery.min.js"></script>

<script src="js/registration.js"></script>

 <style>
html body {
	overflow-y: auto;
	height: 100%;
}
</style> 

</head>
<body>


	<div id ="mainBody">

	<div class="video"> 
	<div class="center-container">
	    <div class="w3ls-agileinfo">
			
		</div>
		 <div class="bg-agile">
		 <a href='index.jsp'><span
									class="glyphicon glyphicon-home" style="font: 30"></span></a>
			<h2>Registration Form</h2>
			<div class="login-form">	
				<form action="#" method="post">
				<!-- <div class="col-md-12"> -->
		

				<select id="register_type"
									name="register_type" 
									>
									<option value=-1>Select Type</option>
									<option value="1">Recruiter</option>
									<option value="2">Applicant</option>
								</select><!-- </div> -->
					<input type="text"  name="Name" placeholder="First Name" id="reg_frstname" required="" />
					<input type="text"  name="Name" placeholder="Last Name" id="reg_lastname" required="" />
					<input type="email"  name="Email" placeholder="EmailID" id="reg_mail" required="" />
					<input type="password"  name="Password" placeholder="Password" id="reg_password" max-length="8" required="" />
					<input type="password"  name="Password" placeholder="Confirm Password" id="reg_cnfrmpass" max-length="8" required="" />
					<input type="button" value="Register" id="reg_submit">
				</form>	
			</div>	
		</div>
	<!-- //banner --> 
	
	</div>	
</div>	
</div>
</body>
</html>