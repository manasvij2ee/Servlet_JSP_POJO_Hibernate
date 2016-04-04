function validate() {
	alert("Inside Password Validation !");
	var password = document.getElementById("pass1").value;
	var confirmPassword = document.getElementById("pass2").value;
	if (password == confirmPassword) {
		alert("passwords  match");
	} else {
		alert("passwords do not match");
	}
}
