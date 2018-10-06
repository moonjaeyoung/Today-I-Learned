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
 * @When : 2018-10-06 오후 9:57
 * @Homepage : https://github.com/gusdnd852
 */
@WebServlet(urlPatterns = "/context")
public class Context extends HttpServlet {
    // 여러 서블릿에서 데이터 공유하기 ->
    // web.xml에 있는 서블릿 콘텍스트에 데이터의 명세를 기술한 뒤 사용.

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = getServletContext().getInitParameter("contextParam1");
        String b = getServletContext().getInitParameter("contextParam2");

        PrintWriter writer = resp.getWriter();
        writer.print(a + "\n");
        writer.print(b + "\n");
    }
}
