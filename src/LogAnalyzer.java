import edu.duke.FileResource;

import java.util.ArrayList;

public class LogAnalyzer {
    private static ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for(String line: fr.lines()){
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry le: records) {
            String ipAddr = le.getIpAddress();
            String[] test = ipAddr.split("[.]");
            Integer numTest = Integer.parseInt(test[0]);

            if(!uniqueIPs.contains(ipAddr)) {
                System.out.println(numTest);
                uniqueIPs.add(ipAddr);
            }
        }

        return uniqueIPs.size();
    }
}
