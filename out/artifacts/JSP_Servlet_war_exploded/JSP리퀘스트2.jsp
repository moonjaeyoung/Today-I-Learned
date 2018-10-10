<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-09
  Time: 오후 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String contextPath = request.getContextPath(); // 콘텍스트패스 (프로젝트 기본 url 패턴)를 얻음,
    String method = request.getMethod(); // get과 post 방식을 구분할 수 있습니다.
    HttpSession session1 = request.getSession(); // 세션객체
    String protocol = request.getProtocol(); // 프로토콜
    String requestURL = String.valueOf(request.getRequestURL()); // URL을 얻음. (URI  메소드도있음)
    String queryString = request.getQueryString(); // 쿼리를 얻음
%>

콘텍스트패스 : <%=contextPath%> <br>
메소드 : <%=method%> <br>
세션 : <%=session1%> <br>
프로토콜 : <%=protocol%> <br>
요청URL : <%=requestURL%> <br>
쿼리 : <%=queryString%> <br>

<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String[] languages = request.getParameterValues("language");
    // 다른 jsp나 서블릿으로 부터 파라미터를 받았을 경우
    // 서블릿에서 했던 것 처럼 받아올 수 있음.
    if(languages.length < 3){
        response.sendRedirect("JSPResponse.jsp");
    }
%>

<br>
<br>
아이디 : <%=id%> <br>
비밀번호 : <%=password%> <br>
사용 언어 : <%
    for (String language : languages)
        out.print(language + " ");
%><br>
</body>
</html>
