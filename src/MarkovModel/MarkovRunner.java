package MarkovModel;

import edu.duke.*;

public class MarkovRunner {
    public static void runMarkov(){
        FileResource fr = new FileResource("data/Markov/romeo.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');

        MarkovTwo markov = new MarkovTwo();
        markov.setTraining(st);
        for(int i = 0; i < 3; i++) {
            String text = markov.getRandomText(500);
//            System.out.println(text);
            printOut(text);
        }


    }

    public static void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;

        System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
        for (String w : words) {
            System.out.println(w + " ");
            psize += w.length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
    }

    public static void main(String[] args) {
        runMarkov();
    }
}
