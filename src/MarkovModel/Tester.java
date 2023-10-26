package MarkovModel;

import edu.duke.*;

public class Tester {
    public void testGetFollowsWithFile(){
        MarkovOne one = new MarkovOne();
        FileResource f = new FileResource();
        one.setTraining(f.asString());
        String key = "th";
        System.out.println(one.getFollows(key).size());
    }
}