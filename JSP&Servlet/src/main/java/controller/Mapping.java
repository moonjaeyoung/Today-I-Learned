package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오전 11:28
 * @Homepage : https://github.com/gusdnd852
 */
//맵핑2 : Web.xml에 url을 매핑하는 방법
public class MappingServlet extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    <servlet>
//        <servlet-name>mapping</servlet-name>
//        <servlet-class>controller.MappingServlet</servlet-class>
//    </servlet>
//    서블릿을 먼저 Web.xml에 등록을함.
//     서블릿 네임은 임의로 내가 정하는 것임
//     서블릿 클래스 태그의 내용은 모든 패키지 주소를 다 적어주어야함.
//
//    <servlet-mapping>
//        <servlet-name>mapping</servlet-name>
//        <url-pattern>/mapping</url-pattern>
//    </servlet-mapping>
//    Web.xml에 이릉미 등록된 서블릿을 매핑해줌.
//    url패턴은 반드시 슬래시로 시작해야합!
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print("맵핑 서블릿");
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
