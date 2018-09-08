package beakjoon;

import java.io.*;

/**
 * @Author : Hyunwoong
 * @When : 2018-09-09 오전 12:19
 * @Homepage : https://github.com/gusdnd852
 */
public class _2741 {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        for (int i = 1; i <= num; i++) writer.write(i + "\n");

        writer.flush();
        writer.close();
    }
}
