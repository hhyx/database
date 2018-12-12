<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="entity.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./employer/employer.css">
<script src="./jQuery/jquery-3.2.1.min.js" type='text/javascript'></script>
<script language="javascript" src="./employer/employer.js"></script>
<title>Employer</title>

</head>
<body>

  <div class="header"> 
    <%User u = (User)session.getAttribute("user"); %>
    <div id="title">面试Interview</div>
    <div class="User">
      <p id="username">
        <%out.print(u.getUsername()); %>
      </p>
      <div id="LogOut">
        <a class="SpecialCharacter" href="./login/login.jsp" >&#xE7E8 注销</a>
      </div>
    </div>
  </div>

    <!-- 显示面试 -->
  <div class="MainContent">
    <div class="headerContent">
      <div class="InterviewTitle btn chosen" id="1">
        面试
      </div>
      <span>|</span>
      <div class="ApplicationTitle btn" id="2">
        申请
      </div>

      <div class="CreateJob">
        <% ArrayList<Job> job_ = (ArrayList<Job>)request.getAttribute("job"); %>
        <% if (job_.size() > 0) {%>
       <a href="./addjobServe/addjobServe.jsp?cid=<%= job_.get(job_.size()-1).getCid()%>">新建工作</a>
        
        <% } else {%>
          <% ArrayList<Company> company_ = (ArrayList<Company>)request.getAttribute("company"); %>
          <%  String cid_ = company_.get(0).getName(); %>
          <a href="./addjobServe/addjobServe.jsp?cid=<%=cid_ %>">新建工作</a>

        <% }%>
      </div>
    </div>
      
    <div class="InterviewList show">
      <%ArrayList<Job> job = (ArrayList<Job>)request.getAttribute("job");
      ArrayList<Interview> interview = (ArrayList<Interview>)request.getAttribute("interview");%>
      <% for (int i = 0;i < job.size();i ++) {%>
        <div class="List">
          <div class="Position">
              <%out.print("职位：" + job.get(i).getName()); %>
          </div>
          <div class="content">
            <div class="subcontent">面试者</div>
            <div class="subcontent">面试时间</div>
            <div class="subcontent">地址</div>
          </div>

          <div class="Info">
            <%for (int j = 0;j < interview.size();j ++){ %>
              <% if (interview.get(j).getJid() == job.get(i).getJid()) {%>
                <div class="subcontent">
                  <%out.print(interview.get(j).getUsername());%>
                </div>
                <div class="subcontent">
                  <%out.print(interview.get(j).getTime());%>
                </div>
                <div class="subcontent">
                  <%out.print(interview.get(j).getAddress());%>
                </div>
              <%}%>
            <%} %>
          </div>
        </div>
      <%} %>
      

    </div>

      <!-- 申请-->
    <div class="application hide">

      <%ArrayList<Application> appli = (ArrayList<Application>)request.getAttribute("application");%>
      <% for (int i = 0;i < job.size();i ++) {%>
        <div class="List">
          <div class="Position">
            <%out.print("职位：" + job.get(i).getName()); %>
          </div>

          <div class="content">
            <div class="subcontent">申请者</div>
            <div class="subcontent">面试时间</div>
            <div class="subcontent"></div>
          </div>

          <div class="Info">
            <%for (int j = 0;j < appli.size();j ++){ %>
              <% if (appli.get(j).getJid() == job.get(i).getJid()) {%>
                <div class="row">
                  <div class="subcontent">
                    <%out.print(appli.get(j).getUsername());%>
                  </div>
                  <div class="subcontent">
                    <%out.print(appli.get(j).getTime());%>
                  </div>
                  <div class="state hide"><%out.print(appli.get(j).getAcceptInf());%></div>

                  <%if (appli.get(j).getAcceptInf().equals("Waiting") || appli.get(j).getAcceptInf().equals("waiting")) { %>
                    <div class="subcontent">
                      <button class="btnAR accept">
                        <a class="accept" href="./applicationServe/applicationServe.jsp?jid=<%=job.get(i).getJid()%>&username=<%=appli.get(j).getUsername()%>">接受</a>
                      </button> 
                      <button class="btnAR refuse">
                        <a class="refuse" href="/jspTest/ApplicationServlet?acceptInf=refused&jid=<%= job.get(i).getJid()%>&username=<%= appli.get(j).getUsername()%>">拒绝</a>
                      </button>
                    </div>
                  <% }%>
                </div>
              <% }%>
            <%} %>
          </div>
        </div>
      <% }%>

    </div>

  </div>

</body>
</html>