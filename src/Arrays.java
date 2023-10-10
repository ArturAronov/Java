import edu.duke.FileResource;
import java.util.Random;

public class Arrays {
    public static String[] getCommon() {
        FileResource resource = new FileResource("data/common2.txt");
        String[] common = new String[656];
        int index = 0;
        for(String s: resource.words()){
            common[index] = s;
            index++;
        }

        return common;
    }

    public static int indexOf(String[] list, String word) {
        for (int k=0; k<list.length; k++) {
            if (list[k].equals(word)) {
                return k;
            }
        }
        return -1;
    }

    public static void countWords(FileResource resource, String[] common, int[] counts){
        for(String word : resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if (index != -1) {
                counts[index] += 1;
            }
        }
    }
    private static void countShakespeare() {
        String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
        String[] common = getCommon();
        int[] counts = new int[common.length];

        FileResource resource = new FileResource("data/lotsOfWords.txt");
        countWords(resource, common, counts);
        System.out.println("done with lotsOfWords.txt");

//        for(int i = 0; i < plays.length; i++) {
//            FileResource resource = new FileResource("data/"+ plays[i]);
//            countWords(resource, common, counts);
//            System.out.println("done with " + plays[i]);
//        }

        for(int i=0; i < common.length; i++){
            System.out.println(common[i] + "\t" + counts[i]);
        }
    }
    private static void diceRoll2(int rolls) {
        Random rand = new Random();
        int [] counts = new int[13];

        for(int i = 0; i < rolls; i++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;

            counts[d1 + d2] += 1;
        }

        for(int i = 2; i <= 12; i++) {
            System.out.println(i + "'s=\t" + counts[i] + "\t" + 100.0 *  counts[i] / rolls);
        }
    }
    private static void diceRoll1(int rolls) {
        Random rand = new Random();
        int twos = 0;
        int twelves = 0;

        for(int i = 0; i < rolls; i++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;

            if(d1 + d2 == 2) {
                twos++;
            }
            else if (d1 + d2 == 12) {
                twelves++;
            }
        }

        System.out.println("2's=\t" + twos + "\t" + 100.0 * twos/rolls);
        System.out.println("2's=\t" + twelves + "\t" + 100.0 * twelves/rolls);
    }
    private static void arraysPlayground() {
        int[] x;
       int[] nums = new int[26];
       String[] strgs = new String[26];

       System.out.println(nums[5]); // 0
       System.out.println(strgs[3]); // null

        strgs[3] = "Hello";
        nums[5] = nums[4] + 4;

        System.out.println(nums[5]); // 4
        System.out.println(strgs[3]); // Hello
    }

    public static void main(String[] args) {
        countShakespeare();
//        diceRoll2(26000);
//        arraysPlayground();
//        System.out.println("Hello World");
    }
}
