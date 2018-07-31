
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/jpg" href="images/hanbit.png" />
<link rel="stylesheet" href="files/common/css/bootstrap.min.css">
<link rel="stylesheet" href="files/common/css/bootstrap.css">
<link rel="stylesheet" href="files/menu/css/menu.css">
<link rel="stylesheet" href="files/table/css/style.css">
<link rel="stylesheet" href="files/common/css/glyphicon_common.css">

<script src="files/common/js/jquery.min.js"></script>
<script src="files/common/js/bootstrap.min.js"></script>
<script src="files/common/js/bootbox.js"></script>
<script src="files/common/js/bootbox.min.js"></script>
<script src="js/applyJob.js"></script>
<script src="js/dropDown.js"></script>

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
		<div id="appTable">
			<form class="form-horizontal" method="post" action="">
				<div class="col-sm-2"></div>
				<div id="jobselect">
				<label class="col-md-2 control-label" for="job_Profile">Job
					Profile</label>
				<div class="col-sm-2">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>

						</span> <select id="job_profile" name="job_profile"
							class="form-control input-md">
							<option value=-1>Job Profile</option>
						</select>
					</div>
				</div>
				</div>


				<div class="col-sm-4 text-center" style="text-align: center;"
					id="ApplyNow">

					<input type="button" class="button blue small" value="Submit" id="joblist">

					<!-- <button class="button red small" type="button"
											onclick=history.go(0)>Cancel</button> -->
				</div>
			</form>
		</div>

												<div class="HiddenDiv">

			<div class="col-sm-4"></div>	
			<div class="col-sm-6" align="center"
				style="width: 400px; height: 29;" id="tariff">
				<h4 style="font-size: 20px">
					<i><b>List of Jobs</b></i>
				</h4>
			</div>
			<div class="col-sm-2">
				<a href="applyJob.jsp" style="text-decoration: none;"><input
					type="button" id="refresh" class="button blue small"
					value="Refresh"  style="margin-top:-20px"/></a>
			</div>

			
<div class="col-sm-1"></div>
				<div class="col-sm-12">
					<table id="recuiterstatus" class="fixed_header" style="width: 99%;margin-right:20px">
						<thead>

							<tr>
								<th align="center"><i>Sr No</i></th>
								<th align="center"><i>First Name</i></th>
								<!-- <th align="center"><i>LastName</i></th> -->
								<!-- <th align="center"><i>Mobile No</i></th> -->
								<th align="center"><i>Email ID</i></th>
								<!-- <th align="center"><i>Location</i></th> -->
								<th align="center"><i>Job Profile</i></th>
								<!-- <th align="center"><i>Job Description</i></th>
								<th align="center"><i>Job Date</i></th> -->
								<th align="center"><i>Date</i></th>
								<th align="center"><i>Apply</i></th>
							</tr>
						</thead>
						<tbody id="SerachJobTable">

						</tbody>

					</table>

				</div>
				<br />


			</div>
		</div>

</body>
</html>