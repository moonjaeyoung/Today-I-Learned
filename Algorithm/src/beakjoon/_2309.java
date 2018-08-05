package beakjoon;

import java.io.*;
import java.util.Arrays;

public class _2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nineDwarfs = new int[9];
        int totalHeight = 0;

        for (int i = 0; i < nineDwarfs.length; i++) {
            nineDwarfs[i] = Integer.parseInt(br.readLine());
            if (nineDwarfs[i] > 100) {
                throw new NumberFormatException(nineDwarfs[i] + " causes NFE");
            }
            totalHeight += nineDwarfs[i];
        }

        for(int i  = 0 ; i <nineDwarfs.length ; i++){
            boolean flag = false;

            for(int j = i+1 ; j < nineDwarfs.length ; j++){
                if(totalHeight - (nineDwarfs[i] + nineDwarfs[j]) == 100){
                    nineDwarfs[i] = 0;
                    nineDwarfs[j] = 0;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        Arrays.sort(nineDwarfs);

        for(int i  = 2 ; i < nineDwarfs.length ; i++){
            bw.write(nineDwarfs[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
