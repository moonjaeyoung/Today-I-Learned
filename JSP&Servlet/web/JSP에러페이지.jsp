<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-10
  Time: 오후 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

isErrorPage="true" 를 사용하지 않으면, exception 객체 사용 불가 <br>
<br>

<% response.setStatus(200);%>
<!--
에러 스테이터스 200을 띄움
가끔 200으로 안해주면 500으로 설정될 가능 성이 있음.
 -->


<!--
500: 어떠한 연산이 잘못되어 에러가 발생했을 때
404 : 페이지를 찾을 수 없을 때
200 : 정상적인 페이지를 나타냄.
-->
당신의 에러는 : <%= exception.getMessage()%> <!--에러 메시지를 띄움-->
</body>
</html>
