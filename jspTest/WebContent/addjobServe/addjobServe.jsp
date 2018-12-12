<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="addjobServe.css">
<script language="javascript" src="addjobServe.js"></script>
<title>Add job</title>
<script type="text/javascript">
	function myCheck()
	{
	  name = document.getElementById("name").value;
	  salary = document.getElementById("salary").value;
	  desciption = document.getElementById("desciption").value;
	  if (name == "" && salary != "" && desciption!="") {
		  alert("职位不能为空！");
		  return false;
	  }
	  if (name != "" && salary == "" && desciption!="") {
		  alert("薪酬不能为空！");
		  return false;
	  }
	  if (name != "" && salary != "" && desciption =="") {
		  alert("请添加职位描述！");
		  return false;
	  }
	  if (name == "" && salary == "" && desciption!="") {
		  alert("请填写职位和薪水！");
		  return false;
	  }
	  if (name == "" && salary != "" && desciption=="") {
		  alert("请填写职位和描述！");
		  return false;
	  }
	  if (name != "" && salary == "" && desciption=="") {
		  alert("请填写薪水和描述！");
		  return false;
	  }
	  if (name == "" && salary == "" && desciption =="") {
		  alert("不能添加空职位！");
		  return false;
	  }
	  return true;  
	}
</script>
</head>
<body>
	<%
	String cid = request.getParameter("cid");
	%>
	<div class="navigation_bar" >
        <span class="s1">面试Interview</span>
        <span class="s2">面试管理系统</span>
        <span class="s3">&#xE165</span>
        <span class="s4">咨询邮箱：1078518902@qq.com</span>
	</div>
	<div class="total">
		<span>&nbsp</span>
		<div class="aj"><p>添加工作</p></div>
		<div class="f">
			<form action="/jspTest/addJobServlet?cid=<%=cid %>"
				method="post" name="form1" onSubmit="return myCheck()">
				<table align="center">
					<tr>
						<td class="word" >职位:</td>
						<td><input placeholder="Position" class="odis" type="text" name="name" id="name" /></td>
					</tr>
					<tr>
						<td class="word">薪水:</td>
						<td><input placeholder="Salary" class="odis" type="text" name="salary" id="salary"></td>
					</tr>
					<tr>
		
						<td class="word">描述:</td>
						<td><textarea class="dis"  type="text" name="desciption" id="desciption">   </textarea></td>
					</tr>
						<td colspan="1"></td>
						<td><input type="submit" value="新建工作" name="sub" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>	
</body>
</html>