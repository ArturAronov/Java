package Earthquake;

import java.util.ArrayList;

public class InPlaceSort {
    private static ArrayList<QuakeEntry> earthQuakeList;

    public InPlaceSort(ArrayList<QuakeEntry> list){
        earthQuakeList = new ArrayList<>(list);
    }
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from){
        int minIdx = from;
        for(int i = from + 1; i < quakes.size(); i++) {
            if(quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()){
                minIdx = i;
            }
        }
        return minIdx;
    }

    public int getSmallestDepth(ArrayList<QuakeEntry> quakes, int from){
        int minIdx = from;
        for(int i = from + 1; i < quakes.size(); i++) {
            if(quakes.get(i).getDepth() > quakes.get(minIdx).getDepth()){
                minIdx = i;
            }
        }
        return minIdx;
    }

    public ArrayList<QuakeEntry> sortByMagnitude() {
        for(int i = 0; i < earthQuakeList.size(); i++) {
            int minIdx = getSmallestMagnitude(earthQuakeList, i);
            QuakeEntry qi = earthQuakeList.get(i);
            QuakeEntry qMin = earthQuakeList.get(minIdx);

            earthQuakeList.set(i, qMin);
            earthQuakeList.set(minIdx, qi);
        }
        return earthQuakeList;
    }

    public ArrayList<QuakeEntry> sortByDepth() {
        for(int i = 0; i < 70; i++) {
            int minIdx = getSmallestDepth(earthQuakeList, i);
            QuakeEntry qi = earthQuakeList.get(i);
            QuakeEntry qMin = earthQuakeList.get(minIdx);

            earthQuakeList.set(i, qMin);
            earthQuakeList.set(minIdx, qi);
        }
        return earthQuakeList;
    }
}
