package beakjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _10866 {

    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        DequeueImpl dequeue = new DequeueImpl();

        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            String input = scanner.next();

            if (input.equals("push_front")) {
                int number = scanner.nextInt();
                dequeue.push_front(number);
            } else if (input.equals("push_back")) {
                int number = scanner.nextInt();
                dequeue.push_back(number);
            } else if (input.equals("pop_front")) {
                out.write(dequeue.pop_front() + "\n");
            } else if (input.equals("pop_back")) {
                out.write(dequeue.pop_back() + "\n");
            } else if (input.equals("size")) {
                out.write(dequeue.size() + "\n");
            } else if (input.equals("empty")) {
                out.write(dequeue.empty() + "\n");
            } else if (input.equals("front")) {
                out.write(dequeue.front() + "\n");
            } else if (input.equals("back")) {
                out.write(dequeue.back() + "\n");
            }
        }

        out.flush();
        out.close();

    }

    private static class DequeueImpl {
        Map<Integer, Object> map = new HashMap<>();
        int front = 5000;
        int back = 5001;


        void push_front(Object item) {
            map.put(front, item);
            front--;
        }

        void push_back(Object item) {
            map.put(back, item);
            back++;
        }

        Object pop_front() {
            if (size() == 0) {
                return -1;
            } else {
                Object peek = map.get(front + 1);
                map.remove(front);
                front++;
                return peek;
            }
        }

        Object pop_back() {
            if (size() == 0) {
                return -1;
            } else {
                Object peek = map.get(back - 1);
                map.remove(back);
                back--;
                return peek;
            }
        }

        int size() {
            return back - front - 1;
        }

        int empty() {
            if (size() == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        Object front() {
            if (size() == 0) return -1;
            else return map.get(front + 1);
        }

        Object back() {
            if (size() == 0) return -1;
            else return map.get(back - 1);
        }
    }

}