package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오후 12:21
 * @Homepage : https://github.com/gusdnd852
 */
@WebServlet(urlPatterns = "/doOrPost")
public class DoOrPost extends HttpServlet {
    //서블릿 하이어라키 :
    // 서블릿 인터페이스 <- 제너릭서블릿 <- HTTP서블릿 <- 우리가 사용하는서블릿

    //req = 요청처리 객체 (클라이언트에게 들어오는 정보 ex, 사용자의 email)
    //resp = 응답처리 객체 (사용자의 정보를 확인하고 "로그인 성공"을 띄워줌)
    //이 두객체는 톰캣에 의해 생성이 됨

    //Client  ---(req)---> WAS (Web Application Server)
    //Client <---(reps)--- WAS (Web Application Server)
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=euc-kr");
        // euc-kr을 쓰면 한글이 깨지지 않음.

        PrintWriter out = resp.getWriter();
        out.print("<html>");

        out.print("<head>");
        out.print("<title>서블릿 처음 배우기</title>");
        out.print("</head>");

        out.print("<body>");
        out.print("<ul>");
        out.print("<li>안녕하세요.</li>");
        out.print("<li>반가워요..</li>");
        out.print("</ul>");
        out.print("</body<");

        out.print("</html>");
        // 이렇게 html 의 형태로 리스폰스 해줄 수 있...긴한데
        // 이게 뭔 짓거리냐,,,, 차라리 html 쓸듯..
        out.close();

        // doGet vs doPost
        //Client ---(req)---> WAS
        // Client가 요청하는 방식에는 2가지가 있음
        // get 방식과 post 방식이있음

        // html 문서에서 form태그의 메소드 속성값으로 결정가능
        // 속성값 = get , 속성값 = post
        // 웹브라우저의 주소창을 이용해서 서블릿에 요청한 경우에도 doGet이 호출됨.

        // 차이점 :
        // get방식은 url에 정보가 그대로 노출되어 보안에 약함
        // ex. naver검색
        // 네이버에 good 검색시 - url에 정보가 그대로 노출됨.
        // https://search.naver.com/search.naver? ... query=good

        // post방식은 header를 이용하여 정보가 전송되어 보안에 강함
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=euc-kr");
        // euc-kr을 쓰면 한글이 깨지지 않음.

        PrintWriter out = resp.getWriter();
        out.print("<html>");

        out.print("<head>");
        out.print("<title>서블릿 처음 배우기</title>");
        out.print("</head>");

        out.print("<body>");
        out.print("<h1> Post가 호출되었습니다. </h1>");
        out.print("</body<");

        out.print("</html>");
        out.close();
    }
}

//콘텍스트패스
// 웹어플리케이션을 구분하기 위한 path
// 보통 이클립스에서는 프로젝트 이름으로 자동으로 설정됨.

