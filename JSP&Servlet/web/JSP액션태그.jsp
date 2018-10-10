<%@ page import="java.util.concurrent.TimeUnit" %><%--
  Created by IntelliJ IDEA.
  UserBean: Administrator
  Date: 2018-10-09
  Time: 오후 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>액션태그</title>
</head>
<body>
액션태그란 JSP 페이지 내에서 어떤 동작을 하도록 지시하는 태그. <br>
예를 들어 페이지 이동, 페이지 include 등등<br>
추후에 Bean 과 관련된 태그도 있음.<br>
<br>
1. 포워드 : 현재 이 페이지에서 다른 페이지로 전환할 떄 사용함.<br>
<br>
< jsp:forward page="SignInView.jsp"/><br>
<br>
URL 은 변하지 않는데 뷰만 해당 뷰로 포워딩 된다.<br>
포워드 액션태그 이전에 적은 내용은 뷰에 적용되지 않는다.<br>
<br> <br>
2. 인클루드 : 현재 이 아래 부분에 다른 페이지의 뷰를 포함시킨다.
<br> <br>
<jsp:include page="SignInView.jsp"/>
<br><br>

3. 파라미터 : forward 태그를 사용할 때 어떠한 값들을 함께 넘길 수 있음.
<br><br>
< jsp:forward page="SignInController.jsp"> <br>
    < jsp:param name="id" value="gusdnd852"/> <br>
    < jsp:param name="password" value="123456"/> <br>
< /jsp:forward> <br>
<br>
4. 빈 사용 태그 : 나중에 자바빈을 공부하고 더 자세하게 알아보자 !
</body>
</html>
