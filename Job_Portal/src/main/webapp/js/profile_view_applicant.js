$(document).ready(function() {

	alert("Before if"+sessionStorage.getItem("firstName"));

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

			$("#applicant__frstname").val(sessionStorage.getItem("firstName"));
			$("#applicant_lastname").val(sessionStorage.getItem("lastName"));
			$("#applicant_mail").val(sessionStorage.getItem("email"));

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
			$
				.getJSON(
					"/Job_Portal/applicantDetails/",
					function(data) {
						$
							.each(
								data.applicantDetails,
								function(i, item) {


									var tr = "<tr>"
										+ "<td align=center>"
										+ item.srNo
										+ "</td>"
										+ "<td align=center>"
										+ item.firstName
										+ "</td>"
										+ "<td align=center>"
										+ item.lastName
										+ "</td>"
										+ "<td align=center>"
										+ item.email
										+ "</td>"
										+ "<td align=center>"
										+ item.mobile
										+ "</td>"
										+ "<td align=center>"
										+ item.currentlocation
										+ "</td>"
										+ "<td align=center>"
										+ item.profileSummary
										+ "</td>"
										+ "<td align=center>"
										+ item.keySkill
										+ "</td>"
										+ item.designaion
										+ "</td>"
										+ "<td align=center>"
										+ item.organization
										+ "</td>"
										+ "<td align=center>"
										+ item.currentlocation
										+ "</td>"
										+ "<td align=center>"
										+ item.profileSummary
										+ "</td>"
										+ "<td align=center>"
										+ item.keySkill
										+ "</td>"
										+ "<td align=center>"
										+ '<input type="button" id="view_details" name="view" value="view" onclick="getviewDetails(' + item.srNo + ',' + item.randomID +')" class="button blue small" />'
										+ "</td>"
										+ "</tr>";
									$("#appointTable")
										.append(tr);
								});
					});
		});


