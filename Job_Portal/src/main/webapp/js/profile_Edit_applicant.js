$(document).ready(function() {

	//alert("Before if");

	if (sessionStorage.getItem("type") == null) {

		//alert("in if");

		window.location = "index.jsp";
	}

});

$(document).ready(
		function() {
			//alert("w");

			$('link[rel=stylesheet][href~="files/table/css/style.css"]')
					.remove();
			$(".HiddenDiv").hide();
			$("#refresh").hide();
			$("#ConfigSource").hide();

			$("#applicant__frstname").val(sessionStorage.getItem("firstName"));
			/*alert("999999"+$("#applicant__frstname").val(sessionStorage.getItem("firstName")));*/
			$("#applicant_lastname").val(sessionStorage.getItem("lastName"));
			$("#applicant_mail").val(sessionStorage.getItem("email"));

			$.getJSON("/Job_Portal/applicantDetails/"
					+ sessionStorage.getItem("type"), function(data) {
				$.each(data.applicantDetails, function(i, item) {

					if (sessionStorage.getItem("type") == item.srNo) {

						$('#srNo').val(item.srNo);
						
						$('#profile_mobileNo').val(item.mobile);
						$('#profile_Summary').val(item.profileSummary);
						$('#profile_Skills').val(item.keySkill);
						$('#applicant_oraganisation').val(item.organization);
						
						
						$('#applicant_designation').val(item.designaion);
						$('#applicant_noticePeriod').val(item.noticePeriod);
						$('#applicant_projectname').val(item.projectName);
						$('#applicant_Details').val(item.projectDetails);
						
						
						$('#applicant_roles').val(item.projectRole);
						$('#applicant_projectSkill').val(item.projectSkill);
						$('#applicant_passout').val(item.passoutYear);
						$('#applicant_degree').val(item.education);
						
						$('#applicant_marks').val(item.marks);

					}

				});
			});
		});



$(document)
	.ready(
		function() {
			$("#update_applicant")
				.click(
					function() {

						var applicant__frstname = $(
						"#applicant__frstname").val();

				var applicant_lastname = $(
						"#applicant_lastname").val();

				var applicant_mail = $("#applicant_mail")
						.val();

				var applicant_gender = $(
						"#applicant_gender").val();

				var profile_mobileNo = $(
						"#profile_mobileNo").val();

				var applicant_state = $(
						"#applicant_state").val();

				var applicant_district = $(
						"#applicant_district").val();

				var profile_Summary = $(
						"#profile_Summary").val();

				var profile_Skills = $(
						"#profile_Skills").val();
				var applicant_employment = $(
						"#applicant_employment").val();
						var applicant_oraganisation = $(
						"#applicant_oraganisation").val();
						var applicant_start = $(
						"#applicant_start").val();
						var applicant_end = $(
						"#applicant_end").val();
						var applicant_designation = $(
						"#applicant_designation").val();
						var applicant_noticePeriod = $(
						"#applicant_noticePeriod").val();
						var applicant_projectname = $(
						"#applicant_projectname").val();
						var applicant_startdate = $(
						"#applicant_startdate").val();
						var applicant_profile = $(
						"#applicant_profile").val();
						
						var applicant_projectSkill = $(
						"#applicant_projectSkill").val();
						
						var applicant_enddate = $(
						"#applicant_enddate").val();
						var applicant_Details = $(
						"#applicant_Details").val();
						var applicant_roles = $(
						"#applicant_roles").val();
						var applicant_passout = $(
						"#applicant_passout").val();
						var applicant_degree = $(
						"#applicant_degree").val();
						var applicant_marks = $(
						"#applicant_marks").val();

				var applicant_frstnamePattern = /^[a-zA-Z]{2,10}$/;
				if (!applicant_frstnamePattern
						.test(applicant__frstname)) {
					bootbox
							.alert('Please Enter Valid First Name !');
					return false;
				}


				var applicanr_frstnamePattern = /^[a-zA-Z]{2,10}$/;
				if (!applicanr_frstnamePattern
						.test(applicant_lastname)) {
					bootbox
							.alert('Please Enter Valid Last Name !');
					return false;
				}

				if (applicant_mail == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Email Id");
					return false;
				} else {
					var profile_mailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z]{2,4}$/;
					if (!profile_mailPattern
							.test(applicant_mail)) {
						bootbox
								.alert('Please Enter Valid Email!');
						return false;
					}
				}

				if (applicant_gender == "-1") {
					// alert("insideIF");

					bootbox
							.alert("Please Select Gender Id");
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
				
				if (applicant_state == "-1") {
					// alert("insideIF");

					bootbox
							.alert("Please Select State Id");
					return false;
				}

				if (applicant_district == "Select District") {
					// alert("insideIF");

					bootbox
							.alert("Please Select District Id");
					return false;
				}
				
				
				if (profile_Summary == " ") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Summary");
					return false;
				}
				
				

				if (profile_Skills == " ") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Profile Skills");
					return false;
				}
				
				if (applicant_profile == "-1") {
					// alert("insideIF");

					bootbox
							.alert("Please Select Profile");
					return false;
				}
				
				if (applicant_oraganisation == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Oraganisation");
					return false;
				}
				
				
				if (applicant_designation == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Designation");
					return false;
				}
				
				
				if (applicant_noticePeriod == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Notice Period");
					return false;
				}
				
				if (applicant_projectname == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Project Name");
					return false;
				}
				
				
				if (applicant_Details == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Project Details");
					return false;
				}
				
				if (applicant_roles == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Project Role");
					return false;
				}
				
				if (applicant_passout == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Passout");
					return false;
				}
				
				
				if (applicant_degree == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Degree");
					return false;
				}
				
				if (applicant_marks == "") {
					// alert("insideIF");

					bootbox
							.alert("Please Enter Marks");
					return false;
				}
				

				var data1 = {}

				data1["firstName"] = applicant__frstname;
				data1["lastName"] = applicant_lastname;
				data1["email"] = applicant_mail;
				data1["gender"] = applicant_gender;
				data1["mobile"] = profile_mobileNo;
				/*data1["amountPackage"] = recuiter_state;*/
				data1["currentlocation"] = applicant_district;
				data1["profileSummary"] = profile_Summary;
				data1["keySkill"] = profile_Skills;
				data1["designaion"] = applicant_designation;
				data1["organization"] = applicant_oraganisation;
				data1["startDate"] = applicant_start;
				data1["endDate"] = applicant_end;
				data1["jobProfile"] = applicant_profile;

				data1["noticePeriod"] = applicant_noticePeriod;
				data1["projectName"] = applicant_projectname;
				data1["projectStartEnd"] = applicant_startdate;
				data1["projectEndDate"] = applicant_enddate;
				data1["projectDetails"] = applicant_Details;
				data1["projectRole"] = applicant_roles;
				
				data1["projectSkill"] = applicant_projectSkill;

				data1["education"] = applicant_passout;
				data1["passoutYear"] = applicant_degree;
				data1["marks"] = applicant_marks;

				//alert(JSON.stringify(data1));
						$
							.ajax({
								type : "POST",
								contentType : "application/json",
								url : "/Job_Portal/applicant/edit/"+ sessionStorage.getItem("type"),
								data : JSON
									.stringify(data1),
								dataType : "JSON",
								success : function(data) {

									//	alert("Data===>"+data.result);


									if (data.result == "Success") {
										//	alert("EEqq");
										bootbox
											.confirm(
												"Added successfully!",
												function(
													result) {

													window.location = "profile_View_applicant.jsp";
												});

									} else {
										//alert("Error");

									}

								}
							});

					});
			return false;

		});