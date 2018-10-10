<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-05
  Time: 오후 6:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<%@ page pageEncoding="EUC-KR" %>
<html>
<head>
    <title>sample</title>
</head>
<body>
1. JSP는 MVC에서 뷰로 활용됨. <br>
<br>
2. 동적 웹 어플리케이션 컴포넌트임 <br>
(HTML은 정적임, 연산등을 실행할 수 없지만 JSP는 동적임)<br>
<br>
3. 컴파일 되어 서블릿으로 변환이 됨.<br>
<br>
4. 웹 어플리케이션의 흐름<br>
<br>
1) 클라이언트(사용자)의 request(요청)<br>
2) -> 요청이 서블릿(컨트롤러)으로 전달됨<br>
3) 서블릿이 -> 모델을 호출하여 비즈니스 로직(DB와 통신등)을 실행.<br>
4) 서블릿(컨트롤러)가 이 비즈니스로직의 결과를 JSP(뷰)로 전달<br>
5) JSP(뷰)가 사용자에게 response(반응)<br>
<br>
클라이언트 -(request)-> 컨트롤러 -> 모델 -> 컨트롤러 -> 뷰 -(response)-> 클라이언트<br>
</body>
</html>
