package beakjoon;

import java.util.Scanner;

public class _2438 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer line = scanner.nextInt();

        for(int i = 0 ; i < line ; i++){
            for(int j = 0 ; j <= i ; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
