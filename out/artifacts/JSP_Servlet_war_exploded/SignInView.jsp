<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-09
  Time: 오후 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>

<form action="SignInController.jsp" method="post">
    아이디
    <input title="아이디" type="text" size="10" name="id">
    <br><br>
    비밀번호
    <input title="비밀번호" type="password" size="10" name="password">
    <br><br>

    <input type="submit" value="로그인">
    <input type="reset" value="모두 지우기">

</form>
</body>
</html>
