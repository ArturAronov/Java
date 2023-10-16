public class UniqueIPTester {
    public static void main(String[] args) {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("data/ip-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + "IPs");
    }

}
