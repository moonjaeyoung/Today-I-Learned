package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오전 3:36
 * @Homepage : https://github.com/gusdnd852
 */
public class FirstCitizen {
    // 어떠한 요소가 return 값이 될 수 있고, 매개변수로 들어갈 수 있으며, 어떠한 자료구조에 담길 수 있으면,
    // 그 요소를 1등시민라고 한다. 이전 까지 자바에서 1등시민은 오로지 객체 뿐이였다.
    // 그러나 자바8 이후로 람다식, 메소드 레퍼런스, 함수형 인터페이스 등이 도입되면서 이제 함수(사실은 인터페이스로 구현된)도
    // 자바에서 1등시민이 될 수 있고, 이는 매우 강력한 효과를 낼 수 있다.

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int res1 = calculator.oldStyle(4, 5, "*");
        int res2 = calculator.oldStyle(res1, 2, "/");
        int res3 = calculator.oldStyle(res2, 6, "+");
        // 많은 if 스테이트가 필요하고 조건에 벗어나면 결과도 제대로 출력 못함.
        System.out.println(res3);

        int resFunction = calculator.useFunction(4, 5, (a, b) -> (a * b / 2) + 6);
        // 함수가 매개변수로 들어가기 떄문에 복잡한한 연산도 처리 가능하고 에러도 없음
        System.out.println(resFunction);


        //함수를 자료구조에 담을 수 있음.
        BiFunction<Integer, Integer, Integer> mean = (a, b) -> a + b / 2;
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> divide = (a, b) -> a / b;
        BiFunction<Integer, Integer, Integer> sub = (a, b) -> a - b;
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        List<BiFunction<Integer, Integer, Integer>> funcList = Arrays.asList(mean, multiply, divide, sub, add);

        int resDataStructuer1 = calculator.useFunction(100, 20, funcList.get(0));
        int resDataStructuer2 = calculator.useFunction(100, 20, multiply);
        int resDataStructuer3 = calculator.useFunction(100, 20, funcList.get(3));
        int resDataStructuer4 = calculator.useFunction(100, 20, funcList.get(1));

        System.out.println(resDataStructuer1);
        System.out.println(resDataStructuer2);
        System.out.println(resDataStructuer3);
        System.out.println(resDataStructuer4);
    }

    static class Calculator {

        int oldStyle(int a, int b, String op) {
            if (op.trim().equals("+")) {
                return a + b;
            } else if (op.trim().equals("-")) {
                return a - b;
            } else if (op.trim().equals("*")) {
                return a * b;
            } else if (op.trim().equals("/")) {
                if (b == 0) throw new IllegalArgumentException("zero divide");
                else return a / b;
            } else {
                throw new IllegalArgumentException("operation error");
            }
        }

        Integer useFunction(int a, int b, BiFunction<Integer, Integer, Integer> op) {
            return op.apply(a, b);
        }
    }
}
