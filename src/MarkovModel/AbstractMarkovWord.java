package MarkovModel;
import java.util.Random;

public abstract class AbstractMarkovWord implements IMarkovModel {
    protected String[] myText;
    protected Random myRandom;
    protected int order;


    public AbstractMarkovWord(int order) {

        myRandom = new Random();
        this.order = order;
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    protected void append(StringBuilder sb, String word) {
        sb.append(word);
        sb.append(" ");
    }

    public abstract String getRandomText(int numChars);


}
