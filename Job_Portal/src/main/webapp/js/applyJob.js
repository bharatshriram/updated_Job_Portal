/*   Document   : ApplyJob.js

    Author     : Bharat
    */

$(document).ready(function() {
	//alert("w");
	$('link[rel=stylesheet][href~="files/table/css/style.css"]').remove();
	$(".HiddenDiv").hide();
	$("#refresh").hide();
});

$(document).ready(function() {
	$("#joblist").click(function() {
		var job_profile = $("#job_profile").val();
		if (job_profile == "-1") {

			bootbox
				.alert("Please Select Job Profile");
			return false;
		}



		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/Job_Portal/fetchdetails/" + sessionStorage.getItem("type") + "/" + job_profile,
			dataType : "JSON",
			success : function(data) {


				$("#jobselect")
					.hide();
				$("#joblist")
					.hide();

				$("#refresh").show();
				$(".HiddenDiv").show();
				var Link = "<link rel='stylesheet'  href='files/table/css/style.css' type='text/css' />"
				$('head').append(Link);

				$
					.each(
						data.fetchDetails,
						function(
							i,
							item) {

							var jobProfile=item.jobProfile.replace("%20"," ");
							
							var tr = "<tr>"
								+ "<td align=center>"
								+ item.srNo
								+ "</td>"
								+ "<td align=center>"
								+ item.firstName
								+ "</td>"
								/*+ "<td align=center>"
								+ item.lastName
								+ "</td>"*/
								/*	+ "<td align=center>"
									+ item.mobile
									+ "</td>"*/
								+ "<td align=center>"
								+ item.email
								+ "</td>"
								/*+ "<td align=center>"
								+ item.location
								+ "</td>"*/
								+ "<td align=center>"
								+ jobProfile
								+ "</td>"
								/*+ "<td align=center>"
								+ item.jobDesc
								+ "</td>"
								+ "<td align=center>"
								+ item.jobDate
								+ "</td>"*/
								+ "<td align=center>"
								+ item.lastDate
								+ "</td>"
								+ "<td align=center>"
								+ "<input type=button value=apply onClick='getapplyJob(\""
								+ item.srNo+","+ item.jobProfile+"\")'/>"
								+ "</td>"
								+ "</tr>";
							$(
								"#SerachJobTable")
								.append(
									tr);
						});
			}
		});
		return false;
	});
});
	
	function getapplyJob(alldata) {
		var dataSplit = alldata.split(",");
		var srNo = dataSplit[0];
		var profile = dataSplit[1];

		$.ajax({
			type : "GET",
			//contentType : "application/json",
			url : "/Job_Portal/applyjob/" + sessionStorage.getItem("type") + "/" + srNo + "/" + profile,
			//	data : JSON.stringify(data1),
			dataType : "JSON",

			success : function(data) {
				alert("data" + data.result);
				if (data.result == "Success") {
					bootbox
						.alert("Applied Succesfully");
					return false;
				}
			}
		});

		return false;

	}




