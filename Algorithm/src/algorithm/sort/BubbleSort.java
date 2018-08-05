package algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 6, 4, 2, 1, 3);
        System.out.println(list);

        for(int i = 0 ; i < list.size()-1 ; i++){
            for(int j = 0 ; j < list.size() - 1 - i ; j++){
                if(list.get(j) > list.get(j+1)){
                    Collections.swap(list, j , j+1);
                }
            }
        }

        System.out.println(list);
    }
}