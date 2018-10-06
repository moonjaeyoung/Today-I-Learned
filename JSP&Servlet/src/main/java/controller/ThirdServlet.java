package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오후 5:04
 * @Homepage : https://github.com/gusdnd852
 */
@WebServlet(urlPatterns = "/third")
// url 패턴에 슬래시 안붙이면 어마어마한 에러가 발생함...
// 1시간 삽질했네... 하...
public class ThirdServlet extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
