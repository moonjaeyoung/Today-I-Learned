/**
 * @Author : Hyunwoong
 * @When : 2018-09-26 오후 10:25
 * @Homepage : https://github.com/gusdnd852
 */
public class Rx01 {
    //Rx를 알기전에 Rx프로그래밍을 하기 위한 토대로, 옵저버 패턴에 대해서 먼저 알아보자.

    public static void main(String[] args) {
        Button button = new Button();
        button.setObserver(() -> System.out.println("안녕하세요"));
        button.click();

        // 기본적인 옵저버 패턴의 방식.
        // 인터페이스로 미리 액션이 발생했을 때, 어떤 행동을 할 것인지 지정해놓은 뒤에
        // 아예 다른곳에서 이것의 액션을 실행할 수 있다.
        // 의존성 없이 진행하는 코드는 다음 클래스인 Rx02에서...
    }

    public static class Button {
        private Observer observer;

        public void setObserver(Observer observer) {
            this.observer = observer;
        }

        public void click() {
            observer.call();
        }

        public interface Observer {
            void call();
        }
    }
}
