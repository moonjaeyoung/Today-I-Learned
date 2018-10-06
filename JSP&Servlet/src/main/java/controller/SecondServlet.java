package controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오후 4:40
 * @Homepage : https://github.com/gusdnd852
 */
@WebServlet(urlPatterns = "/second")
public class SecondServlet extends HttpServlet {
// 클라이언트에서 서블릿에 요청이 들어오면
// 서버에서는 서블릿 컨테이너를 만들고 요청이 있을 때 마다
// 쓰레드가 생성됨.

// 웹브라우저 -> 웹서버 -> 웹어플리케이션서버 -> 서블릿 컨테이너

// 다른 CGI 언어 -> 요청이 계속적으로 들어오면
// 객체가 계속 쌓여 부하가 굉장히 심해짐.

// 서블릿 -> 요철별로 스레드를 생성해서 처리하기 때문에
// 서버 부하가 적게 발생함 -> 속도가 빠르고 효울적으로 서버를 운영할 수 있음.

// 서블릿 생명주기 :
// 최초 요청시 객체가 만들어져서 메모리에 로딩이되고, 이후 요청시에는
// 기존의 객체를 재활용함으로써 속도가 굉장히 빠름 -> 안드로이드의 액티비티와 비슷.

// 0. 서블릿 객체 생성 (최초 1회)
// 1. init() (최초 1회)
// 2. service() / doGet() / doPost() (요청시 매번)
// 3. destroy() (마지막에 한번 : 서버 재가동, 서블릿코드수정, 리디플로이시)

    @Override public void init() throws ServletException {
        System.out.println("init 실행됨.");
    }

    @Override public void destroy() {
        System.out.println("destroy 실행");
    }

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 실행");
        resp.setContentType("text/html; charset=euc-kr");
        resp.getWriter().print("로그를 확인하세요.");
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost 실행");
    }

// 서블릿 선처리, 후처리가능
// 어노테이션을 이용
// @PostConstruct : init 실행 전에 실행
// @PreDestroy : destroy 실행 후에 실행

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy : destroy 후처리");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct : init 선처리");
    }
}
