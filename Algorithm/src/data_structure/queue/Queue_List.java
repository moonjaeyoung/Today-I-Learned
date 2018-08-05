package data_structure.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue_List {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(3);
        queue.push(7);
        queue.push(9);

        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println(queue.size());
    }


    private static class Queue {

        private List<Object> list = new ArrayList<>();
        private int front = 0;
        private int back = 0;

        private void push(Object item) {
            list.add(back, item);
            back++;
        }

        private Object pop() {
            Object peek = list.get(front);
            list.remove(front);
            back--;
            return peek;
        }

        private int size() {
            return list.size();
        }

        private int empty() {
            if(size() == 0) return 1;
            else return 0;
        }

        private Object front() {
            return list.get(front);
        }

        private Object back() {
            return list.get(back-1);
        }
    }
}
