package Earthquake;

import java.util.*;

public class EarthQuakeClient {

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
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe: quakeData) {
            if(qe.getDepth() > depth1 && qe.getDepth() < depth2){
                answer.add(qe);
            }
        }
        return answer;
    }

    public static ArrayList<QuakeEntry> quakesByPhrase(ArrayList<QuakeEntry> quakeData, String phrase) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe: quakeData) {
            if(qe.getInfo().contains(phrase)) answer.add(qe);

        }
        return answer;
    }

    public void quakesWithFilter() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);

        Location tokyo = new Location(35.42, 139.43);
        float max = 10000000;

        Filter f;


        MatchAllFilters maf = new MatchAllFilters();
        f = new MagnitudeFilter(0.0, 2.0);
        f = new DepthFilter(-100000.0, -10000.0);
        //f = new DistanceFilter(tokyo, max);
        f = new PhraseFilter("any", "a");

        ArrayList<QuakeEntry> answer = filter(list, f);
        answer = filter(answer, f);
        for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }

        System.out.println("Found " + answer.size() + " earthquakes ");
    }

    public void testMatchAllFilter() {
        String source = "data/nov20quakedata.atom";
        EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = parser.read(source);

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
    }

    public void testMatchAllFilter2() {
        String source = "data/nov20quakedata.atom";
        EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilters maf = new MatchAllFilters();
        Location city = new Location(36.1314, -95.9372);

        Filter f;
        f = new MagnitudeFilter(0.0, 3.0);
        maf.addFilter(f);

        f = new DistanceFilter(city,  10000000);
        maf.addFilter(f);

        f = new PhraseFilter("any", "Ca");
        maf.addFilter(f);

        ArrayList<QuakeEntry> answer = filter(list, maf);
        for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }

        System.out.println("Found " + answer.size() + " earthquakes ");
    }
    
    public static ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) answer.add(qe);
        }
        return answer;              
    }


    
    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {      
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String souce = "data/Earthquake/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(souce);
        ArrayList<QuakeEntry> depth = quakesOfDepth(list, -8000, -5000);
        ArrayList<QuakeEntry> phrase = quakesByPhrase(list, "Creek");
        double[] magnitudes = largestMagnitude(list);
        System.out.println(list);
//        ArrayList<QuakeEntry> result = filterByMagnitude(list, 5);
//        System.out.println(result);
//        for(QuakeEntry qe: result){
//            System.out.println((qe));
//        }
//        System.out.println(list);
    }
}
