package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strings = bufferedReader.readLine().trim().split("-");
        List<String> list = new ArrayList<>();

        list.addAll(Arrays.asList(strings));


        for (int i = 0; i < list.size(); i++) {
            if(Character.isUpperCase(list.get(i).charAt(0))){
            bufferedWriter.write(list.get(i).charAt(0));
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
