import java.util.HashMap;

public class UniqueIPTester {
    public static void main(String[] args) {
//        LogAnalyzer la = new LogAnalyzer();
//        la.readFile("data/ip-test_log");
//        int uniqueIPs = la.countUniqueIPs();
//        System.out.println("There are " + uniqueIPs + "IPs");

        LogAnalyzer la2 = new LogAnalyzer();
        la2.readFile("data/ip-test_log");
        HashMap<String, Integer> counts = la2.countVisitsPerIp();
        Integer totalCounts = la2.countTotalVisits();
        Integer test = la2.iPRanges();
        System.out.println(counts);
    }

}
