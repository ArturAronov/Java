package MarkovModel;

import edu.duke.FileResource;

import java.util.ArrayList;

public class MarkovModel {
    public static void main(String[] args) {

        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovModel markovRunnerWithInterface = new MarkovModel();
        markovRunnerWithInterface.runModel(new EfficientMarkovModel(5), st, 500, 531);
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov.toString());
        for (int k = 0; k < 3; k++) {
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runEfficientMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();

        int size = 50;
        int seed = 531;
        int order = 5;
        EfficientMarkovModel emm = new EfficientMarkovModel(order);
        runModel(emm, st, size, seed);
    }

    private void printOut(String s) {
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k] + " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
}
