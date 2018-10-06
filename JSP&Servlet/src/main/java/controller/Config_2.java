package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오후 9:29
 * @Homepage : https://github.com/gusdnd852
 */
@WebServlet(urlPatterns = "/config2", initParams = {
        @WebInitParam(name = "name", value = "gildong"),
        @WebInitParam(name = "id", value = "abcd"),
        @WebInitParam(name = "password", value = "1234")
}) // 어노테이션을 통해 초기화 파라미터를 기술 해줌.
public class Config_2 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print(getInitParameter("name") + "\n");
        writer.print(getInitParameter("id") + "\n");
        writer.print(getInitParameter("password") + "\n");
    }
}