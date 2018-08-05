package algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 4, 6, 1, 2, 3);
        System.out.println(list);

        for(int i = 0 ; i < list.size() ; i++){
            int loc = i;
            while (loc > 0 && list.get(loc) < list.get(loc-1)){
                Collections.swap(list, loc , loc-1);
                loc--;
            }
        }
        System.out.println(list);
    }
}

