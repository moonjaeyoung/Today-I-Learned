package functional;

import java.util.function.Function;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오전 2:17
 * @Homepage : https://github.com/gusdnd852
 */
public class Functional {
    public static void main(String[] args) {
        Function<String, String> fucn = (input) -> input + " world";

        String a = fucn.apply("hello");
        String b = fucn.apply("hello my");

        System.out.println(a);
        System.out.println(b);
    }
}
