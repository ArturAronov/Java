package Earthquake;

import java.util.*;

final class SortByMagnitude {
    private static ArrayList<QuakeEntry> earthQuakeList;

    public SortByMagnitude(ArrayList<QuakeEntry> list){
        earthQuakeList = new ArrayList<>(list);
    }

    public static QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> input) {
        QuakeEntry min = input.get(0);
        for(QuakeEntry q: input) {
            if(q.getMagnitude() < min.getMagnitude()) {
                min = q;
            }
        }
        return min;
    }

    public ArrayList<QuakeEntry> sortByMagnitude() {
        ArrayList<QuakeEntry> out = new ArrayList<>();
        while(!earthQuakeList.isEmpty()){
            QuakeEntry smallestMag = getSmallestMagnitude(earthQuakeList);
            earthQuakeList.remove(smallestMag);
            out.add(smallestMag);
        }
        return out;
    }
}
