import java.util.ArrayList;
import java.util.ArrayList;

public class ArrayListStudy {
    // The ArrayList class is a resizable array, which can be found in the java.util package. The difference between a built-in array and an ArrayList in Java, is that the size of an array cannot be modified (if you want to add or remove elements to/from an array, you have to create a new one)
    // The StorageResource class stores any number of String objects and allows access to these stored values one at a time, using the method data . These strings can then be iterated over in the order they were added using a for loop
    // StorageResource items cannot be accessed with index (example[index]), and needs to be iterated over entire list with loop in order to do it

    private static void arrayListExample() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("world");
        words.set(0, "goodbye");
        String s = words.get(0);

        System.out.println(s);
    }

    public static void main(String[] args) {
        arrayListExample();
    }
}
