package MarkovModel;

import java.util.Random;

public class MarkovZero {
    private static String myText;
    private static Random myRandom;

    public MarkovZero() {
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public String getRandomText(int numChars) {
        if(myText == null) return "";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numChars; i++) {
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }
        return sb.toString();
    }
}
