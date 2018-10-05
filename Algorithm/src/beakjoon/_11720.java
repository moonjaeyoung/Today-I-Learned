package beakjoon;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author : Hyunwoong
 * @When : 2018-09-09 오전 1:42
 * @Homepage : https://github.com/gusdnd852
 */
public class _11720 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String times = scanner.nextLine();
        String input = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < Integer.parseInt(times); i++) {
            int num = Integer.parseInt(String.valueOf(input.charAt(i)));
            sum += num;
        }
        System.out.println(sum);
    }
}
