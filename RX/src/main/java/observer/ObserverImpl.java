package observer;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오전 2:28
 * @Homepage : https://github.com/gusdnd852
 */
public class ObserverImpl {
    // 기능에 대한 선언과 실행의 분리가 이루어짐.
    public static void main(String[] args) {
        Example example = new Example();
        example.observe(input -> System.out.println(input.toString()));
        // 기능의 선언

        example.click();
        example.click();
    }

    private static class Example extends ObserverPattern {
        void click() {
            notify("클릭했습니다.");
            // 기능의 실행
        }
    }
}
