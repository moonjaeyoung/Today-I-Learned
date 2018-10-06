package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오후 5:04
 * @Homepage : https://github.com/gusdnd852
 */
@WebServlet(urlPatterns = "/withJsp")
// url 패턴에 슬래시 안붙이면 어마어마한 에러가 발생함...
// 1시간 삽질했네... 하...
public class WithJsp extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // req.getParameter(name) : name -> value 얻어옴.
        // req.getParameterValues(name) : name -> 여러개의 value를 얻음 ex) 체크박스
        // req.getParameterNames -> 모든 name를 Enumeration으로 출력함.

        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            writer.print(req.getParameter(names.nextElement()));
        }
    }
}
