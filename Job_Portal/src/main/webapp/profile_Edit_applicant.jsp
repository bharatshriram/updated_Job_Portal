<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile</title>
<link rel="stylesheet" href="files/common/css/bootstrap.min.css">
<link rel="stylesheet" href="files/common/css/profile.css" type="text/css" media="all" />
<link rel="stylesheet" href="files/common/css/bootstrap.css">
<link rel="stylesheet" href="files/menu/css/menu.css">
<link rel="stylesheet" href="files/login/css/login.css" type="text/css" media="all" />
<link rel="stylesheet" href="files/common/css/nav.css">
<link rel="stylesheet" href="files/table/css/style.css">
<link rel="stylesheet" href="files/common/css/glyphicon_common.css">

<script src="files/common/js/jquery.min.js"></script>
<script src="files/common/js/bootstrap.min.js"></script>
<script src="files/common/js/bootbox.js"></script>
<script src="files/common/js/bootbox.min.js"></script>

<script src="js/profile_Edit_applicant.js"></script>
<script src="js/dropDown.js"></script>

 <style>
html body {
	overflow-y: auto;
	height: 100%;
}
</style> 

</head>
<body>


	<div id ="logo1">
 <jsp:include page="menu.jsp" /> 
	<div class="video"> 
	<div class="center-container">
	    <div class="w3ls-agileinfo">
		</div>
		 <div class="bg-agile">
			<div class="login-form">	
				<form action="#" method="post">
			<div class="form-group">
			<label>First Name:</label>
			
			<input type="hidden" id="srNo" />
			
			
					<input type="text"  name="Name" placeholder="First Name" id="applicant__frstname" /></div>
					<div class="form-group">
			<label>Last Name:</label>
					<input type="text"  name="Name" placeholder="Last Name" id="applicant_lastname"/></div>
					<div class="form-group">
			<label>Email ID:</label><input type="email"  name="Email" placeholder="EmailID" id="applicant_mail"/></div>
					<div class="form-group">
								<label>Gender:</label> <select id="applicant_gender"
									name="recuiter_gender" class="form-control input-md"
									>
									<option value=-1>Select Gender</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</select>
							</div>
				<div class="form-group">
			    <label>Mobile No:</label>
					<input type="text"  name="Name" placeholder="Mobile No" id="profile_mobileNo" max-length="10"/></div>
					<div class="form-group">
					<label>State</label>
					<select id="recuiter_state" name="applicant_state"
									class="form-control input-md"
									onchange="showdistricts(this.value);">
									<option value=-1>Select State</option>
								</select>
					</div>
						<div class="form-group">
					<label>District</label>
					<select id="recuiter_district" name="applicant_district"
									class="form-control input-md">
									<option value=-1>Select District</option>
								</select>
					</div>
					<div class="form-group">
			<label>Profile Summary</label>
					<input type="textarea"  name="Name" placeholder="Profile Summary" id="profile_Summary" required=""/></div>
					<div class="form-group">
			<label>Key Skills</label>
					<input type="textarea"  name="Name" placeholder="Key Skills" id="profile_Skills" required=""/></div>
						<div class="form-group">
					<label>Profile</label>
					<select id="applicant_profile" name="applicant_profile"
									class="form-control input-md">
									<option value="-1">Select Profile</option>
					</select>
					</div>
					<div class="form-group" id="experienced">
			<label>Experienced</label>
					<input type="text"  name="Previous" placeholder="Previous Oraganasation" id="applicant_oraganisation" required=""/>
					<input type="text"  name="Previous" placeholder="Designation" id="applicant_designation" required=""/>
					<input type="date"  name="Previous" placeholder="Start Date" id="applicant_start" required=""/>
					<input type="date"  name="Previous" placeholder="End Date" id="applicant_end" required=""/>
					<input type="text"  name="Previous" placeholder="Notice Period" id="applicant_noticePeriod" required=""/>
					</div>
					<div class="form-group">
			<label>Project</label>
					<input type="text"  name="Previous" placeholder="Project Title" id="applicant_projectname" required=""/>
					<input type="date"  name="Previous" placeholder="Start End" id="applicant_startdate" required=""/>
					<input type="date"  name="Previous" placeholder="End Date" id="applicant_enddate" required=""/>
					<input type="textarea"  name="Previous" placeholder="Details" id="applicant_Details" required=""/>
					<input type="textarea"  name="Previous" placeholder="Roles & Responsibilities" id="applicant_roles" required=""/>
					
					<input type="textarea"  name="Previous" placeholder="Project Skills" id="applicant_projectSkill" required=""/>
					
					</div>
					<div class="form-group">
			<label>Education</label>
					<input type="text"  name="Previous" placeholder="Passout year" id="applicant_passout" required=""/>
					<input type="text"  name="Previous" placeholder="Degree" id="applicant_degree" required=""/>
					<input type="text"  name="Previous" placeholder="Marks" id="applicant_marks" required=""/>
					</div>
					<input type="button" value="Update" id="update_applicant">
				</form>	
			</div>	
		</div>
	<!-- //banner --> 
	</div>	
</div>	
</div>
</body>
</html>