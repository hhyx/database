<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="applicationServe.css">
<script language="javascript" src="applicationServe.js"></script>
<title>Application Serve</title>
<script type="text/javascript">
	function myCheck()
	{
	  address = document.getElementById("address").value;
      time = document.getElementById("time").value;
      if (address=="" && time != "") {
          alert("请设置面试地点！");
          return false;
      }
      if (address != "" && time == "") {
          alert("请设置面试时间！");
          return false;
      }
      if (address == "" && time == "") {
          alert("面试地点和事件不能为空！");
          return false;
      }
      num = timecheck(time);
      if (address != "" && time != "" && num == 4) {
          return true;
      }
      if (address != "" && time != "" && num != 4) {
          if (num == 1 || num == 2) {
              alert("面试时间格式不正确！");
          }
          else if (num == 3) {
            alert("面试时间不可小于当前时间！");
          }  
          return false;
      }
    }	

    function timecheck(str) {
        if (str.length != 16) return 1;
        myDate = new Date();
        localyear = myDate.getFullYear();
        localmonth = myDate.getMonth() + 1;
        localday = myDate.getDate();
        localHours = myDate.getHours();
        localmin = myDate.getMinutes();
        localsec = myDate.getSeconds();

        year = str[0]*1000 + str[1]*100 + str[2]*10 + str[3]*1;
        month = str[5]*10 + str[6]*1;
        day = str[8]*10 + str[9]*1;
        hour = str[11]*10 + str[12]*1;
        min = str[14]*10 + str[15]*1;

        for (i = 0; i < 16; i++) {
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 9 || i == 11 || i == 12 || i == 14 || i == 15) {
                if (str[i] < '0' || str[i] > '9' ) return 2;
            }
        }

        if (year > localyear) return 4;
        else if (year < localyear) return 3;
        else {
            if (month > localmonth) return 4;
            else if (month < localmonth) return 3;
            else {
                if (day > localday) return 4;
                else if (day < localday) return 3;
                else {
                    if (hour > localHours) return 4;
                    else if (hour < localHours) return 3;
                    else {
                        if (min > localmin) return 4;
                        else return 3;
                    }
                }
            }
        }
    }
</script>
</head>
<body>
	<%
	Integer jid = Integer.parseInt(request.getParameter("jid"));
	String username = request.getParameter("username");
    %>
    <div class="navigation_bar" >
        <span class="s1">面试Interview</span>
        <span class="s2">面试管理系统</span>
        <span class="s3">&#xE165</span>
        <span class="s4">咨询邮箱：1078518902@qq.com</span>
    </div>
    <div class="total">
    <div class="f">
	<form action="/jspTest/ApplicationServlet?acceptInf=accepted&jid=<%=jid %>&username=<%=username%>"
		method="post" name="form1" onSubmit="return myCheck()">
		<div class="aj"><p>面试设置</p></div>
		<table align="center">
			<tr>
				<td class="word">地点:</td>
				<td><input placeholder="Address" type="text" name="address" id="address" /></td>
			</tr>
			<tr>
				<td class="word">时间:</td>
				<!-- 时间格式2018-06-26 18:42 -->
				<!-- js判断 -->
				<td><input placeholder="Time" type="text" name="time" id="time"></td>
			</tr>
			<td colspan="1"></td>
			<td><input type="submit" name="sub" value="新建面试" /></td>
			</tr>
		</table>
    </form>
</div>
</div>
</body>
</html>