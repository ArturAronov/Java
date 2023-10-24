package Earthquake;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSort {
    private static ArrayList<QuakeEntry> earthQuakeList;

    public CollectionsSort(ArrayList<QuakeEntry> list){
        earthQuakeList = new ArrayList<>(list);
    }

    public void testSort(){
        Collections.sort(earthQuakeList);
        for(QuakeEntry q: earthQuakeList) {
            System.out.println(q);
        }
    }
}
