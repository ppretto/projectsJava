<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <title>Climbimg Stairs</title> 
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 

  	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
		<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>     
      <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">  
   </head>
   
   <style type="text/css">
   
   
table.grtable {
	font-family: verdana,arial,sans-serif;
	font-size:40px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.grtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #00e600;
}
table.grtable td {
	border-width: 1px;
	padding: 30px;
	border-style: solid;
	border-color: #666666;
	background-color: #99ff99;
	
.little {
    font-family: verdana,arial,sans-serif;
	font-size:8px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;     
}
	
}
</style>
   
   <body>	
   
     	
	<form id="formStairs" method="get">
	
	<table class="grtable" align="center">
		<tr>
			<th  colspan="3">Climbing Stairs Solution</th>
		</tr>
		<tr>
			<td  colspan="2"><label for="firstname"><strong>Stairwell/Flights:(*) </strong> </label></br>
			<label class="little">
			You can input flights between 1 and 30 (times) inclusive</label></br> 
             <label class="little">Any flight can have a maximum of 20 steps</label></p>
			</td>
	   		<td  cellspacing="20"> <input type="text" id="steps" size="8"  width="2">
	   		<input type="button" value="Add" id="btnAddStep" ></br>
	   		<label id="lblsteps"> </label>
	   		
	   		 </td> 
	   		
		</tr>
		<tr>
			<td  colspan="2"> <label for="lastname"><strong>Steps per Strides: (*)</strong></label></br>			
			<label>You can stride between 1 and 4 steps inclusive</label>
			</td>	   		   	
		    <td><input type="text" id="stepsStrides" size="8" width="2"><br />	</td>
		</tr>
		
	</table>
	
	
	   <p align="center">
	      <input type="button" value="reset" id="btnReset">
	      <input type="button" value="send" id="btnSend">		     
	   </p>
	   
	   <p align="center" id="presult" >  
	      
	   </p>
	
	</form>    
      
   </body>   


<script type="text/javascript">


var stepsArray = [];



$( "#btnSend" ).click(function() {

   if(stepsArray.length == 0){   
     alert("Please fill in required fields");
     return false;   
   }

   if(validateStepsStrides()){   

 	var jsonArray = JSON.stringify(stepsArray);
 	var stepsstrides = $("#stepsStrides").val();
	urlREst = "http://localhost:8080/ClimbingStairs/rest/climbing/calc/" ;
	
	jsonString =   "{\"stepsStrides\"";
	jsonString = jsonString + ":\"";
	jsonString = jsonString +  stepsstrides;
	jsonString = jsonString +  "\"" + ",\"steps\":";
	jsonString = jsonString + JSON.stringify(stepsArray);
	jsonString = jsonString + "}";

    //alert ("jsonString" + jsonString);

   
    
    jQuery.ajax({          
      type: "POST",
         url: urlREst,
         contentType: "application/json",
         dataType: "json",
         data: jsonString,
         success: function (data, status, jqXHR) {
             alert("Result JSON: " + JSON.stringify(data));                       
             $("presult").toggle();
   			 $("#presult").html("RESULT :" + data.total);
   			 stepsArray = []; 
         },
 
         error: function (jqXHR, status) {
            alert(status);
         }
     });  
     
    }    

});

$("#btnAddStep").click(function() {

    if(stepsArray.length == 29){
      alert("Number of flights completed");
      return false;
    }

    if(!$.isNumeric($("#steps").val())){
       alert("Invalid value");
       $("#steps").val("");	 
       return false;
    }


    if(validateStep()){
       stepsArray.push($("#steps").val());  
       var strlabel =   $("#lblsteps").text() + "," + $("#steps").val();
       if($("#lblsteps").text().trim() == ""){
         strlabel = $("#steps").val();
       }else{
          strlabel = $("#lblsteps").text() + "," + $("#steps").val();
       }
	   $("#steps").val("");	   
	   $("#lblsteps").text(strlabel);
	}
});


$("#btnReset").click(function() {
  $("#steps").val("");	
  $("#stepsStrides").val("");  
  stepsArray = []; 
  $("#lblsteps").text("");
  $("#presult").html("");
});


function validateStep(){

   if($("#steps").val() >=1 &&  $("#steps").val() <= 20){
    return true;
   }
   if($("#steps").val().trim() == ""){
     alert('Please input Steps - value between 1 and 20 inclusive.');
     return false;
   } 
   $("#steps").val("");
   alert('Maximum 20 steps.');
   return false;
   	   
}

function validateStepsStrides(){

    if(!$.isNumeric($("#stepsStrides").val())){
       alert("Invalid value");
       $("#stepsStrides").val("");	 
       return false;
    }

    if($("#stepsStrides").val() >=1 &&  $("#stepsStrides").val() <= 4){
      return true;
    }
    if($("#stepsStrides").val().trim() == ""){
       alert('Please input Steps Strides.');
       return false;
    }
    alert('Maximum 4 steps.');
    $("#stepsStrides").val("");	
   	return false; 
}
	
	 
</script>

</html>