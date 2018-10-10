<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-10
  Time: 오전 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>세션2</title>
</head>
<body>
<%

    Enumeration<String> sessions = session.getAttributeNames();
    while (sessions.hasMoreElements()) {
        String key = sessions.nextElement();
        out.print(key + " : " + session.getAttribute(key) + "<br>");
    }

%>
<br>
<a href="세션3.jsp">세션 삭제하기</a>
</body>
</html>
