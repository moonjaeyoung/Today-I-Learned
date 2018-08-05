package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _10828 {
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            String input = scanner.next();

            if (input.equals("push")) {
                int number = scanner.nextInt();
                stack.push(number);
            } else if (input.equals("pop")) {
                out.write(stack.pop() + "\n");
            } else if (input.equals("size")) {
                out.write(stack.size() + "\n");
            } else if (input.equals("empty")) {
                out.write(stack.empty() + "\n");
            } else if (input.equals("top")) {
                out.write(stack.top() + "\n");
            }
        }

        out.flush();
        out.close();

    }

    private static class Stack {
        private List<Object> list = new ArrayList<>();
        private int top = 0;

        void push(Object item) {
            list.add(top++, item);
        }

        synchronized Object pop() {
            if (list.size() == 0) {
                return -1;
            } else {
                Object peek = list.get(--top);
                list.remove(top);
                return peek;
            }
        }

        int size() {
            return list.size();
        }

        Object top() {
            if (list.size() == 0) return -1;
            else return list.get(top - 1);
        }

        int empty() {
            if (list.size() == 0) return 1;
            else return 0;
        }
    }
}
