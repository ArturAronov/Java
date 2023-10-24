package Earthquake;

import java.util.Arrays;

public class SelectionSort {
    private final int[] test = {7, 3, 2, 8, 1, 4};

    public int[] selectionSort(){
        for(int i = 0; i < test.length; i++){
            System.out.println(Arrays.toString(test));
            int minIndx = i;
            for(int j = i + 1; j < test.length; j++) {
                if(test[j] < test[minIndx]){
                    minIndx = j;
                }
            }
            int temp = test[i];
            test[i] = test[minIndx];
            test[minIndx] = temp;
        }
        return test;
    }
}
