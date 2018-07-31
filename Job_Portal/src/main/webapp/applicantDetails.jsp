<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View</title>
<link rel="stylesheet" href="files/common/css/bootstrap.min.css">
<link rel="stylesheet" href="files/common/css/bootstrap.css">
<link rel="stylesheet" href="files/menu/css/menu.css">
<link rel="stylesheet" href="files/table/css/style.css">
<link rel="stylesheet" href="files/common/css/glyphicon_common.css">

<script src="files/common/js/jquery.min.js"></script>
<script src="files/menu/js/bootstrap.js"></script>
<script src="js/applicantDetails_recuiter.js"></script>

</head>
<body id="logo1">

		<%
		String user_id = (String) session.getAttribute("roleID");

		System.out.println("======>" + user_id);

	%>

	<%
		if (null == user_id) {
			response.sendRedirect("index.jsp");
		}
	%>

	<jsp:include page="menu.jsp" />
	
		<div id="appTable">
			<div class="col-sm-5"></div>
				
				<div class="col-sm-2" align="center" id="appointment"
					style="margin-top: 10px">
					<h4>
						<i><b>Applicant Details</b></i>
					</h4>
				</div>
				<br /> <br /> <br />

				<div class="col-sm-1"></div>

				<div class="col-sm-11">
				
					<table id="applicantstatus" class="fixed_header" style="width: 95%">
						<thead>

							<tr>
								<th align="center"><i>Sr No</i></th>
								<th align="center"><i>First Name</i></th>
								<th align="center"><i>Last Name</i></th>
								<th align="center"><i>Gender</i></th>
								<th align="center"><i>Mobile No</i></th>
								<th align="center"><i>Email</i></th>
								<th align="center"><i>View</i></th>
							</tr>
						</thead>
						<tbody id="recuiter_applicantTable">

						</tbody>

					</table>

				</div>
			</div>
		
		<div id="fetchDetails">
			<div align="Center" id="Detailss" style="margin-top: 0px;margin-left:-20px">
			<h4 class="col-md-5"></h4>
				<h4 class="col-md-3">
					Applicant MailID:<span id="name"></span>
				
					<!-- &emsp; User Name:<span id="userNamePatient"></span> -->
				</h4>
				
			</div>
			<br/>
			<div id="fetch_applicant"></div>
		

			
		</div></div>

	
</body>
</html>