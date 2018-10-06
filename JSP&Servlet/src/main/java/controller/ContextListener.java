package controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오후 10:05
 * @Homepage : https://github.com/gusdnd852
 */
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("콘텍스트리스너 시작");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("콘텍스트리스너 종료");
    }
    // WAS의 생명주기를 감시하는 리스너
    // 리스너의 해당 메소드가 WAS의 시작과종료시에 호출됨.
    // web.xml에 기술해주어야함.
}
