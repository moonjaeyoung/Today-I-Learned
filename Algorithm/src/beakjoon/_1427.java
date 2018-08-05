package beakjoon;

import java.io.*;

public class _1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder Input = new StringBuilder(in.readLine());

        for (int i = 0; i < Input.length() - 1; i++) {
            for (int j = 0; j < Input.length() - 1 - i; j++) {
                if ((int) Input.charAt(j) < (int) Input.charAt(j + 1)) {
                    char Temp = Input.charAt(j);
                    Input.setCharAt(j, Input.charAt(j + 1));
                    Input.setCharAt(j + 1, Temp);
                }
            }
        }
        for (int i = 0; i < Input.length(); i++) {
            out.write((int)Input.charAt(i));
        }
        out.flush();
        out.close();
    }
}
