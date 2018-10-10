<%@ page import="java.util.Date" %>
<%--이렇게 page import를 해주면 자바의 import문을 사용할 수 있음. --%>

<%--
  Created by IntelliJ IDEA.
  UserBean: Administrator
  Date: 2018-10-09
  Time: 오후 7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<%@ page pageEncoding="EUC-KR" %>

<html>
<head>
    <title>지시자</title>
</head>
<body>
지시자는 < %@ page / include / taglib %> 와 같이 사용함. <br>
<br>

<%out.print(new Date());%> <br>

include 지시자 <br>
아래에 샘플.jsp 를 include 했음. <br>
<br>
<br>
<%@ include file="JSP샘플.jsp" %>
<br>

</body>
</html>
