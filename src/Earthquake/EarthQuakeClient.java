package Earthquake;

import java.util.*;

public class EarthQuakeClient {
    public static ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for(QuakeEntry qe : quakeData) {
            if (f.satisfies(qe)) {
                answer.add(qe);
            }
        }

        return answer;
    }

    public static double[] largestMagnitude(ArrayList<QuakeEntry> quakeData){
        double[] result = new double[quakeData.size()];

        for(int i = 0; i < quakeData.size(); i++) {
            result[i] = quakeData.get(i).getMagnitude();
        }
        Arrays.sort(result);
        for(double re: result){
            System.out.println(re);
        }
        return result;
    }

    public static ArrayList<QuakeEntry> quakesOfDepth(ArrayList<QuakeEntry> quakeData, double depth1, double depth2) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for(QuakeEntry qe: quakeData) {
            if(qe.getDepth() > depth1 && qe.getDepth() < depth2){
                answer.add(qe);
            }
        }
        return answer;
    }

    public static ArrayList<QuakeEntry> quakesByPhrase(ArrayList<QuakeEntry> quakeData, String phrase) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for(QuakeEntry qe: quakeData) {
            if(qe.getInfo().contains(phrase)) answer.add(qe);

        }
        return answer;
    }

    public static int quakesWithFilter(ArrayList<QuakeEntry> list) {
        Filter f;

        Location tokyo = new Location(35.42, 139.43);

        MatchAllFilters maf = new MatchAllFilters();
        f = new MagnitudeFilter(0.0, 2.0);
        f = new DepthFilter(-100000.0, -10000.0);
        //f = new DistanceFilter(tokyo, 10000000);
        f = new PhraseFilter("any", "a");

        ArrayList<QuakeEntry> answer = filter(list, f);
        answer = filter(answer, f);
        for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }

        System.out.println("Found " + answer.size() + " earthquakes ");
        return 0;
    }

    public static int testMatchAllFilter(ArrayList<QuakeEntry> list) {
        System.out.println("read data for "+list.size()+" quakes");

        Filter f;
        MatchAllFilters maf = new MatchAllFilters();

        f = new MagnitudeFilter(0.0, 2.0);
        maf.addFilter(f);
        f = new DepthFilter(-100000.0, -10000.0);
        maf.addFilter(f);
        f = new PhraseFilter("any", "a");
        maf.addFilter(f);

        ArrayList<QuakeEntry> answer = filter(list, maf);
        for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }

        System.out.println("Found " + answer.size() + " earthquakes ");
        return 0;
    }

    public static int testMatchAllFilter2(ArrayList<QuakeEntry> list) {
        System.out.println("read data for "+list.size()+" quakes");

        Filter f;
        MatchAllFilters maf = new MatchAllFilters();
        Location city = new Location(36.1314, -95.9372);

        f = new MagnitudeFilter(3.5, 4.5);
        maf.addFilter(f);
        f = new DepthFilter(-55000.0, -20000.0);
        maf.addFilter(f);

//        f = new DistanceFilter(city,  10000000);
//        maf.addFilter(f);

//        f = new PhraseFilter("any", "Ca");
//        maf.addFilter(f);

        ArrayList<QuakeEntry> answer = filter(list, maf);
        for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }

        System.out.println("Found " + answer.size() + " earthquakes ");
        return 0;
    }
    
    public static ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) answer.add(qe);
        }
        return answer;              
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String sauce = "data/Earthquake/earthQuakeDataDec6sample1.atom";
        ArrayList<QuakeEntry> list = parser.read(sauce);
//        ArrayList<QuakeEntry> depth = quakesOfDepth(list, -8000, -5000);
//        ArrayList<QuakeEntry> phrase = quakesByPhrase(list, "Creek");
//        double[] magnitudes = largestMagnitude(list);
//        int matchAllFilter2 = testMatchAllFilter2(list);

//        ArrayList<QuakeEntry> test = sortByMagnitude(list);
//        System.out.println(test);
//        SortByMagnitude s = new SortByMagnitude(list);
        InPlaceSort is = new InPlaceSort(list);
        ArrayList<QuakeEntry> sortedQuakes = is.sortByDepth();
        BubbleSort bubble = new BubbleSort();
        int[] bubbleSorted = bubble.bubbleSort();
        for(int i = 0; i < bubbleSorted.length; i++) {
            System.out.println(bubbleSorted[i]);
        }
//        for(QuakeEntry q: sortedQuakes) {
//            System.out.println(q);
//        }
//        System.out.println(list);
//        ArrayList<QuakeEntry> result = filterByMagnitude(list, 5);
//        System.out.println(result);
//        for(QuakeEntry qe: result){
//            System.out.println((qe));
//        }
//        System.out.println(list);
    }
}
