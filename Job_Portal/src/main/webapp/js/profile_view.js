
$(document)
	.ready(
		function() {
			$
				.getJSON(
					"/Job_Portal/recruiterDetails/"+ sessionStorage.getItem("type"),
					function(data) {
						$
							.each(
								data.recruiterDetails,
								function(i, item) {
								
									profile=item.jobProfile.replace("%20"," ");
									
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
										/*+ "<td align=center>"
										+ item.mobile
										+ "</td>"*/
										+ "<td align=center>"
										+ item.email
										+ "</td>"
										/*+ "<td align=center>"
										+ item.gender
										+ "</td>"
										+ "<td align=center>"
										+ item.location
										+ "</td>"*/
										+ "<td align=center>"
										+ profile
										+ "</td>"
									/*	+ "<td align=center>"
										+ item.jobDesc
										+ "</td>"
										+ "<td align=center>"
										+ item.jobDate
										+ "</td>"*/
										+ "<td align=center>"
										+ item.lastDate
										+ "</td>"
									
										+ "</tr>";
									$("#recuiterTable")
										.append(tr);
								});
					});
		});






