<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-02
  Time: 오후 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
포워드에서 전달한 메시지1
<br>
<jsp:forward page="footer.jsp">
    <jsp:param name="email" value="test@test.test"/>
    <jsp:param name="tel" value="000-0000-0000"/>
</jsp:forward>
<br>
포워드에서 전달한 메시지2
</body>
</html>
