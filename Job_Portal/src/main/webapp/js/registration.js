
$(document)
		.ready(
				function() {
					$("#reg_submit")
							.click(
									function() {
//										//alert("in");
											var register_type=$("#register_type").val();
											var reg_frstname=$("#reg_frstname").val();
											var reg_lastname=$("#reg_lastname").val();
											var reg_mail=$("#reg_mail").val();
											var reg_password=$("#reg_password").val();
											var reg_cnfrmpass=$("#reg_cnfrmpass").val();
											

											if (register_type == "-1") {

												bootbox.alert("Please Select Type");
												return false;
											}
											
											if (reg_frstname == " ") {

												bootbox.alert("Enter First Name");
												return false;
											}

												var reg_frstnamePattern = /^[a-zA-Z]{2,10}$/;
												if (!reg_frstnamePattern.test(reg_frstname)) {
													bootbox.alert('Please Enter Valid First Name !');
													return false;
												}
												
												if (reg_lastname == " ") {

													bootbox.alert("Enter Last Name");
													return false;
												}

													var reg_lastnamePattern = /^[a-zA-Z]{2,10}$/;
													if (!reg_lastnamePattern.test(reg_lastname)) {
														bootbox.alert('Please Enter Valid Last Name !');
														return false;
													}

											if (reg_mail == "") {
												//alert("insideIF");

												bootbox.alert("Please Enter Email Id");
												return false;
											} else {
												var reg_mailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z]{2,4}$/;
												if (!reg_mailPattern.test(reg_mail)) {
													bootbox.alert('Please Enter Valid Email!');
													return false;
												}
											}

											if (reg_password == "") {
												//alert("insideIF");

												bootbox.alert("Please Enter Password");
												return false;
											}

											if (reg_cnfrmpass == "") {
												//	alert("insideIF");

												bootbox.alert("Please Re-Enter Password");
												return false;
											} else if (reg_cnfrmpass != reg_password) {
												//	alert("inpasswordelse");
												bootbox.alert('Password Doesnot Match!');
												return false;
											}
											
											
											
											
											
										var data1 = {}

										data1["type"] = register_type;
										data1["firstName"] = reg_frstname;
										data1["lastName"] = reg_lastname;
										data1["email"] = reg_mail;
										data1["password"] = reg_password;
										data1["confirmPassword"] = reg_cnfrmpass;		
	                             	alert("==register--->"+ JSON.stringify(data1));
	                             	
	                             	
	                             	$.ajax({
	                        			type : "POST",
	                        			contentType : "application/json",
	                        			url : "/Job_Portal/registration",
	                        			data : JSON.stringify(data1),
	                        			dataType : "JSON",
	                        			success : function(data) {
	                        				if (data.result == "Success") {
	                        					bootbox
	                        						.confirm(
	                        							"Added Successfully!",
	                        							function(
	                        								result) {
	                        								window.location = "Register.jsp";
	                        							});
	                        				} else if (data.errorMessage == "EMAIL ALREADY EXIST PLEASE CHOOOSE ANOTHER EMAIL") {
	                        					bootbox.alert('AMR ID IS ALREADY ADDED');
	                        					return false;
	                        				} 

	                        			}
	                        		});
	                             	
	                             	
									
										/*$.ajax({
													type : "POST",
													contentType : "application/json",
													url : "/Job_Portal/registration",
													data : JSON
															.stringify(data1),
													dataType : "JSON",
													success : function(data) {
														
														alert("======?>>>>"+data.result);
														
														  if (data.result == "Success") {
															
															  bootbox
																.confirm(
																	"Register Successfully!",
																	function(
																		result) {
																		window.location = "Register.jsp";
																	});
															  
														  } else if (data.errorMessage == "EMAIL ALREADY EXIST PLEASE CHOOOSE ANOTHER EMAIL"){
																// alert("WWW");
																bootbox.alert("EMAIL ALREADY EXIST PLEASE CHOOOSE ANOTHER EMAIL");
																return false;
															}
													}
										});*/

								});
						return false;

					});
