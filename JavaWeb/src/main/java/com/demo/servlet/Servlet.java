package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Hyunwoong
 * @When : 2018-09-28 오전 12:41
 * @Homepage : https://github.com/gusdnd852
 */
@WebServlet(name = "Servlet", urlPatterns = "/servlet")
public class Servlet extends HttpServlet {

    @Override public void init() throws ServletException {
        super.init();
        // 서블릿 클래스의 초기화를 담당하는 init
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
