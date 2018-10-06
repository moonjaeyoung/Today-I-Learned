package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오후 9:22
 * @Homepage : https://github.com/gusdnd852
 */
public class Config_1 extends HttpServlet {
// 서블릿 초기화를 도와주는 클래스 -> ServletConfig
// web.xml 에 기술한 뒤에 사용하거나, 어노테이션에 등록후 사용.
// 여기에서는 web.xml 에 등록한 후에 사용해보겠음.

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print(getInitParameter("name") + "\n");
        writer.print(getInitParameter("id") + "\n");
        writer.print(getInitParameter("password") + "\n");
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
*     <servlet>
        <servlet-name>config1</servlet-name>
        <servlet-class>controller.Config_1</servlet-class>
        <init-param>
            <param-name>id</param-name>
            <param-value>abcd</param-value>
        </init-param>
        <init-param>
            <param-name>password</param-name>
            <param-value>12345</param-value>
        </init-param>
        <init-param>
            <param-name>name</param-name>
            <param-value>gildong</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>config1</servlet-name>
        <url-pattern>/config1</url-pattern>
    </servlet-mapping>

* */
    }
}
