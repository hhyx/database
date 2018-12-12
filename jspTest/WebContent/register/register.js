(function() {
    
    window.onload = function() {
        username = document.getElementById("username");
        username.addEventListener("blur", usernamecheck);
        document.getElementById("password").addEventListener("blur", passwordcheck);
        document.getElementById("relpassword").addEventListener("blur", pass2wordcheck);
        document.getElementById("phone").addEventListener("blur", phonecheck);
    };

    function usernamecheck() {
        username = document.getElementById("username").value;
        if (username == "") {
            document.getElementById("nameError").innerText = "Username cannot be empty!";
        }
        else if (username != "") {
            document.getElementById("nameError").innerText = "";
        }
    }

    function passwordcheck() {
        password = document.getElementById("password").value;
        if (password == "") {
            document.getElementById("passwordError").innerText = "Password cannot be empty!";
        }
        else if (password != "") {
            document.getElementById("passwordError").innerText = "";
        }
    }

    function pass2wordcheck() {
        pass2word = document.getElementById("relpassword").value;
        if (pass2word == "") {
            document.getElementById("relpasswordError").innerText = "Please confirm the password!";
        }
        else if (pass2word != "" && pass2word != document.getElementById("password").value) {
            document.getElementById("relpasswordError").innerText = "Entered passwords differ!";   
        }
        else if (pass2word != "" && pass2word == document.getElementById("password").value) {
            document.getElementById("relpasswordError").innerText = "";
        }
        else if (pass2word == "" && pass2word == document.getElementById("password").value) {
            document.getElementById("relpasswordError").innerText = "";
        }
    }

    function phonecheck() {
        phone = document.getElementById("phone").value;
        if (phone.length == 11) {
            count = 0;
			for (i = 0; i < 11; i++) {
				if (phone[i] >= '0' && phone[i] <= '9') {
				  count++;
				}
			}
			if (count == 11) {
                document.getElementById("phoneError").innerText = "";
            } 
            else {
                document.getElementById("phoneError").innerText = "Please enter eleven digits!";
            }           
        }
        else document.getElementById("phoneError").innerText = "Please enter eleven digits!";
    }

})();