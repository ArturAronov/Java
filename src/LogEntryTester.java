import java.util.Date;

public class LogEntryTester {
    public static void main(String[] args){
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
//        System.out.println(le.getLogInfo());
        System.out.println(le);
        LogEntry le2 = new LogEntry("5.6.7.8", new Date(), "example request 2", 300, 400);
//        System.out.println(le2.getLogInfo());
        System.out.println(le2);
    }

}
