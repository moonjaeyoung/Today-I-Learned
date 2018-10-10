<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.String" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-09
  Time: 오후 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키2</title>
</head>
<body>
<%
    for (Object data : Arrays.stream(request.getCookies())
            .filter(cookie -> cookie.getName().contains("Key"))
            .map(cookie -> cookie.getName() + " : " + cookie.getValue())
            .toArray()) out.print(data + "<br>");
%>

<a href="쿠키3.jsp"><h4>쿠키 삭제</h4></a>

</body>
</html>
