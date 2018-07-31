<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link rel="stylesheet" href="files/common/css/bootstrap.css">
<link rel="stylesheet" href="files/login/css/login.css" type="text/css" media="all" />
<script src="files/common/js/jquery.min.js"></script>
<script src="files/common/js/bootstrap.min.js"></script>
<script src="files/common/js/bootbox.js"></script>
<script src="files/common/js/bootbox.min.js"></script>

<script src="js/login.js"></script>
<body>
<div id ="mainBody">
		<div class="main-content-agile">
		<div class="sub-main-w3">
			<h2>Login</h2>
			<form action="#" method="post">
				<label>UserName</label>
				<div class="pom-agile">
					<span class="fa fa-user-o" aria-hidden="true"></span>
					<input placeholder="Username" id="user_id" name="Name" class="user" type="text" required="">
				</div>
				<label>Password</label>
				<div class="pom-agile">
					<span class="fa fa-key" aria-hidden="true"></span>
					<input placeholder="Password" id="user_password" name="Password" class="pass" type="password" required="">
				</div>
				<div class="sub-w3l">
				
				</div>
				
				<div class="right-w3l">
				<input type="submit" value="LogIn" id="login">
				<br/>
				<br/>
				<div class="col-md-1"></div><div class="col-md-4"><a href='forgot.jsp' id="forgot">Forgot User?</a> </div><div class="col-md-3"></div>
				<div class="col-md-4"><a href='Register.jsp' id="register">Register</a></div>
				
					
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>