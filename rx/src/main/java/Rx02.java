import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * @Author : Hyunwoong
 * @When : 2018-09-26 오후 10:29
 * @Homepage : https://github.com/gusdnd852
 */
public class Rx02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JLabel label = new JLabel("LABEL");
        ObservablePanel panel = new ObservablePanel();
        panel.setVisible(true);
        panel.observe((o, arg) -> label.setText(arg.toString()));
        // 어떤것이 이 패널의 액션을 관찰하게 할것인지 그것은 여기에서 선언.
        // 람다식이여서 간단해 보이지만, 사실 인터페이스의 익명 클래스를 새로 생성하여
        // 그 안에 액션을 implement 해준것이다.

        frame.setSize(200, 100);
        frame.add(panel);
        frame.add(label, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // 프레임 세팅
    }


    /**
     * @see java.util.Observable
     * @see java.util.Observer
     * 위의 코드를 참고하여 새로 만들었다.
     */
    public static class ObservablePanel extends JPanel {


        JButton button = new JButton();
        int count = 0;

        private ArrayList<Observer> obs;

        protected ObservablePanel() {
            obs = new ArrayList<>();
            button.setText("버튼");
            button.setAction(new AbstractAction() {
                @Override public void actionPerformed(ActionEvent e) {
                    ObservablePanel.this.notify(count);
                    count++;
                    // 패널 내부에서 라벨에 대한 의존성이 없지만, 그곳으로 텍스트를 전달한다.
                    // 옵저버를 메인함수에 달아놨기 때문에, 그 옵저버대로 실행하는 것이다.
                    // 이렇게 되면, 라벨은 항상 패널의 상태를 관찰하여, 패널안에 있는 버튼이 눌리면
                    // 알아서 상태를 변경하는 것 처럼 보이게 된다. (사실 인터페이스로 이어준 것 뿐임..ㅎㅎ)
                    // 이렇듯 옵저버 패턴은 행위에 대한 선언과, 실행을 분리 할 수 있다.

                    //지금 이 주석을 작성중인 actionPerformed 메소드도 AbstractAction 이라는 옵저버에 의해
                    // 어떤 내용을 실행할지, 인터페이스(추상클래스)를 통해 미리 외부에서 지정해주고,
                    // 액션의 실질적인 실행은 뷰단에서 실행되고 있는 것이다.
                }
            });
            add(button);
        }

        public void notify(Object o) {
            for (Observer observer : obs) observer.update(this, o);
        }

        public ObservablePanel observe(Observer o) {
            if (!obs.contains(o)) obs.add(o);
            return this;
        }

        public interface Observer {
            void update(ObservablePanel o, Object arg);
        }
    }
}
