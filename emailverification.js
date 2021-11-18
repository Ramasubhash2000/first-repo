var emailEl = document.getElementById("email");
var passwordEl = document.getElementById("password");

function emailVerification(){
	var emailEl = document.getElementById("email");
	var passwordEl = document.getElementById("password");
	var emailErrorMsgEl = document.getElementById("emailErrorMsg");
	var passwordErrorMsgEl = document.getElementById("passwordErrorMsg");

	if (passwordEl.value != "imaginnovate") {
		console.log(passwordEl.value+"...");
		passwordErrorMsgEl.classList.remove("d-none");
	} else {
		console.log(passwordEl.value+"...");
		passwordErrorMsgEl.classList.add("d-none");	
	}
	
	var emailformat = /^([a-z\.]+[a-z])@imaginnovate.com$/;
	if (emailEl.value === "") {
		console.log(emailEl.value+"...");
		emailErrorMsgEl.classList.remove("d-none");
	}
	else if (emailformat.test(emailEl.value) != true) {
		console.log(emailformat.test(emailEl.value));
		console.log(emailEl.value+"...");
		alert("Enter Valid Email Address");	
	}
	else {
		console.log(emailEl.value+"...");
		emailErrorMsgEl.classList.add("d-none");
	}
	
}

emailVerification();