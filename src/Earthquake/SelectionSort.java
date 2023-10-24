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

    public void stringSelectSort(String[] input) {
        for(int i = 0; i < input.length; i++) {
            int minIndx = i;
            for(int j = i + 1; j < input.length; j++) {
                if(input[j].compareTo(input[minIndx]) < 0){
                    minIndx = j;
                }
            }
            String temp = input[i];
            input[i] = input[minIndx];
            input[minIndx] = temp;
        }
    }

    public void runStringSelectSort() {
        String[] cats = {"tiger", "lion", "cheetah", "puma", "leopard"};
        stringSelectSort(cats);
        for(String s: cats) {
            System.out.println(s);
        }
    }
}
