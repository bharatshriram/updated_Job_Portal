/*

$(document).ready(function() {
	alert("gvhbjbb ");
	$("#fetchDetails").hide();
	
	$("#appTable").show();
	
})
$.ajax({
		type : "GET",
		//contentType : "application/json",
		url : "/Job_Portal/applyjob/"+sessionStorage.getItem("type"),
	//	data : JSON.stringify(data1),
		dataType : "JSON",

		success : function(data) {
                    if(data.result=="Success"){
                   
                   

	$("#fetchDetails").show();	
	$("#appTable").hide();
	$("#name").append(firstName);
	
	$("#srno").append(srNo);
	$.ajax({
		type : "GET",
		//contentType : "application/json",
		url : "/Job_Portal/fetchdetails/"+sessionStorage.getItem("type"),
	//	data : JSON.stringify(data1),
		dataType : "JSON",

		success : function(data) {
                    if()
                    $
					.each(
						data.applicantDetails,
						function(i, item) {
							$('#fetch_applicant').append("<h4 id=f_bharat>&nbsp;  &nbsp; Profile Summary  &nbsp; &emsp; &emsp;:&emsp; &emsp; &emsp; &emsp; &emsp; "+item.profileSummary+"</h4>" +
									"<h4 id=f_bharat>Key Skills &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.keySkill+"</h4>"+
									"<h4 id=f_bharat>Designation &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.designaion+"</h4>"+
									"<h4 id=f_bharat>Organisation &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.organization+"</h4>"+
									"<h4 id=f_bharat>Start Date &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.startDate+"</h4>"+
									"<h4 id=f_bharat>End Date &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.endDate+"</h4>"+
									"<h4 id=f_bharat>job Profile &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.jobProfile+"</h4>"+
									"<h4 id=f_bharat>Notice Period &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.noticePeriod+"</h4>"+
									"<h4 id=f_bharat>Project Name &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectName+"</h4>"+
									"<h4 id=f_bharat>Project Start Date &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectStartEnd+"</h4>"+
									"<h4 id=f_bharat>Project End Date &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectEndDate+"</h4>"+
									"<h4 id=f_bharat>Project Details &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectDetails+"</h4>"+
									"<h4 id=f_bharat>Role &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectRole+"</h4>"+
									"<h4 id=f_bharat>Technology Used &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.projectSkill+"</h4>"+
									"<h4 id=f_bharat>Education &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.education+"</h4>"+
									"<h4 id=f_bharat>Passout Year &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.passoutYear+"</h4>"+
									"<h4 id=f_bharat>Marks &emsp; &emsp;   :&emsp; &emsp; &emsp; &emsp; &emsp;  "+item.marks+"</h4>");
							});
                    $("#fetchDetails").css("height","100%");
                    $("#fetchDetails").css("overflow-y","scrollable");
		}
	
	});
	
	return false;
	
}
		});



*/