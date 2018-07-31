<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="icon" type="image/jpg" href="images/hanbit.png" />
<link rel="stylesheet" href="files/common/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="files/login/css/login.css" />
<link rel="stylesheet" type="text/css" href="files/table/css/style.css" />
<link rel="stylesheet" type="text/css" href="files/menu/css/menu.css" />
<link rel="stylesheet" type="text/css" href="files/common/css/nav.css" />
<script src="files/common/js/jquery.min.js"></script>
<script src="files/common/js/bootstrap.min.js"></script>
<script src="files/menu/js/menu.js"></script>
<script src="js/User_menu.js"></script>

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
	 </div>
</body>
</html>