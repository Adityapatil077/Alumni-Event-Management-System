/**
 * 
 */
 
 function PasswordValidation(str) {
	let result = document.getElementById("password");
	let pattern = /(?=.*\d)(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%&*?])(.{8,})/g;
	let value = str.match(pattern);

	if (value != null) {
		result.style.color = "green";
	} else {
		result.style.color = "red";
	}
}

function EmailValidation(str) {
	let result = document.getElementById("email");
	let pattern = /^[a-z0-9._-]+@[a-z0-9._-]+\.[a-z]{2,3}$/g;
	let value = str.match(pattern);
	if (value != null) {
		result.style.color = "green";
	} else {
		result.style.color = "red";
	}
} 