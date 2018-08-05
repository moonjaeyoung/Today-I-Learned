package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2750 {
    // 선택정렬로 풀어보기

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(input.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i<number ; i++){
            list.add(Integer.valueOf(input.readLine()));
        }

        for(int i = 0 ; i <list.size() ; i++){
            int minimum = i;

            for(int j = i ; j < list.size() ; j++){
                if(list.get(j) < list.get(minimum)){
                    minimum = j;
                }
            }
            Collections.swap(list, i , minimum);
        }

        for(int i = 0 ; i < number ; i++){
            out.write(list.get(i) + "\n");
        }

        out.flush();
        out.close();
    }
}
