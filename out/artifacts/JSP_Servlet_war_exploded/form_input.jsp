<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-06
  Time: 오후 5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>

form 태그는 서버쪽으로 정보를 전달 할 때 사용하는 태그임.
<br>
클라이언트 ---form태그---(req)---> 서버
<br>

form 태그의 종류 : <br>
<br>
1) input 태그 (속성 : type , name, value) <br>
type : 태그 종류 지정 <br>
    a) text (문자열) <br>
    b) password (*표시) <br>
    c) submit (전송시 사용) <br>
    d) checkbox (여러개 선택가능) <br>
    e) radio (한개만 선택가능) <br>
    f) reset (모든 저장사항 지움) <br>
<br>
name : 서블릿에서 이 이름을 보고 받음. <br>
value : 넘기는 값 그 자체임. <br>
<br>
<br>
예시 : <br>

<form>
    <input type="text" name="name" size="10" title="이름입력">
</form>
<br>

<form>
    <input type="password" name="pw" size="10" title="비밀번호 입력">
</form>
<br>

<form>
    <input type="submit" name="submit" value="전송" title="전송">
</form>
<br>

<form>
    <input type="reset" name="초기화" value="초기화" title="전송">
</form>
<br>

<form>
    <input type="checkbox" name="hobby" value="독서" title="체크박스">
    <input type="checkbox" name="hobby" value="요리" title="체크박스">
    <input type="checkbox" name="hobby" value="조깅" title="체크박스">
    <input type="checkbox" name="hobby" value="수영" title="체크박스">
    <input type="checkbox" name="hobby" value="취침" title="체크박스">
    <input type="checkbox" name="hobby" value="게임" title="체크박스">
</form>
다중선택가능한 체크박스
<br>
<br>
<form>
    <input type="radio" name="hobby" value="독서" title="라디오" checked="checked"> 독서
    <%--checked = "checked" 는 디폴트 체크를 정의함.--%>
    <input type="radio" name="hobby" value="요리" title="라디오"> 요리
    <input type="radio" name="hobby" value="조깅" title="라디오"> 조깅
    <input type="radio" name="hobby" value="수영" title="라디오"> 수영
    <input type="radio" name="hobby" value="취침" title="라디오"> 취침
    <input type="radio" name="hobby" value="게임" title="라디오"> 게임
</form>
하나만 선택할 수 있는 라디오

<br>
<br>

<select name="protocol" title="셀렉트">
    <option value="http">http</option>
    <option value="ftp">ftp</option>
    <option value="smtp">smtp</option>
    <option value="pop">pop</option>
</select>
리스트 형태의 셀렉트



</body>
</html>
