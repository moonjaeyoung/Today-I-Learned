<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-09
  Time: 오후 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
    <script>
        if (confirm("회원정보가 없습니다. 가입하시겠습니까?")) {
        } else {
            window.location.href = "http://localhost:8080/SignInView.jsp"
        }
    </script>
</head>
<body>
회원가입 페이지입니다.
<br>
<br>
<form method="post" action="SignUpController.jsp">
    아이디 <input title="아이디" name="id" type="text" size="8">
    <br><br>

    비밀번호 <input title="비밀번호" name="password" type="password" size="8">
    <br><br>

    <input type="submit" value="회원가입">
    <input type="reset" value="모두 지우기">

</form>

</body>
</html>
