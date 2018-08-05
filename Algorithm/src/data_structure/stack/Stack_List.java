package data_structure.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack_List {

    private List<Object> list = new ArrayList<>();
    private int top = 0;

    void push(Object item) {
        list.add(top++, item);
    }

    synchronized Object pop() {
        Object peek = list.get(--top);
        list.remove(top);
        return peek;
    }

    int size() {
        return list.size();
    }

    Object top() {
        if (list.size() == 0) return -1;
        else return list.get(top-1);
    }

    int empty() {
        if (list.size() == 0) return 1;
        else return 0;
    }

    static class Main{
        public static void main(String[] args) {
            Stack_List stack_list = new Stack_List();
            stack_list.push(1);
            stack_list.push("안녕");
            stack_list.push(50.25);

            System.out.println(stack_list.pop());
        }
    }

}
