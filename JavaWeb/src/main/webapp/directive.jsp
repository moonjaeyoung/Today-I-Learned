<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-02
  Time: 오후 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--현재 페이지는 현재 컨테이너에서 처리하는데 필요한 각종 속성을 기술--%>
<%--pageEncoding -> 언어 인코딩 설정--%>

<%@ page import=" java.util.List" %>
<%--이런식으로 자바 클래스를 임포트 할수도 있고--%>

<%@ page session="true" %>
<%--세션기능 : 언제들어왔는지를 바탕으로 세션을 만들어 놓음.--%>
<%--사용자가 아무런 액션이 없으면 시간을 재서 일정 시간이 넘어가면 로그아웃되게끔 하는 속성--%>
<%--디폴트가 true 여서 따로 설정 하지 않아도 됨.--%>

<%@ page buffer="8kb" %>
<%--버퍼 : 버퍼 사이즈 설정, but 굳이 세팅안해도 8kb로 되어있음--%>

<%@ page autoFlush="true" %>
<%--버퍼가 들어오면 자동으로 플러시해서 업데이트--%>

<%@ page isThreadSafe="true" %>
<%--쓰레드 세리프 관련 설정--%>

<%@ page errorPage="index.jsp" %>
<%--에러 발생시 이 페이지로 이동함--%>

<%@ page isErrorPage="false" %>
<%--오류 처리 전용 파일,, 이 파일이 에러가 났을때 띄워주는 페이지임을 알림--%>

<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
