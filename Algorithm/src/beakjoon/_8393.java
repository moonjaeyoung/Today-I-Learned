package beakjoon;

import java.io.*;

public class _8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer input = Integer.valueOf(bufferedReader.readLine());
        Integer result = 0;

        for(int i = 0 ; i <= input ; i++){
            result = result + i;
        }

        bufferedWriter.write(result.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
