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
    <title>세션</title>
</head>
<body>
세션은 쿠키처럼 브라우저와 서버사이에 관계를 유지하기 위해 사용 <br>
쿠키와 달리 클라이언트가 아닌 서버에 객체상으로 존재함.<br>
따라서 세션은 서버에서만 접근이 가능하여 보안이 좋고 용량의 한계가 없음<br>
세션 객체는 각각 브라우저마다 생성됨.<br>

<br><br>

setAttribute : 데이터 저장 <br>
getAttribute : 데이터 얻음 <br>
getAttributeNames : 어트리뷰트의 키값을 모두 읽어옴. <br>
getId : 세션마다 지정된 고유한 키값을 얻어옴 <br>
isNew : 최초 생성된 세션인지 이전에 생성됐었는지 알려줌 <br>
getMaxInactiveInterval : 세션의 유효시간을 얻음 <br>
removeAttribute : 특정 데이터 삭제 <br>
invalidate : 모든 데이터 삭제 <br>
<br><br>

<%
    session.setAttribute("name", "홀길동");
    session.setAttribute("age", 30);
%>
<a href="세션2.jsp"><h2>세션보기</h2></a>
</body>
</html>
