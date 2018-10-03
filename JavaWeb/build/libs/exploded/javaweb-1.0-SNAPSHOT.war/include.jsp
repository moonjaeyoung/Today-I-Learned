<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-02
  Time: 오후 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 모듈단위의 재사용에 유용하다. --%>
<html>
<head>
    <title>Title</title>
    <style>
        header {
            border-bottom: solid 2px black;
        }
    </style>
</head>
<body>

<header>
    <jsp:include page="main_menu.jsp"/>
</header>

<br>
<br>
<jsp:include page="shopping.jsp"/>
<br>
<jsp:include page="news.jsp"/>
</body>
</html>
