package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1152 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int count = str.length;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("")) {
                count--;
            }
        }
        System.out.println(count);
    }
}