<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-09
  Time: 오후 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 리퀘스트</title>
</head>
<body>

<form action="JSP리퀘스트2.jsp" method="get">
    아이디 <input type="text"
               title="아이디"
               name="id"
               size="10">
    <br> <br>
    비밀번호 <input type="password"
                title="비밀번호"
                name="password"
                size="10">
    <br><br>

    Java <input type="checkbox" title="언어" name="language" value="Java">
    Python <input type="checkbox" title="언어" name="language" value="Python">
    C language <input type="checkbox" title="언어" name="language" value="C language">
    Kotlin <input type="checkbox" title="언어" name="language" value="Kotlin">
    Html <input type="checkbox" title="언어" name="language" value="Html">
    Css <input type="checkbox" title="언어" name="language" value="Css">
    JavaScript <input type="checkbox" title="언어" name="language" value="JavaScript">

    <br><br>
    <input type="submit" value="전송">

</form>

</body>
</html>
