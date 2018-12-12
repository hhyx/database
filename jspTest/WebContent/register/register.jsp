<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="register.css">
<script language="javascript" src="register.js"></script>
<title>Register</title>
<script type="text/javascript">
      function myCheck()
      {
		username = document.getElementById("username").value;
		password = document.getElementById("password").value;
		pass2word = document.getElementById("relpassword").value;
		phonenumber = document.getElementById("phone").value;
		if (check(username, password, pass2word, phonenumber)) {
			return true;
		}
        return false;  
	  }

	  function check(username, password, pass2word, phonenumber) {
		  if (username.length > 0 && password.length > 0 && pass2word.length > 0 && phonenumber.length == 11) {
			  count = 0;
			  for (i = 0; i < 11; i++) {
				  if (phonenumber[i] >= '0' && phonenumber[i] <= '9') {
					  count++;
				  }
			  }
			  if (count == 11 && password == pass2word) {
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  
      
      function change()
      {
       var radio = document.getElementsByName("userType");
       var radioLength = radio.length;
       for(var i = 0;i < radioLength;i++)
       {
        if(radio[i].checked)
        {
        	
        	var com = document.getElementsByClassName("companytr");
			for (var j = 0;j < com.length;j ++) {
	         	if (radio[i].value == "Employee") {
					com[j].style.visibility="hidden"; 
					document.getElementById("t1").classList ="bar tpa";
            		document.getElementById("t2").classList.add("ra1a"); 
					document.getElementById("t3").classList.add("ra2a");
					document.getElementById("sm").classList.remove("sma"); 
					document.getElementById("sm").classList.add("sm");
					document.getElementById("rt").classList.remove("rta"); 
					document.getElementById("rt").classList.add("rt");
					document.getElementById("aa").classList.remove("aaa"); 
					document.getElementById("aa").classList.add("aa");
	         	} else {
					com[j].style.visibility="visible";
					document.getElementById("t1").classList ="bar tp";
            		document.getElementById("t2").classList.remove("ra1a"); 
					document.getElementById("t3").classList.remove("ra2a");
					document.getElementById("sm").classList.remove("sm");
					document.getElementById("sm").classList.add("sma");
					document.getElementById("rt").classList.remove("rt"); 
					document.getElementById("rt").classList.add("rta"); 
					document.getElementById("aa").classList.remove("aa"); 
					document.getElementById("aa").classList.add("aaa");	        
	         	}
      	 	}
        }
       }
      }
    </script>
<style>
.companytr {
	visibility: hidden;
}
</style>
</head>
<body>
	<div class="navigation_bar" >
		<span class="s1">面试Interview</span>
		<span class="s2">面试管理系统</span>
		<span class="s3">&#xE165</span>
		<span class="s4">咨询邮箱：1078518902@qq.com</span>
	</div>
	
	<div id="info" class="maindiv" align ="center">
	<p class="til">用户注册页面</p>
	<form id="f" action="/jspTest/UserRegisterServlet" method="post" name="form1"
		onSubmit="return myCheck()">
		<table id="tb" align="center">
			<tr>
				<td class="bar">&#xE13D</td>
				<td><input placeholder="Username" type="text" name="username" id="username" />
					<div id="nameError" style="display: inline;"></div></td>
					
			</tr>
			<tr>
				<td class="bar">&#xE192</td>
				<td><input placeholder="Password" type="password" name="password" id="password">
					<div id="passwordError" style="display: inline;"></div>
				</td>
			</tr>
			<tr class="mt">
				<td class="bar">&#xE1F6</td>
				<td><input placeholder="Determine password" type="password" name="relpassword" id="relpassword">
					<div id="relpasswordError" style="display: inline;"></div>
				</td>
			</tr>
			<tr>
				<td class="bar">&#xE13A</td>
				<td><input placeholder="Phone number" type="text" name="phone" id="phone">
					<div id="phoneError" style="display: inline;"></div>
				</td>
			</tr>
			<tr>
				<td class="bar">&#xE168</td>
				<td><input placeholder="Email" type="text" name="email" id="email"></td>
			</tr>
			<tr>
				<td class="bar">&#xE187</td>
				<td><input placeholder="Real name" type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td class="bar">&#xE163</td>
				<td><input placeholder="Age" type="text" name="age" id="age"></td>
			</tr>
			<tr class="companytr">
				<td class="bar">&#xEC06</td>
				<td><input placeholder="Company name" type="text" name="company" id="company"></td>
			</tr>
			<tr class="companytr">
				<td class="bar">&#xE129</td>
				<td><input placeholder="Company address" type="text" name="address" id="address"></td>
			</tr>
		</span>
			<tr>
				<td id="t1" class="bar tp tpa">&#xE125</td>
				<td id="t2" class="ra1 ra1a"><input id="employee" type="radio" style="transform: scale(1.2,1.2);" name="userType" id="userType"
					value="Employee" onchange="change();" checked="checked">Employee</td>
				<td id="t3" class="ra2 ra2a"><input id="employer" type="radio" style="transform: scale(1.2,1.2);" name="userType" id="userType"
					value="Employer" onchange="change();">Employer</td>
			</tr>
			<tr>
				<td colspan="1"></td>	
				<td><input id="sm" class="sm" type="submit" value="注册" /> <input id="rt" class="rt" type="reset"
					value="重置" /> <a id="aa" class="aa" href="../login/login.jsp" target="_blank">已有账号?登陆</a></td>
			</tr>			
		</table>
	</form>
	</div>
</body>
</html>