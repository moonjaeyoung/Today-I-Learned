package beakjoon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author : Hyunwoong
 * @When : 2018-09-09 오전 12:09
 * @Homepage : https://github.com/gusdnd852
 */
public class _11718 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            inputs.add(input);
        }
        sc.close();
        for (String input : inputs) System.out.println(input);
    }
}
