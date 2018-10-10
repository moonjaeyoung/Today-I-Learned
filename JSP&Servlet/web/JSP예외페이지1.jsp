<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-09
  Time: 오후 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ page errorPage="JSP에러페이지.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

page 지시자를 이용한 예외처리 <br>
< %@ page errorPage="JSP에러페이지.jsp" %><br>
< %@page isErrorPage="true" %> <br>
와 같이 선언하여 사용함. <br>

<% int i = 40 / 0;%> <!--에러 발생-->

</body>
</html>
