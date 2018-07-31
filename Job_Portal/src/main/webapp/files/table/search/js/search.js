
function myFunctionTarifftable() {
//	alert("--------->");
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("tarifftable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1  ){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}
function myFunctionCommunity() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("communitytable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1 || td[2].innerHTML.toUpperCase().indexOf(filter) > -1 || td[3].innerHTML.toUpperCase().indexOf(filter) > -1 || td[4].innerHTML.toUpperCase().indexOf(filter) > -1  ){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}

function myFunctionManagement() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("managementtable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1 || td[2].innerHTML.toUpperCase().indexOf(filter) > -1 || td[3].innerHTML.toUpperCase().indexOf(filter) > -1 || td[4].innerHTML.toUpperCase().indexOf(filter) > -1  ){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}


function myFunctionBlockDevice() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("blocktable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1|| td[2].innerHTML.toUpperCase().indexOf(filter) > -1  ){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}

function myFunctionCustomer() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("customertable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1 || td[2].innerHTML.toUpperCase().indexOf(filter) > -1 || td[3].innerHTML.toUpperCase().indexOf(filter) > -1 || td[4].innerHTML.toUpperCase().indexOf(filter) > -1 || td[5].innerHTML.toUpperCase().indexOf(filter) > -1 ){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}


function myFunctionaddMeter() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("AddMetertable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1 || td[2].innerHTML.toUpperCase().indexOf(filter) > -1 ){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}
function myFunctionAssignMeter() {
	//alert("-->");
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("assigntable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1 || td[2].innerHTML.toUpperCase().indexOf(filter) > -1|| td[3].innerHTML.toUpperCase().indexOf(filter) > -1){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}

function myFunctionDashDevice(){
	
	 var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("Dashtable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1 || td[2].innerHTML.toUpperCase().indexOf(filter) > -1 || td[3].innerHTML.toUpperCase().indexOf(filter) > -1 || td[4].innerHTML.toUpperCase().indexOf(filter) > -1 ){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
}
	  
function myFunctionBilling() {
	//alert("-->");
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("BillingTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1 || td[2].innerHTML.toUpperCase().indexOf(filter) > -1|| td[3].innerHTML.toUpperCase().indexOf(filter) > -1){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}

function myFunctionBillingReport(){
	
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("BillingReporttable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1 || td[2].innerHTML.toUpperCase().indexOf(filter) > -1|| td[3].innerHTML.toUpperCase().indexOf(filter) > -1){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	
	
}


 function myFunctionConfig() {
			//alert("-->");
			  var input, filter, table, tr, td, i;
			  input = document.getElementById("myInputDevice");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("configtable");
			  tr = table.getElementsByTagName("tr");
			  for (i = 0; i < tr.length; i++) {
				  
				    td = tr[i].getElementsByTagName("td");
				 
					if(td.length > 0){ // to avoid th
				 
				       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1 || td[2].innerHTML.toUpperCase().indexOf(filter) > -1|| td[3].innerHTML.toUpperCase().indexOf(filter) > -1){
				         tr[i].style.display = "";
				       } else {
				         tr[i].style.display = "none";
				       }
				 
				    }
				 }
			}

 

function myFunctionalerttable() {
alert("--------->");
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("alerttable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1  ){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}

function myFunctionuserDevice() {
//	alert("--------->");
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInputDevice");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("UserConsumptiontable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		  
		    td = tr[i].getElementsByTagName("td");
		 
			if(td.length > 0){ // to avoid th
		 
		       if (td[0].innerHTML.toUpperCase().indexOf(filter) > -1 || td[1].innerHTML.toUpperCase().indexOf(filter) > -1  ){
		         tr[i].style.display = "";
		       } else {
		         tr[i].style.display = "none";
		       }
		 
		    }
		 }
	}