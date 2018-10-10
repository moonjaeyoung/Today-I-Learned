<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  UserBean: Administrator
  Date: 2018-10-09
  Time: 오후 7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>선언문</title>
</head>
<body>
선언문은 < %! 선언문 %> 과 같이 작성함. <br>
선언문 안에서 선언한 애트리뷰트나 메소드들은 <br>
전역적으로 사용 할 수 있음. <br>
<br>

<%!
    int a = 3;
    int b = 6;

    int sum(int a, int b) {
        return a + b;
    }
%>

<%
    out.println(a + "<br>");
    out.println(b + "<br>");
    out.println(sum(a, b) + "<br>");
    out.print(new Date());
%>

</body>
</html>
