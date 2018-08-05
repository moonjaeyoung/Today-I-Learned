package beakjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class _4673 {
    public static void main(String[] args) throws IOException {
        char array[] = new char[10036];

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i <= 10000; i++) array[d(i)] = '0';

        for (int i = 1; i <= 10000; i++) {
            if (array[i] != '0') {
                bufferedWriter.write(i + "\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int d(int input) {
        int sum = input;
        while (input != 0) {
            sum += input % 10;
            input /= 10;
        }
        return sum;
    }
}