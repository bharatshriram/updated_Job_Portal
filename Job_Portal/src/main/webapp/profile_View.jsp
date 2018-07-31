<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Recuiter View</title>
<link rel="stylesheet" href="files/common/css/bootstrap.min.css">
<link rel="stylesheet" href="files/common/css/bootstrap.css">
<link rel="stylesheet" href="files/menu/css/menu.css">
<link rel="stylesheet" href="files/table/css/style.css">
<link rel="stylesheet" href="files/common/css/glyphicon_common.css">

<script src="files/common/js/jquery.min.js"></script>
<script src="files/menu/js/bootstrap.js"></script>
<script src="js/profile_view.js"></script>

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
			<div class="col-sm-1"></div>
				<div class="col-sm-1">
					<input type="hidden" id="myInputDevice" style="text-align: left;"
						onkeyup="myFunctionDevice()" placeholder="Search.."
						title="Type in a name">
						
						<input type="hidden" id="srno"/>
						
						<input type="hidden" id="random_no"/>
						
				</div>
			 <div class="col-sm-3">
				<input type="hidden" id="myInput"
											onkeyup="myFunction()" class="form-control input-md" placeholder="Search.."
											title="Type in a name" style="margin-top: 10px;">
				</div>
				<div class="col-sm-2" align="center" id="appointment"
					style="margin-top: 10px">
					<h4>
						<i><b>Recuiter Details</b></i>
					</h4>
				</div>
				<br/>
				
				<br/>
            <div class="col-sm-1"></div>
				<div class="col-sm-11">
					<table id="recuiterstatus" class="fixed_header" style="width: 95%">
						<thead>

							<tr>
								<th align="center"><i>Sr No</i></th>
								<th align="center"><i>First Name</i></th>
								<th align="center"><i>LastName</i></th>
								<!-- <th align="center"><i>Mobile No</i></th> -->
								<th align="center"><i>Email ID</i></th>
								<!-- <th align="center"><i>Gender</i></th>
								<th align="center"><i>Location</i></th> -->
								<th align="center"><i>Job Profile</i></th>
							<!-- 	<th align="center"><i>Job Description</i></th>
								<th align="center"><i>Post Date</i></th> -->
								<th align="center"><i>Date</i></th>
							</tr>
						</thead>
						<tbody id="recuiterTable">

						</tbody>

					</table>

				</div>
	
	
</body>
</html>