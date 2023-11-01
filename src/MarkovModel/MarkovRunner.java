package MarkovModel;
import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public static void runModel(IMarkovModel markov, String text, int size, int seed){
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public static void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWordOne markovWord = new MarkovWordOne();
        runModel(markovWord, st, 120, 139);
    }

    public static void runMarkovTwo() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWordTwo markovWord = new MarkovWordTwo();
        runModel(markovWord, st, 120, 832);
    }

    private static void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    // tester
    private void testGetFollows2() {
        String st = "apple bee apple start apple bee yu";
        MarkovWordTwo markovWord = new MarkovWordTwo();
        markovWord.setTraining(st);
//        System.out.println(markovWord.getFollows("apple", "bee"));
//        System.out.println(markovWord.getFollows("bee", "apple"));
    }

    // tester
    private void testGetFollows() {
        String st = "apple bee apple start apple";
        MarkovWordOne markovWord = new MarkovWordOne();
        markovWord.setTraining(st);
        System.out.println(markovWord.getFollows("apple"));
        System.out.println(markovWord.getFollows("bee"));
    }

    public static void main(String[] args) {
        runMarkovTwo();
    }
}