<%@ page import="java.util.Date" %>
<%--�̷��� page import�� ���ָ� �ڹ��� import���� ����� �� ����. --%>

<%--
  Created by IntelliJ IDEA.
  UserBean: Administrator
  Date: 2018-10-09
  Time: ���� 7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<%@ page pageEncoding="EUC-KR" %>

<html>
<head>
    <title>������</title>
</head>
<body>
�����ڴ� < %@ page / include / taglib %> �� ���� �����. <br>
<br>

<%out.print(new Date());%> <br>

include ������ <br>
�Ʒ��� ����.jsp �� include ����. <br>
<br>
<br>
<%@ include file="JSP����.jsp" %>
<br>

</body>
</html>
