<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page </title>
<style>
h1 {
text-align=center;
}

</style>
<script type="text/javascript" >
 function passwordValidate(){
	alert("Inside Password Validation !");
	  var password = document.getElementById("pass1").value;
		var confirmPassword = document.getElementById("pass2").value;
		if (password == confirmPassword) {
			alert("passwords  match");
		} else {
			alert("passwords do not match");
		}
} 

function emailSimpleValidate(){
	alert("Inside Simple email Validation !");
	var x = document.forms["form1"]["email"].value;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
		alert("Not a valid e-mail address");
		return false;
	} else{
		alert("successfull");
	}  
}
	    
	    
function emailRegExValidate() {
	alert("Inside Reg ex email Validation !");
	var email = document.getElementById('email');
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!filter.test(email.value)) {
		alert('Please provide a valid email address');
		email.focus;
		return false;
	} else {
		alert("Email Is Correct");
	}
}	
	


</script>
</head>
<body>
<h1> User Registration Form </h1>

<form action= "registerUser.do" method="post" id="form1">
 <table>

<tr>
	<td>
	<% String errorMessage= (String) request.getAttribute("errorMessage"); 
		if (errorMessage != null) {
			out.println(errorMessage); 
		}
	%></td>
</tr>
<tr>
    <td> Email Id :<input type="text" name="emailId"  id="email" > </td>
 </tr>
 <tr>
    <td> Password: <input type="password" name="password" id="pass1" > </td>
 </tr>
 
 <tr>
   <td> Confirm Password: <input type="password" name="confirmPassword" id="pass2" ></td>
 </tr>
 
 <tr>
    <td> First Name :<input type="text" name="firstName"  id="firstname" ></td>
 </tr>
 
 <tr>
  <td> Last  Name :<input type="text" name="lastName" id="lastname" ></td>
 </tr>
 
  <tr>
   <td> gender:  <input type="radio" name="gender" value="male" id="male"> Male 
   <input type="radio" name="gender" value="female" id="female"> Female   </td>      
 </tr>

 <tr>
 <td>Phone Number :<input type="text" name="phoneNumber" id="phonenumber"></td> 
 </tr>
 <tr>
   <td>Firm Name :<input type="text" name="firmName" id="firmname"></td>

 </tr>
 <tr>
    <td>Salary  :<input type="text" name="salary" id="salary" ></td> 
 </tr>
 
 <tr>
 <td> <input type="submit" name="submit" id="submit" size="20" ">
  <input type="reset" name="reset" id="reset"  size="20"></td>
  </tr>
 </table>

</form>
 <a href="loginPage.jsp" >Go Back </a>


</body>
</html>