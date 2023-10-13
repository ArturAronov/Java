import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
    private static ArrayList<String> myWords = new ArrayList<String>();
    private static ArrayList<Integer> myFreqs = new ArrayList<Integer>();
    private static int mostCommonWordCount = 0;
    private static String mostCommonWord;

    //  public WordFrequencies() {
    //      myWords = new ArrayList<String>();
    //      myFreqs = new ArrayList<Integer>();
    //  }

    public static void findUnique() {
        FileResource resource = new FileResource("data/likeit.txt");

        for(String s : resource.words()){
            s = s.toLowerCase();

            int index = myWords.indexOf(s);
            if(index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }

    public static void main(String[] args) {
        findUnique();
        System.out.println("# of unique words: "+myWords.size());
        for(int i = 0; i < myWords.size(); i++) {
            System.out.println("Word "+myWords.get(i)+" appeared "+myFreqs.get(i)+" times.");
            if(myFreqs.get(i) > mostCommonWordCount) {
                mostCommonWordCount = myFreqs.get(i);
                mostCommonWord = myWords.get(i);
            }
        }

        System.out.println("Most common word: "+mostCommonWord+" occurred "+mostCommonWordCount+" times");
    }
}
