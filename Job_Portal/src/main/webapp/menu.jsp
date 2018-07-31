<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="files/menu/css/bootstrap.css" rel="stylesheet" /> 
<link href="files/menu/css/menu.css" rel="stylesheet"/> 
<script src="files/menu/js/jquery.js"></script>

 <script src="files/menu/js/bootstrap.min.js"></script> 
<script src="js/lightbox-plus-jquery.min.js"></script>
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


	
	
<%if(user_id.equalsIgnoreCase("1")){%> 
	
	<section class="agile-navigation">
	<div class="container">
	<nav class="navbar navbar-default">
		<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
				
			</div><!--/navbar-->		
		<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				 <ul class="nav navbar-nav navbar-left">
					<li class="active"><a href="home.jsp" class="scroll">Home</a></li>
						<li class="active"><a href="profile_Edit.jsp" class="scroll">Edit Profile</a></li>
					
							<li class="active"><a href="profile_View.jsp" class="scroll">View Profile</a></li>
					<li><a href="applicantDetails.jsp" class="scroll">Applicant Details</a></li>
						<li><a href="change.jsp" class="scroll">Change Password</a></li>
					<li><a href="logout.jsp" class="scroll">Logout</a></li>
				</ul>
		 </div><!--/nav-collpase-->
	</nav>
	</div>
	</section>	

<%} if(user_id.equalsIgnoreCase("2")){%> 

	<section class="agile-navigation">
	<div class="container">
	<nav class="navbar navbar-default">
		<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
				
			</div><!--/navbar-->		
		<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				 <ul class="nav navbar-nav navbar-left">
					<li class="active"><a href="home.jsp" class="scroll">Home</a></li>
						<li class="active"><a href="profile_Edit_applicant.jsp" class="scroll">Edit Profile</a></li>
					
							<li class="active"><a href="profile_View_applicant.jsp" class="scroll">View Profile</a></li>
								<li class="active"><a href="applyJob.jsp" class="scroll">Apply Job</a></li>
								<li><a href="change.jsp" class="scroll">Change Password</a></li>
			 
					<li><a href="logout.jsp" class="scroll">Logout</a></li>
				</ul>
		 </div><!--/nav-collpase-->
	</nav>
	</div>
	</section>

 <%} %>

</body>
</html>

