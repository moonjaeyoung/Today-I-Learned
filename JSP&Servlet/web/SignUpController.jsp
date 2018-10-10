<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ page import="util.UserData" %><%--
  Created by IntelliJ IDEA.
  UserBean: Administrator
  Date: 2018-10-09
  Time: 오후 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
회원가입중 입니다.
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    UserData.get().SignUp(id, password);
    response.sendRedirect("MainView.jsp");
%>
</body>
</html>
