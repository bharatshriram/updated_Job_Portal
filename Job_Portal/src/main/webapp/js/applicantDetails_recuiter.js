

$(document).ready(function() {
	//alert("gvhbjbb ");
	$("#fetchDetails").hide();
	
	$("#appTable").show();
	
})
	

$(document)
	.ready(
		function() {
			$
				.getJSON(
					"/Job_Portal/applieddetails/"+ sessionStorage.getItem("type"),
					function(data) {
						$
							.each(
								data.fetchDetails,
								function(i, item) {


									var tr = "<tr>"
										+ "<td align=center>"
										+ item.srNo
										+ "</td>"
										+ "<td align=center>"
										+ item.applicantfirstName
										+ "</td>"
										+ "<td align=center>"
										+ item.applicantlastName
										+ "</td>"
										+ "<td align=center>"
										+ item.applicantgender
										+ "</td>"
										+ "<td align=center>"
										+ item.applicantmobile
										+ "</td>"
										+ "<td align=center>"
										+ item.applicantemail
										+ "</td>"
										+ "<td align=center>"
										+ '<input type="button" id="view_details" name="view" value="view" onclick="getviewDetails(' + item.srNo+ ')" class="button blue small" />'
										+ "</td>"
										+ "</tr>";
									$("#recuiter_applicantTable")
										.append(tr);
								});
					});
		});




function getviewDetails(srNo,email,firstName){
	
	$("#fetchDetails").show();	
	$("#appTable").hide();
	
	
	$("#srno").append(srNo);
	$.ajax({
		type : "GET",
		//contentType : "application/json",
		url : "/Job_Portal/applieddetails/"+sessionStorage.getItem("type"),
	//	data : JSON.stringify(data1),
		dataType : "JSON",

		success : function(data) {
                    
                    $
					.each(
						data.fetchDetails,
						function(i, item) {
							$('#fetch_applicant').append("<h4 id=f_bharat>&nbsp;  &nbsp; Profile Summary  &nbsp; &emsp; &emsp;:&emsp; &emsp; &emsp; &emsp; &emsp; "+item.applicantcurrentlocation+"</h4>" +
									"<h4 id=f_bharat>Profile Summary &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.applicantprofileSummary+"</h4>"+
									"<h4 id=f_bharat>Key Skills &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.applicantkeySkill+"</h4>"+
									"<h4 id=f_bharat>Designation &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.applicantdesignaion+"</h4>"
									
									
									);
							});
                    
                    
                    $("#fetchDetails").css("height","100%");
                    $("#fetchDetails").css("overflow-y","scrollable");
		}
	
	});
	
	return false;
	
}



