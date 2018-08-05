package data_structure.stack;

public class Stack_Array {

    private Object[] array = new Object[100000];
    private int top = 0;

    public void push(Object item){
        array[top++] = item;
    }

    public Object pop(){
        Object peek = array[--top];
        array[top] = null;
        return peek;
    }

    int size() {
        return top;
    }

    Object top() {
        if (top == 0) return -1;
        else return array[top-1];
    }

    int empty() {
        if (top  == 0) return 1;
        else return 0;
    }

    static class Main{
        public static void main(String[] args) {
            Stack_Array stack_array = new Stack_Array();

            stack_array.push(6);
            stack_array.push(2);
            stack_array.push(1);

            System.out.println(stack_array.pop());
            System.out.println(stack_array.pop());
            System.out.println(stack_array.pop());

            System.out.println(stack_array.size());
            System.out.println(stack_array.empty());
        }
    }
}


