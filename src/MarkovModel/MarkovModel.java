package MarkovModel;

import java.util.ArrayList;

public class MarkovModel extends AbstractMarkovModel {
    private final int myOrder;
    public MarkovModel(int order) {
        myOrder = order;
    }

    public String getRandomText(int length) {
        StringBuffer sb = new StringBuffer();
        // myRandom and myText are protected variables and accessed from the super class
        int index = myRandom.nextInt(myText.length() - myOrder);
        String key = myText.substring(index, index + myOrder);
        sb.append(key);
        for(int i = 0; i< numChars - myOrder; i++){
            // getFollows is protected method and accessed from the supper class
            ArrayList<String> follows = getFollows(key);
            if(follows.isEmpty()){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        return sb.toString();
    }
}
