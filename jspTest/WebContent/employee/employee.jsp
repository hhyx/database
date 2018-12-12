<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="entity.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/employee/employee.css">
<script src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.min.js" type='text/javascript'></script>
<script language="javascript" src="${pageContext.request.contextPath}/employee/employee.js"></script>
<title>Employee</title>
</head>
<body>

  <div class="header"> 
    <%User u = (User)session.getAttribute("user"); %>
    <div id="title">面试Interview</div>
    <div class="User">
      <p id="username">
        <%out.print(u.getUsername()); %>
        <!-- hechx6 -->
      </p>
      <div id="LogOut">
        <a class="SpecialCharacter" href="${pageContext.request.contextPath}/login/login.jsp" >&#xE7E8 注销</a> 
      </div>
    </div>
    <div id="head"></div>
  </div>
  

  <div class="MainContent">

    <div class="headerContent">
      <div class="Interview btn chosen" id="1">我的面试</div>
      <span>|</span>
      <div class="Application btn" id="2">我的申请</div>
      <span>|</span>
      <div class="CompanyName btn" id="3">公司
        <!-- 显示各个公司 -->
        <%ArrayList<Company> company = (ArrayList<Company>)request.getAttribute("company"); %>
        <div class="CompanyList hide">
          <% for (int i = 0;i < company.size();i ++) {%>
            <div class="CompanyBlock">
              <a href="/jspTest/JobShowServlet?cid=<%= company.get(i).getName() %>"><%=company.get(i).getName() %></a>
              <!-- 百度 -->
            </div>
           <% }%>
        </div>

      </div>
    </div>

    <!-- 我的面试 -->
    <div class="MyInterview show">
      <%ArrayList<Interview> interview = (ArrayList<Interview>)request.getAttribute("interview");
      ArrayList<Job> jobForInt = (ArrayList<Job>)request.getAttribute("jobForInt");

      for (int i = 0;i < interview.size();i ++) {%>
        <div class="InterviewBlock">
          <div class="LeftBlock">
            <div class="miniblock">地址</div>
            <div class="miniblock">时间</div>
            <div class="miniblock">职位名称</div>
          </div>
          <div class="RightBlock">
            <div class="address miniblock"><%out.print(interview.get(i).getAddress()); %></div>
            <div class="time miniblock"><%out.print(interview.get(i).getTime()); %></div>
            <div class="JobInfo miniblock"><%out.print(jobForInt.get(i).getName()); %></div>
          </div>
        </div>
      <% }%>
    </div>

    <!-- 我的申请 -->
    <div class="MyApplication hide">

      <%ArrayList<Application> appli = (ArrayList<Application>)request.getAttribute("application");
      ArrayList<Job> jobForApp = (ArrayList<Job>)request.getAttribute("jobForApp");
    
     	for (int i = 0;i < appli.size();i ++) {%>
        <div class="ApplicationBlock">
          <div class="LeftBlock">
            <div class="miniblock">时间</div>
            <div class="miniblock">职位名称</div>
            <div class="miniblock">状态</div>
          </div>
          <div class="RightBlock">
            <div class="time miniblock"><%out.print(appli.get(i).getTime()); %></div>
            <div class="JobInfo miniblock"><%out.print(jobForApp.get(i).getName()); %><br></div>
            <div class="State miniblock"><%out.print(appli.get(i).getAcceptInf()); %></div>
          </div>
        </div>
      <% }%>
    </div>

  </div>


</body>
</html>