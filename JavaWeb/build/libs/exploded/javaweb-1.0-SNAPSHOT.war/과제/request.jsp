<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        document.cookie = "test = OK."
    </script>

</head>
<body>
<center>
    <H2>request 테스트 폼</H2>
    <HR>
    <form name = form1 method = post action = request_back.jsp>
        <table
                border = 1 cellspacing = "1" cellpadding = "5">
            <tr>
                <td>이름</td>
                <td><label>
                    <input type = text size = 10 name = username>
                </label></td>
            </tr>

            <tr>
                <td>직업</td>
                <td><label>
                    <select name = job>
                        <option selected>뮤직</option>
                        <option>회사용</option>
                        <option>전문직</option>
                        <option>학생</option>
                    </select>
                </label>
                </td>
            </tr>

            <tr>
                <td>관심분야</td>
                <td>
                    <label>
                        <input type = checkbox name = favorite value = "정치">
                    </label>정치
                    <label>
                        <input type = checkbox name = favorite value = "사회">
                    </label>사회
                    <label>
                        <input type = checkbox name = favorite value = "정보통신">
                    </label>정보통신
                </td>
            </tr>

            <tr>
                <td colspan = 2 align = center><input type = submit value = "확인">
                    <input type = reset value = "취소"></td>
            </tr>

        </table>
    </form>


</center>

</body>
</html>