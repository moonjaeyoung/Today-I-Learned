<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<HTML>
<HEAD>
    <TITLE>ch06 : request_result.jsp</TITLE></HEAD>
<BODY>
<div align="center">
    <H2>REQUEST TEST RESULT - 1</H2>

    <HR>
    <table border=1 cellspacing="1" cellpadding="5">
        <tr>
            <td>이름</td>
            <td><%=request.getParameter("username")%> </td>
        <tr>
            <td>직업</td>
            <td><%=request.getParameter("job")%></td>
        <tr>
            <td>관심분야</td>
            <td>
                    <%
	String favorites[] = request.getParameterValues("favorite");

	for(String favorite: favorites) {
		out.println(favorite+"<BR>");
	}
%>
    </table>
    <HR>
    <H2>REQUEST TEST RESULT - 2</H2>
    <table border=0><tr><td>
        1. Client IP Address : <%= request.getRemoteAddr() %> <BR>
        2. Request Method : <%= request.getMethod() %> <BR>
        <%
            Cookie cookie[] = request.getCookies();
        %>
        3. <%= cookie[0].getName() %> 에 설정된 쿠키값 : <%=cookie[0].getValue() %><BR>
        4. Protocol : <%= request.getProtocol() %>
    </td></tr>
    </table>
</div>
</BODY>
</HTML>