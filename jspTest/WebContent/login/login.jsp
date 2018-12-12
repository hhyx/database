<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="login.css">
<script language="javascript" src="login.js"></script>
<title>Login</title>
</head>
<body>
    <div class="navigation_bar" >
        <span class="s1">面试Interview</span>
        <span class="s2">面试管理系统</span>
        <span class="s3">&#xE165</span>
        <span class="s4">咨询邮箱：1078518902@qq.com</span>
    </div>
    <p class="til">用户登陆页面</p>
    <div>
        <script  type="text/javascript">
          function sub() {
            username = document.getElementsByName("username")[0].value;
            password = document.getElementsByName("password")[0].value;
            if (username.length == 0 || password.length == 0){
							if (username.length == 0 && password.length == 0) {
								alert("请输入用户名和密码！")
								return false;
							}
              alert("用户名或密码不能为空!")
              return false;
            }
            else{
              return true;
            }
          }   
        </script>
        <form method="post" action="/jspTest/UserLoginServlet" name="f" onsubmit="return sub();">  
            <table align="left">
                <tr>
                    
                    <td>
                        <div class="d1" name="nameinput">
                            <span class="p1">&#xE13D</span>
                            <input class="un" type="text" name="username" id="username" placeholder="Usename">
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>
                        <div class="d2">
                            <span class="p1">&#xE1F6</span>
                            <input class="pw" type="password" name="password" id="password" placeholder="Password">
                        </div>
                    </td>
                </tr>

                <tr>
                    <td><input class="tp1" style="transform: scale(1.2,1.2);" type="radio" name="userType" id="userType" value="Employee"  checked="checked">Employee</td>
                    <td><input class="tp2" style="transform: scale(1.2,1.2);" type="radio" name="userType" id="userType" value="Employer">Employer</td>
                </tr>

                <tr>
                    <td colspan="1"></td>
                    <td>
                        <input name="subm" class="sm1" title="submit" type="submit" value="&#xE0AB"/>
                        <input name="res" class="sm2" title="reset" type="reset" value="&#xE149"/>
                        <div class="sm3"><a title="register" class="link" href="../register/register.jsp" target="_blank" title="register">&#xE187</a></div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <hr/>
    <p class="sug">建议系统在火狐、谷歌或IE8版本以上使用</p>
</body>
</html>