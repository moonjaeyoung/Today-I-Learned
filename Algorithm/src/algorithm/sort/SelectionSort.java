package algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 4, 6, 2, 1, 3);
        System.out.println(list);

        for(int i = 0 ; i <list.size() ; i++){
            int min = i;

            for(int j = i; j < list.size() ; j++){
                if(list.get(min) > list.get(j)){
                    min = j;
                }
            }

            Collections.swap(list, i , min);
            }

        System.out.println(list);
    }
}

