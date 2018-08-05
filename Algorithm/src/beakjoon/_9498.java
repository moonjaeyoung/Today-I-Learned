package beakjoon;

import java.io.*;

public class _9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();

        if (Integer.parseInt(input) > 100 || Integer.parseInt(input) < 0) {
            throw new NumberFormatException("올바른 데이터를 입력해주세요.");
        } else if (Integer.parseInt(input) >= 90 && Integer.parseInt(input) <= 100) {
            bufferedWriter.write('A');
        } else if (Integer.parseInt(input) >= 80 && Integer.parseInt(input) < 90) {
            bufferedWriter.write('B');
        } else if (Integer.parseInt(input) >= 70 && Integer.parseInt(input) < 80) {
            bufferedWriter.write('C');
        } else if (Integer.parseInt(input) >= 60 && Integer.parseInt(input) < 70) {
            bufferedWriter.write('D');
        } else {
            bufferedWriter.write('F');
        }

        bufferedWriter.flush();
        bufferedReader.close();
    }
}
