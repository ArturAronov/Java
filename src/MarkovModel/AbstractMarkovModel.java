package MarkovModel;

import java.util.ArrayList;
import java.util.Random;

// Inheritance
public abstract class AbstractMarkovModel implements IMarkovModel{
    protected String myText;
    protected Random myRandom;
    abstract public String getRandomText(int numChars);
    protected ArrayList<String> getFollows(String key){
//        code here
    }

    public AbstractMarkovModel() {
        myRandom = new Random();
    }

    public void setTraining(String text) {
        myText = text;
    }
}
