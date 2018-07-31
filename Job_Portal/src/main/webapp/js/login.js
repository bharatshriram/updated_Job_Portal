/*   Document   : login.js

    Author     : Bharat
    */


$(document).ready(function() {
	$("#login").click(function() {
		var user_id = $("#user_id").val();
		//alert("USER==>"+user_id);
		if (user_id == "") {

			bootbox
					.alert("Please Enter UserId");
			return false;
		}
		
		var user_password = $("#user_password").val();

		if (user_password == "") {

			bootbox
					.alert("Please Enter Password");
			return false;
		}
		
		var data1 = {}
		data1["username"] = user_id;
		data1["password"] = user_password;
		//alert("===>" + JSON.stringify(data1));
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/Job_Portal/login",
			data : JSON.stringify(data1),
			dataType : "JSON",

			success : function(data) {
			//	alert("data");
				if (data.result == "Success") {
					//alert("data"+data.result);
					if (data.roleId == 1) {

						sessionStorage.setItem("type", data.type);
						sessionStorage.setItem("role", data.roleId);
						sessionStorage.setItem("firstName", data.userDetails.firstName);
						sessionStorage.setItem("lastName", data.userDetails.lastName);
						sessionStorage.setItem("email", data.userDetails.email);
						var Role = data.roleId;
						
						window.location = "LoginAction.jsp?RoleID=" + Role;
					} else if (data.roleId == 2) {
						
					
						sessionStorage.setItem("type", data.type);
						sessionStorage.setItem("role", data.roleId);
						sessionStorage.setItem("firstName", data.userDetails.firstName);
						sessionStorage.setItem("lastName", data.userDetails.lastName);
						sessionStorage.setItem("email", data.userDetails.email);
						var Role = data.roleId;
						
						window.location = "LoginAction.jsp?RoleID=" + Role;
						
					}
					
				} else {
					bootbox.alert("Incorrect Password");
					return false;

				}
			}
		});
		return false;
	});
});