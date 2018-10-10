<%@ page import="util.Encoder" %><%--
  Created by IntelliJ IDEA.
  UserBean: Administrator
  Date: 2018-10-09
  Time: 오후 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리스판스</title>
</head>
<body>


<%
    String contentType = response.getContentType();
    String charset = response.getCharacterEncoding();
    out.print(contentType + "<br>");
    out.print(charset + "<br>");
%>
</body>
</html>
