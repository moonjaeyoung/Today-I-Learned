package beakjoon;

import java.util.Scanner;

public class _1002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testcase = in.nextInt();
        for(int test = 0 ; test < testcase ; test++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int r1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int r2 = in.nextInt();

            int result = -1;
            if(x1 == x2 && y1 == y2) {
                if(r1 != r2) result = 0;
            } else {
                double distance = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2.0) + Math.pow(Math.abs(y1 - y2),2.0));
                double lineDistance = (double)r1 + (double)r2;
                double minDistance = (double)Math.abs(r1 - r2);
                if(distance < lineDistance && distance > minDistance) result = 2;
                else if(distance == minDistance || distance == lineDistance) result = 1;
                else result = 0;
            }

            System.out.println(result);
        }
    }
}