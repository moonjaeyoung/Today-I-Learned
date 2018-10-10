<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-10
  Time: 오후 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>자바 빈 사용해보기</title>
</head>
<body>
<jsp:useBean id="userBean" class="model.UserBean" scope="page"/>
<!--
빈의 이름(id),
어떤 클래스인지 정의,
스코프 설정(page, session. request, application) 등
-->

<jsp:setProperty name="userBean" property="id" value="gusdnd852"/>
<jsp:setProperty name="userBean" property="password" value="123"/>
<jsp:setProperty name="userBean" property="name" value="홍길동"/>
<!-- setter와 동일-->

아이디 : <jsp:getProperty name="userBean" property="id"/> <br>
비밀번호 : <jsp:getProperty name="userBean" property="password"/> <br>
이름 : <jsp:getProperty name="userBean" property="name"/> <br>
<!-- getter와 동일-->


<!--
스코프 관련 팁 :

(1) page 영역
- page 영역은 한 번의 웹 브라우저(클라이언트)의 요청에 대해 하나의 JSP 페이지가 호출된다.
- 웹 브라우저의 요청이 들어오면 이때 단 한 개의 페이지만 대응이 된다.
- 따라서 page 영역은 객체를 하나의 페이지 내에서만 공유한다.
- page 영역은 pageContext 기본 객체를 사용한다.

(2) request 영역
- request 영역은 한 번의 웹 브라우저(클라이언트)의 요청에 대해 같은 요청을 공유하는 페이지가 대응된다.
- 이것은 웹 브라우저의 한 번의 요청에 단지 한 개의 페이지만 요청될 수 있고, 때에 따라 같은 request 영역이면 두 개의 페이지가 같은 요청을 공유할 수 있다.
- 따라서 request 영역은 객체를 하나 또는 두 개의 페이지 내에서 공유할 수 있다.
- include 액션 태그, forward 액션 태그를 사용하면 request 기본 객체를 공유하게 되어서 같은 reqeust 영역이 된다.
- 주로 페이지 모듈화에 사용된다.

(3) session 영역
- session 영역은 하나의 웹 브라우저 당 1개의 session 객체가 생성된다.
- 즉, 같은 웹 브라우저 내에서는 요청되는 페이지들은 같은 객체를 공유학 ㅔ된다.

(4) application 영역
- application 영역은 하나의 웹 어플리케이션 당 1개의 applicaition 객체가 생성된다.
- 즉, 같은 웹 어플리케이션에 요청되는 페이지들은 같은 객체를 공유한다.
-->
</body>
</html>
