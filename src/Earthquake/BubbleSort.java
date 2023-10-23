package Earthquake;

import java.util.*;

public class BubbleSort {
//    private static ArrayList<QuakeEntry> earthQuakeList;
    private static int[] test = {7, 3, 2, 8, 1, 4};

    public int[] bubbleSort(){
        for(int i = 0; i < test.length - 1; i++) {
            System.out.println(Arrays.toString(test));
            for(int j = 0; j < test.length - i - 1; j++) {
                if (test[j] > test[j + 1]) {
                    // Swap if the elements aren't in the right order
                    int temp = test[j];
                    test[j] = test[j + 1];
                    test[j + 1] = temp;
                }
            }
        }
        return test;
    }


//    public BubbleSort(ArrayList<QuakeEntry> list){
//        earthQuakeList = new ArrayList<>(list);
//    }


}
