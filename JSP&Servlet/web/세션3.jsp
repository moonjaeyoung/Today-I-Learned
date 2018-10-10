<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키3</title>
</head>
<body>
<%
    String text = "";
    out.print("삭제될 쿠키의 세션 : <br>");
    Enumeration<String> sessions = session.getAttributeNames();
    while (sessions.hasMoreElements()) {
        String key = sessions.nextElement();
        out.print(key + " : " + session.getAttribute(key) + "<br>");
    }

    session.invalidate();
%>
<script>
    setTimeout(function () {
        document.location = "세션3.jsp";
    }, 3000);
    setTimeout()
</script>
<br><br>
<form action="세션1.jsp" method="get">
    <input type="submit" value="되돌아가기">
</form>
</body>
</html>
