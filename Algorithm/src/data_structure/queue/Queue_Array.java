package data_structure.queue;

public class Queue_Array {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(3);
        queue.push(5);

        System.out.println(queue.front());
        System.out.println(queue.back());
    }


    private static class Queue{
        private Object[] array = new Object[1000];
        private int front = 0;
        private int back = 0;

        private void push(Object item){
            array[back] = item;
            back++;
        }

        private Object pop(){
            Object peek = array[front];
            array[front] = null;
            front++;
            return peek;
        }

        private int size(){
         return back - front;
        }

        private int empty(){
            if(size() == 0) return 1;
            else return 0;
        }

        private Object front(){
            return array[front];
        }

        private Object back(){
            return array[back-1];
        }
    }
}
