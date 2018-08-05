package data_structure.dequeue;

import java.util.*;

/* <REQUIREMENT>
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
* */
public class Dequeue {

    public static void main(String[] args) {
        DequeueImpl dequeue = new DequeueImpl();

        dequeue.push_back(5);
        dequeue.push_back("a");
        dequeue.push_front(877);
        dequeue.push_back(4.7);
        dequeue.push_front(8777);

        System.out.println(dequeue.pop_back());
        System.out.println(dequeue.pop_back());
        System.out.println(dequeue.pop_back());
        System.out.println(dequeue.pop_front());
        System.out.println(dequeue.pop_front());

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
            Object peek = map.get(front + 1);
            map.remove(front);
            front++;
            return peek;
        }

        Object pop_back() {
            Object peek = map.get(back - 1);
            map.remove(back);
            back--;
            return peek;
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
            return map.get(front + 1);
        }

        Object back() {
            return map.get(back - 1);
        }
    }
}

