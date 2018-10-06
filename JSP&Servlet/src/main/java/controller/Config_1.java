package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오후 9:22
 * @Homepage : https://github.com/gusdnd852
 */
@WebServlet(urlPatterns = "/four")
public class FourthServlet extends HttpServlet {
// 서블릿 초기화를 도와주는 클래스 -> ServletConfig
// web.xml 에 기술한 뒤에 사용하거나, 어노테이션에 등록후 사용.


    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
