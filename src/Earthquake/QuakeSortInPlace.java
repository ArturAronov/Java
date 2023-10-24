package Earthquake;

import java.util.ArrayList;

public class QuakeSortInPlace {
//    private static ArrayList<QuakeEntry> earthQuakeList;
//
//    public QuakeSortInPlace(ArrayList<QuakeEntry> list){
//        earthQuakeList = new ArrayList<>(list);
//    }

    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted) {
        int total = 0;
        for(int i = 0; i < quakeData.size() -  1 - numSorted; i++) {
            total++;
            QuakeEntry q1 = quakeData.get(i);
            QuakeEntry q2 = quakeData.get(i + 1);
            if(q1.getMagnitude() > q2.getMagnitude()) {
                quakeData.set(i, q2);
                quakeData.set(i + 1, q1);
            }
        }
        System.out.println(total);
        System.out.println(quakeData);
    }

    public void sortMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        for(int i = 0; i < in.size(); i++) {
            onePassBubbleSort(in, i);
        }
    }
}
