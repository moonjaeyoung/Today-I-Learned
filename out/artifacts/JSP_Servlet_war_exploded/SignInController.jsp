<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ page import="util.UserData" %>
<%@ page import="model.UserBean" %><%--
  Created by IntelliJ IDEA.
  UserBean: Administrator
  Date: 2018-10-09
  Time: 오후 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body>
로그인 중입니다.
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    if (UserData.get().getUser().get(id) == null ||
            !UserData.get().getUser().get(id).equals(password)) {
        response.sendRedirect("SignUpView.jsp");
    } else {
        response.sendRedirect("MainView.jsp");
    }
%>
</body>
</html>
