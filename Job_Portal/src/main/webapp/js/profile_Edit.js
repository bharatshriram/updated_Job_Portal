$(document).ready(function() {

	//alert("Before if");

	if (sessionStorage.getItem("type") == null) {

		//alert("in if");

		window.location = "index.jsp";
	}

});

$(document).ready(
		function() {
			// alert("w");

			$('link[rel=stylesheet][href~="files/table/css/style.css"]')
					.remove();
			$(".HiddenDiv").hide();
			$("#refresh").hide();
			$("#ConfigSource").hide();

			$("#profile_frstname").val(sessionStorage.getItem("firstName"));
			$("#profile_lastname").val(sessionStorage.getItem("lastName"));
			$("#profile_mail").val(sessionStorage.getItem("email"));

			$.getJSON("/Job_Portal/recruiterDetails/"
					+ sessionStorage.getItem("type"), function(data) {
				$.each(data.recruiterDetails, function(i, item) {

					if (sessionStorage.getItem("type") == item.srNo) {

						$('#srNoHidden').val(item.srNo);
						$('#profile_frstname').val(item.firstName);
						$('#profile_lastname').val(item.lastName);
						$('#profile_mail').val(item.email);
						$('#profile_mobileNo').val(item.mobile);
						/*$('#recuiter_state').val(item.mobileNo);*/
						/*$('#recuiter_state').val(item.alternateEmail);*/
						$('#profile_Description').val(item.jobDesc);
						$('#profile_postdate').val(item.jobDate);

					}

				});
			});
		});

$(document)
		.ready(
				function() {
					$("#update_recuiter")
							.click(
									function() {

										var profile_frstname = $(
												"#profile_frstname").val();

										var profile_lastname = $(
												"#profile_lastname").val();

										var profile_mail = $("#profile_mail")
												.val();

										var recuiter_gender = $(
												"#recuiter_gender").val();

										var profile_mobileNo = $(
												"#profile_mobileNo").val();

										var recuiter_state = $(
												"#recuiter_state").val();

										var recuiter_district = $(
												"#recuiter_district").val();

										var profile_Description = $(
												"#profile_Description").val();

										var recuiter_profile = $(
												"#recuiter_profile").val();

										var profile_postdate = $(
												"#profile_postdate").val();

										if (profile_frstname == "") {

											bootbox
													.alert("Please Enter First Name");
											return false;
										}

										var profile_frstnamePattern = /^[a-zA-Z]{2,10}$/;
										if (!profile_frstnamePattern
												.test(profile_frstname)) {
											bootbox
													.alert('Please Enter Valid First Name !');
											return false;
										}

										if (profile_lastname == "") {

											bootbox
													.alert("Please Enter Last Name");
											return false;
										}

										var profile_frstnamePattern = /^[a-zA-Z]{2,10}$/;
										if (!profile_frstnamePattern
												.test(profile_lastname)) {
											bootbox
													.alert('Please Enter Valid Last Name !');
											return false;
										}

										if (profile_mail == "") {
											// alert("insideIF");

											bootbox
													.alert("Please Enter Email Id");
											return false;
										} else {
											var profile_mailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z]{2,4}$/;
											if (!profile_mailPattern
													.test(profile_mail)) {
												bootbox
														.alert('Please Enter Valid Email!');
												return false;
											}
										}

										if (recuiter_gender == "-1") {
											// alert("insideIF");

											bootbox
													.alert("Please Select Gender Id");
											return false;
										}

										if (recuiter_state == "-1") {
											// alert("insideIF");

											bootbox
													.alert("Please Select State Id");
											return false;
										}

										if (recuiter_district == "Select District") {
											// alert("insideIF");

											bootbox
													.alert("Please Select District Id");
											return false;
										}

										if (profile_mobileNo == "") {

											bootbox
													.alert("Please Enter The Mobile Number");
											return false;
										} else {
											var mobile_nopattern = /^[0-9]*$/;
											if (!mobile_nopattern
													.test(profile_mobileNo)) {
												bootbox
														.alert('Enter Valid Mobile Number');
												return false;
											}
										}

										if (recuiter_profile == " ") {
											// alert("insideIF");

											bootbox
													.alert("Please Select Profile");
											return false;
										}

										if (profile_Description == " ") {

											bootbox
													.alert("Please Enter Description");
											return false;
										}

										var data1 = {}

										data1["firstName"] = profile_frstname;
										data1["lastName"] = profile_lastname;
										data1["email"] = profile_mail;
										data1["gender"] = recuiter_gender;
										data1["mobile"] = profile_mobileNo;
										/*data1["amountPackage"] = recuiter_state;*/
										data1["location"] = recuiter_district;
										data1["jobProfile"] = recuiter_profile;
										data1["jobDesc"] = profile_Description;
										data1["jobDate"] = profile_postdate;


										$
												.ajax({
													type : "POST",
													contentType : "application/json",
													url : "/Job_Portal/recruiter/edit/"
															+ sessionStorage
																	.getItem("type"),
													data : JSON
															.stringify(data1),
													dataType : "JSON",
													success : function(data) {


														if (data.result == "Success") {
															bootbox
																	.confirm(
																			"Updated successfully!",
																			function(
																					result) {

																					window.location = "profile_View.jsp";
																			});

														} else {

															alert("Error");

														}

													}
												});

									});
					return false;

				});
