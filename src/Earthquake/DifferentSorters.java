package Earthquake;
import java.util.*;

public class DifferentSorters {
    private static ArrayList<QuakeEntry> earthQuakeList;

    public DifferentSorters(ArrayList<QuakeEntry> list){
        earthQuakeList = new ArrayList<>(list);
    }
    public void sortWithCompareTo() {
        Collections.sort(earthQuakeList);
        System.out.println(earthQuakeList.get(600));
    }

    public void sortByTitleAndDepth() {
//        Collections.sort(earthQuakeList);
        Collections.sort(earthQuakeList, new TitleAndDepthComparator());
        System.out.println(earthQuakeList.get(500));
    }

    public void sortByLastWordInTitleThenByMagnitude() {
        Collections.sort(earthQuakeList, new TitleLastAndMagnitudeComparator());
        System.out.println(earthQuakeList.get(500));
    }

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
//        Collections.sort(list, new MagnitudeComparator());

        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
}
