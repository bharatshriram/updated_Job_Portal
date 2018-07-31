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

<script src="js/profile_Edit.js"></script>
<script src="js/dropDown.js"></script>

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
								<label>First Name:</label> 
								
								<input type="hidden" name="Name"
									placeholder="Last Name" id="srNoHidden" />
									<input type="text" name="Name"
									placeholder="First Name" id="profile_frstname" />
							</div>
							<div class="form-group">
								<label>Last Name:</label> <input type="text" name="Name"
									placeholder="Last Name" id="profile_lastname" />
							</div>
							<div class="form-group">
								<label>Email ID:</label><input type="email" name="Email"
									placeholder="EmailID" id="profile_mail" />
							</div>
							<div class="form-group">
								<label>Gender:</label> <select id="recuiter_gender"
									name="recuiter_gender" class="form-control input-md"
									>
									<option value=-1>Select Gender</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</select>
							</div>
							<div class="form-group">
								<label>Mobile No:</label> <input type="text" name="Name"
									placeholder="Mobile No" id="profile_mobileNo" max-length="10" />
							</div>
							<div class="form-group">
								<label>State</label> <select id="recuiter_state"
									name="recuiter_state" class="form-control input-md"
									onchange="showdistricts(this.value);">
									<option value=-1>Select State</option>
								</select>
							</div>
							<div class="form-group">
								<label>District</label> <select id="recuiter_district"
									name="recuiter_district" class="form-control input-md">
									<option value=-1>Select District</option>
								</select>
							</div>

							<!-- <div class="form-group">
								<label>State</label> <select id="recuiter_state"
									name="recuiter_state" class="form-control input-md"
									onchange="showdistricts(this.value);">
									<option value=-1>Select State</option>
								</select>
							</div> -->


							<div class="form-group">
								<label>Job Profile</label> <select id="recuiter_profile"
									name="recuiter_profile" class="form-control input-md">
									<option value=-1>Select Profile</option>
								</select>
							</div>

							<div class="form-group">
								<label>Job Description</label> <input type="textarea"
									name="Name" placeholder="Job Description"
									id="profile_Description" required="" />
							</div>
							<div class="form-group">
								<label>Job Posted Date</label> <input type="date" name="Name"
									placeholder="Job Date" id="profile_postdate" required="" />
							</div>
							<input type="button" value="Update" id="update_recuiter">
						</form>
					</div>
				</div>
				<!-- //banner -->
			</div>
		</div>
	</div>
</body>
</html>