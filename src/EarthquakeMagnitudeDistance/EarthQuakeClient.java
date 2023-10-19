package EarthquakeMagnitudeDistance;

import java.lang.reflect.Array;
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
