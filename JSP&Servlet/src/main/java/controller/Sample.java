package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오전 2:14
 * @Homepage : https://github.com/gusdnd852
 */
@WebServlet(name = "Sample", urlPatterns = "/sample")
// 맵핑1 : 어노테이션을 통해 맵핑하는 방법
public class Sample extends HttpServlet {
    // 서블릿은 동적 웹 어플리케이션 컴포넌트이다.
    // 클라이언트의 요청에 의해 작동하고, 응답은 http를 이용
    // MVC에서 컨트롤러로 이용됨.

    // 클라이언트가 요청(request)하면 모델에게 비즈니스 로직을 요구하고
    // 그 결과를 알맞는 뷰(JSP)에 전달하여 사용자에게 응답(response)함.

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doget, dopost 에서 super 메소드를 호출하면 405에러가 발생함.
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}