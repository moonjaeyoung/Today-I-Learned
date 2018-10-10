<%@ page import="java.util.Observable" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Stream" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-09
  Time: 오후 7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>태그</title>
</head>
<body>
스크립트릿, 선언, 표현식 <- 이 3개를 JSP 스크립트라고 함.
<br>
<br>
스크립트릿은 < % 자바 코드 % > 로 사용함.
<br>
<br>
<%
    int example = 50;
    do {
        example++;
        out.print(example);
%>
<br>
===========
<br>
<%
    } while (example != 200);
%>
위처럼 스크립트릿이 끊어져도 자바의 코드블럭은 유지됨.
<br>
<br>
</body>
</html>
