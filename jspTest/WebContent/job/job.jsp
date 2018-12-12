<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="entity.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/job/job.css">
<script src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.min.js" type='text/javascript'></script>
<script language="javascript" src="${pageContext.request.contextPath}/job/job.js"></script>

<title>Job</title>


</head>
<%User u = (User)session.getAttribute("user"); %>
<body>
  
  <div class="header"> 

    <div id="title">面试Interview</div>
    <div class="User">
      <p id="username">
        <%out.print(u.getUsername()); %>
      </p>
      <div id="LogOut">
        <a class="SpecialCharacter" href="${pageContext.request.contextPath}/login/login.jsp" >&#xE7E8 注销</a>
      </div>
    </div>
    <div id="head"></div>
  </div>

  <div class="MainContent">
    <div class="headerContent">
      <div class="Job btn">工作</div>
      <div class="back SpecialCharacter"><a href="/jspTest/EmployeeShowServlet" >&#xE0A6 返回</a></div>
    </div>

    <div class="JobList">
      <%ArrayList<Job> arr = (ArrayList<Job>)session.getAttribute("job"); %>
      <% for (int i = 0;i < arr.size();i ++) {%>
        <div class="JobBlock">
          <div class="headerBlock"><%out.print(arr.get(i).getName()); %></div>

          <div class="info">
            <div class="LeftBlock">
              <div class="miniblock">工资</div>
              <div class="miniblock">描述</div>
            </div>
            <div class="RightBlock">
              <div class="Salary miniblock"><%out.print(arr.get(i).getSalary()); %></div>
              <div class="Detail miniblock"><%out.print(arr.get(i).getDesciption()); %></div>
            </div>
          </div>

          <div class="applybtn">
            <button class="button"><a class="green" href="/jspTest/ApplyServlet?jid=<%= arr.get(i).getJid() %>">申请</a></button>
          </div>
        </div>
      <% }%>
    </div>
  </div>
  
  
  
</body>
</html>