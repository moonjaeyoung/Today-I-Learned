<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-09
  Time: 오후 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키</title>
</head>
<body>
쿠키 : <br>
브라우저에서 서버로 데이터 리퀘스트 하면, 알맞은 로직을 수행 후 데이터를 <br>
웹브라우저에 리스판스 해준다. 그리고 서버는 브라우저와의 관계를 종료한다. <br>
<br>
이렇게 브라우저에서 응답후 관계를 끊는 것이 HTTP 프로토콜의 특징 ! <br>
연결이 끊겼을 때 어떠한 정보를 지속적으로 유지하기 위한 수단으로 쿠키를 사용 <br>
한마디로 임시데이터와 같음 ! <br>
<br>
쿠키는 서버에서 생성하나, 클라이언트에 데이터를 저장함. <br>
서버에서 요청 할 때마다 쿠키의 속성값을 참조하면 됨. <br>
쿠키나 세션이 없다면 페이지를 이동할때마다 로그인을 해야함. <br>
용량 제한은 4kb, 300개 까지 정보를 가질 수 있음 <br>
<br> <br>
cookie.setMaxAge() : 쿠키의 유효기간을 설정함 <br>
cookie.setPath() : 쿠키가 어느 디렉토리 까지 사용할 수 있게 하는지 설정<br>
<h4>cookie.setValue() : 쿠키에 값을 넣습니다.</h4> <br>
<br>
cookie.get ~~() : 세터와 동일 <br>
cookie.getVersion() : 쿠키의 버전을 얻음.<br>
<br>
<%
    Cookie cookie1 = new Cookie("Key1", "Value");
    cookie1.setMaxAge(60 * 60); // 한시간

    Cookie cookie2 = new Cookie("Key2", "Value");
    cookie2.setMaxAge(60 * 60); // 한시간

    response.addCookie(cookie1);
    response.addCookie(cookie2);
    // 쿠키는 서버에서 만들어 지는 것이기 때문에 response 해줘야함.
%>

<a href="쿠키2.jsp"><h2>쿠키 보기</h2></a>

</body>
</html>
