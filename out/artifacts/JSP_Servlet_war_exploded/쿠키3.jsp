<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키3</title>
</head>
<body>
<%
    String text = "";
    out.print("삭제될 쿠키의 목록 : <br>");

    Object[] datas = Arrays.stream(request.getCookies())
            .filter(cookie -> cookie.getName().contains("Key"))
            .toArray();

    if (datas.length > 1)
        for (Object data : datas) {
            Cookie cookie = (Cookie) data;
            text = cookie.getName() + "<br>";
            out.print(text);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

    if (!text.trim().equals("")) {
%>
<script>
    setTimeout(function () {
        document.location = "쿠키3.jsp";
    }, 3000);
    setTimeout()
</script>
<%
    } else {
        out.print("<br> 쿠키 목록이 비어있습니다.");
    }
%>
<br><br>
<form action="쿠키1.jsp" method="get">
    <input type="submit" value="되돌아가기">
</form>
</body>
</html>
