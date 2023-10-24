package Earthquake;

import java.util.ArrayList;
import java.util.Collections;
public class DistanceSorter {
    private static ArrayList<QuakeEntry> earthQuakeList;
    Location where;

    public DistanceSorter(ArrayList<QuakeEntry> list){
        earthQuakeList = new ArrayList<>(list);
        where = new Location(35.9886, -78.9072);
    }

    public void sortByDistance() {
        Collections.sort(earthQuakeList, new DistanceComparator(where));
        for(QuakeEntry q: earthQuakeList){
            System.out.println(q);
        }
    }
}
