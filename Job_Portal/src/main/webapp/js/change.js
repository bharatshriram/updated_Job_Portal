/**
 * 
 */

$(document).ready(function() {
	
	$("#email").val(sessionStorage.getItem("email"));
});

$(document).ready(function() {
	$("#ChangePassword").click(function() {
		
		var email = $("#email").val();
		var previousPassword = $("#previousPassword").val();
		
		

		var newpassword = $("#newpassword").val();
		// var mode = "add";
		var confirmPassword = $("#confirmPassword").val();

		if (previousPassword == "") {
			//alert("insideIF");

			bootbox.alert("Please Enter Previous Password");
			return false;
		}

		if (newpassword == "") {
			//alert("insideIF");

			bootbox.alert("Please Enter New Password");
			return false;
		}

		if (confirmPassword == "") {
			//	alert("insideIF");

			bootbox.alert("Please Re-Enter Password");
			return false;
		} else if (confirmPassword != newpassword) {
			//	alert("inpasswordelse");
			bootbox.alert('Password Doesnot Match !');
			return false;
		}


		var data1 = {}

		data1["userID"] = email;
		data1["userPassword"] = previousPassword;
		data1["newPassword"] = newpassword;
		data1["confirmPassword"] = confirmPassword;
		data1["userRole"] = sessionStorage.getItem("role");

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/Job_Portal/user/edit/"+sessionStorage.getItem("type"),
			data : JSON.stringify(data1),
			dataType : "JSON",
			success : function(data) {
				//alert("data.result==>"+data.result);

				if (data.result == "Success") {
					bootbox
						.confirm(
							"Updated Successfully!",
							function(
								result) {
								window.location = "change.jsp";
							});

				} else {
					window.location = "change.jsp";
				}

			}
		});

	});
	return false;

});