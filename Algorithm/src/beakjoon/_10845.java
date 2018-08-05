package beakjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _10845 {
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            String input = scanner.next();

            if (input.equals("push")) {
                int number = scanner.nextInt();
                queue.push(number);
            } else if (input.equals("pop")) {
                out.write(queue.pop() + "\n");
            } else if (input.equals("size")) {
                out.write(queue.size() + "\n");
            } else if (input.equals("empty")) {
                out.write(queue.empty() + "\n");
            } else if (input.equals("back")) {
                out.write(queue.back() + "\n");
            } else if (input.equals("front")) {
                out.write(queue.front() + "\n");
            }
        }

        out.flush();
        out.close();
    }

    private static class Queue {

        private List<Object> list = new ArrayList<>();
        private int front = 0;
        private int back = 0;

        private void push(Object item) {
            list.add(back, item);
            back++;
        }

        synchronized private Object pop() {
            if (list.size() == 0) {
                return -1;
            } else {
                Object peek = list.get(front);
                list.remove(front);
                back--;
                return peek;
            }
        }

        private int size() {
            return list.size();
        }

        private int empty() {
            if(size() == 0) return 1;
            else return 0;
        }

        private Object front() {
            if (list.size() == 0) return -1;
            else return list.get(front);
        }

        private Object back() {
            if (list.size() == 0) return -1;
            else return list.get(back-1);
        }
    }
}
