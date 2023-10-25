package Earthquake;
import java.util.Comparator;
public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry o1, QuakeEntry o2) {
        int titleRes = o1.getInfo().compareTo(o2.getInfo());
        if (titleRes != 0){
            return titleRes;
        }
        return Double.compare(o1.getDepth(), o2.getDepth());
    }
}