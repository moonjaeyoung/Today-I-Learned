package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : Hyunwoong
 * @When : 2018-09-09 오전 12:32
 * @Homepage : https://github.com/gusdnd852
 */
public class _2839 {
    public static void main(String[] args) throws IOException {
        int kg = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int var3 = 0;
        int var5 = 0;

        int result = 0;

        while (kg > 0 && kg % 5 != 0) {
            kg -= 3;
            var3++;
        }
        if (kg < 0) {
            System.out.println(-1);
        } else {
            var5 = kg / 5;
            System.out.println(var3 + var5);
        }
    }
}