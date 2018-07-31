/*   Document   : forgot.js

    Author     : Bharat
    */


$(document).ready(function() {
	$("#forget").click(function() {
		var forget_user_id = $("#forget_user_id").val();
		//	alert("USER==>"+user_id);
		
		if (forget_user_id == "") {
			bootbox.alert("Please Enter UserName");
			return false;
		}
		var data1 = {}
		data1["username"] = forget_user_id;

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/Job_Portal/forgotpassword",
			data : JSON.stringify(data1),
			dataType : "JSON",
			success : function(data) {
				//alert("Result--->"+data.result);
				if (data.result == "Success") {

					bootbox.alert("Sent Sucessfully to mail");
					return false;
					
					window.location = "index.jsp";
					
				} else {
					
					bootbox.alert("User Yet Not Register");
					return false;

					window.location = "index.jsp";

				}
			}
		});
		return false;
	});
});