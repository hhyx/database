<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./info/info.css">
<title>Insert title here</title>
</head>
<body>

  <div class="header"> 
    <div id="title">面试Interview</div>
  </div>
  
  <div class="main">
    <div class="info"><%out.println(request.getAttribute("info") + "!"); %></div>
    <%
    if (request.getAttribute("info").equals("Register OK")) {
      //注册成功后，3秒后自动跳转登陆界面
      response.setHeader("refresh","1;URL=./login/login.jsp"); 
    } else if (request.getAttribute("info").equals("Register Fail")) {
      //注册失败后，3秒后自动跳转注册界面
      response.setHeader("refresh","1;URL=./register/register.jsp");
    }
    

    //登陆
    if (request.getAttribute("info").equals("Login OK")){
      //Employee类型
      if (request.getParameter("userType").equals("Employee")) {
        response.setHeader("refresh","1;URL=/jspTest/EmployeeShowServlet"); 
      } else {
        //Employer类型
        response.setHeader("refresh","1;URL=/jspTest/EmployerShowServlet"); 
      }
    } else if (request.getAttribute("info").equals("Login Fail")) { 
    %>
      <div class="subinfo red"><% out.print("User doesn't exist or password is wrong"); %></div>
    <%
      //登陆失败后，3秒后自动跳转登陆界面
      response.setHeader("refresh","1;URL=./login/login.jsp"); 
    }
    
    //申请
    if (request.getAttribute("info").equals("Apply OK")) {
      response.setHeader("refresh","1;URL=./job/job.jsp"); 
    } else if (request.getAttribute("info").equals("Apply Fail")) {
    %>
      <div class="subinfo green"><%out.print("You have applied this job"); %></div>
    <%
      response.setHeader("refresh","1;URL=./job/job.jsp"); 
    }
    
    if (request.getAttribute("info").equals("refused Application OK")) {
      
      response.setHeader("refresh","1;URL=/jspTest/EmployerShowServlet");
    } else if (request.getAttribute("info").equals("refused Application Fail")) {
      response.setHeader("refresh","1;URL=/jspTest/EmployerShowServlet");
    }
    
    if (request.getAttribute("info").equals("accepted Application OK")) {
      
      response.setHeader("refresh","1;URL=/jspTest/EmployerShowServlet");
    } else if (request.getAttribute("info").equals("accepted Application Fail")) {
      response.setHeader("refresh","1;URL=/jspTest/EmployerShowServlet");
    }
    
    if (request.getAttribute("info").equals("insert Job OK")) {
      
      response.setHeader("refresh","1;URL=/jspTest/EmployerShowServlet");
    } else if (request.getAttribute("info").equals("insert Job Fail")) {
      response.setHeader("refresh","1;URL=/jspTest/EmployerShowServlet");
    }

  %>

  </div>
</body>
</html>