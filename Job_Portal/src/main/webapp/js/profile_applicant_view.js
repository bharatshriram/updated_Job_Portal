
$(document).ready(function() {
	//alert("gvhbjbb ");
	$("#fetchDetails").hide();
	
	$("#appTable").show();
	
})
$(document)
	.ready(
		function() {
		//	alert("5555555");
			$
				.getJSON(
					"/Job_Portal/applicantDetails/"+ sessionStorage.getItem("type"),
					function(data) {
						//alert("y6r6yrtyguyj");
						$
							.each(
								data.applicantDetails,
								function(i, item) {
									//alert("ionside");
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
										+ item.mobile
										+ "</td>"
										+ "<td align=center>"
										+ item.email
										+ "</td>"
										+ "<td align=center>"
										+ item.designaion
										+ "</td>"
										+"<td align=center>"
										+item.lastDate
										+"</td>"
										+ "<td align=center>"
										+ '<input type="button" id="view_details" name="view" value="view" onclick="getviewDetails(' + item.srNo+ ')" class="button blue small" />'
										+ "</td>"
									
										+ "</tr>";
									$("#applicantTable")
										.append(tr);
								});
					});
		});









function getviewDetails(srNo){
//	/alert(srNo);
	/*alert(email);*/
	$("#fetchDetails").show();	
	$("#appTable").hide();
	/*$("#name").append(applicantemail);
	
	$("#srno").append(srNo);*/
	$("#name").append(srNo);
	$.ajax({
		type : "GET",
		//contentType : "application/json",
		url : "/Job_Portal/applicantDetails/"+sessionStorage.getItem("type"),
	//	data : JSON.stringify(data1),
		dataType : "JSON",

		success : function(data) {
                    
                    $
					.each(
						data.applicantDetails,
						function(i, item) {
							$('#fetch_applicant').append("<h4 id=f_bharat>&nbsp;  &nbsp; Profile Summary  &nbsp; &emsp; &emsp;:&emsp; &emsp; &emsp; &emsp; &emsp; "+item.profileSummary+"</h4>" +
									"<h4 id=f_bharat>Key Skills &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.keySkill+"</h4>"+
									/*"<h4 id=f_bharat>Designation &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.designaion+"</h4>"+*/
									"<h4 id=f_bharat>Organisation &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.organization+"</h4>"+
									"<h4 id=f_bharat>Start Date &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.startDate+"</h4>"+
									"<h4 id=f_bharat>End Date &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.endDate+"</h4>"+
									"<h4 id=f_bharat>Job Profile &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.jobProfile+"</h4>"+
									"<h4 id=f_bharat>Notice Period &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.noticePeriod+"</h4>"+
									"<h4 id=f_bharat>Project Name &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectName+"</h4>"+
									"<h4 id=f_bharat>Start Date &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectStartEnd+"</h4>"+
									"<h4 id=f_bharat>End Date &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectEndDate+"</h4>"+
									"<h4 id=f_bharat>Project Details &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectDetails+"</h4>"+
									"<h4 id=f_bharat>Role &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectRole+"</h4>"+
									"<h4 id=f_bharat>Skills &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectSkill+"</h4>"+
									"<h4 id=f_bharat>Education &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.education+"</h4>"+
									"<h4 id=f_bharat>Passout Year &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.passoutYear+"</h4>"+
									"<h4 id=f_bharat>marks &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.marks+"</h4>"
									);
							});
                    
                    
                    $("#fetchDetails").css("height","100%");
                    $("#fetchDetails").css("overflow-y","scrollable");
		}
	
	});
	
	return false;
	
}



