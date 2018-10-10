<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-09
  Time: 오후 7:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>표현식</title>
</head>
<body>
<%!
    private int a = 5;
    private int b = 6;

    private int sum() {
        return a + b;
    }%>

표현식은 < %= 자바코드 %> 로 사용함. <br>
< %= ~~~ %> 이 안에 있는 리턴값을 out.print(~~~) 으로 출력함. <br>

a = <%=a%> <br>
b = <%=b%> <br>
sum = <%=sum()%> <br>

</body>
</html>
