<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-06
  Time: 오후 6:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="withJsp" method="post">
    액션 = 요청하는 컴포넌트의 이름 : html, jsp, servlet 등등 <br>
    메소드 = 처리 방식 <br>
    <br>
    get방식 : http://ip주소:포트번호/컨텍스트/컴포넌트?id="asd"&name="홍길동" <br>
    이런식으로 정보가 url에 모두 노출됨 <br>
    <br>
    post방식 : http://ip주소:포트번호/컨텍스트/컴포넌트<br>
    컴포넌트 이름까지만 출력하여 보안이 매우 강력함.<br>
    <br>
    <br>

    <%--name 속성이 그 변수의 uid 와 같음--%>

    이름 : <input title="이름" type="text" name="name" size="10"> <br>
    <br>
    아이디 : <input title="이름" type="text" name="id" size="10"> <br>
    <br>
    비밀번호 : <input title="이름" type="password" name="password" size="10"> <br>
    <br>
    취미 : <input title="취미"  type="checkbox" name="hobby" value="독서"> 독서
    <input title="취미" type="checkbox" name="hobby" value="영화"> 영화
    <input title="취미" type="checkbox" name="hobby" value="농구"> 농구
    <input title="취미" type="checkbox" name="hobby" value="게임"> 게임
    <br>
    <br>

    수강과목 : <input title="과목" name="과목" type="radio" value="수학"> 수학
    <input title="과목" name="과목" type="radio" value="영어"> 영어
    <input title="과목" name="과목" type="radio" value="국어"> 국어
    <input title="과목" name="과목" type="radio" value="소개론"> 소개론
    <br>
    <br>

    <select title="전송 프로토콜" name="protocol">
        <option value="http">http</option>
        <option value="ftp">ftp</option>
    </select>

    <input type="submit" title="제출" value="제출">
    <input type="reset" title="초기화" value="초기화">

</form>
</body>
</html>
