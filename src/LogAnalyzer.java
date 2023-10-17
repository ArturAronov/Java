import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.HashMap;

public class LogAnalyzer {
    private static ArrayList<LogEntry> records;
    public HashMap<String, Integer> countVisitsPerIp(){
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for(LogEntry le: records) {
            String ip = le.getIpAddress();
            if(!counts.containsKey(ip)) {
                counts.put(ip, 1);
            } else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }

        return counts;
    }

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

    public int countTotalVisits() {
        int total = 0;
        for(LogEntry le: records){
            total++;
        }

        return total;
    }

    public Integer iPRanges() {
        int total = 0;
        for(LogEntry le: records) {
            String ipAddr = le.getIpAddress();
            String[] ipAddrSplit = ipAddr.split("[.]");
            Integer iPNum = Integer.parseInt(ipAddrSplit[0]);
            if(iPNum > 199 && iPNum < 300) {
                total++;
            }
        }

        return total;
    }
}
