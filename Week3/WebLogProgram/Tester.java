
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer lognew = new LogAnalyzer();
        lognew.readFile("short-test_log.txt");
        lognew.printAll();
        
    }
    
    public void testUniqueIP (){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog2_log");
        System.out.println("The unique logs have: ");
        System.out.println(testLog.countUniqueIPs());
        
        
    }
    
    public void testHighNumIP(){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog1_log");
        testLog.printAllHigherThanNum(400);
    }
    
    public void testVisitOneDay(){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog2_log");
        System.out.println(testLog.uniqueIPVisitsOnDay("Sep 27"));
        
    }
    
    public void testInRange(){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog2_log");
        System.out.println(testLog.countUniqueIPsInRange(400,499));
    }
    
    public void test1countVisitsPerIP(){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog1_log");
        System.out.println(testLog.countVisitsPerIP());
        
    }
    
    public void test2mostNumberVisitsByIP(){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog2_log");
        HashMap<String,Integer> ipMap = testLog.countVisitsPerIP();
        System.out.println(testLog.mostNumberVisitsByIP(ipMap));
        
    }
    
    public void test3iPsMostVisits(){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog2_log");
        HashMap<String,Integer> ipMap = testLog.countVisitsPerIP();
        System.out.println(testLog.iPsMostVisits(ipMap));
        
    }
    
    public void test4iPsForDays(){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog3-short_log ");
       
        System.out.println(testLog.iPsForDays());
        
    }
    
    public void test5dayWithMostIPVisits(){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> ipMap = testLog.iPsForDays();
        System.out.println(testLog.dayWithMostIPVisits(ipMap));
        
    }
    
    public void test6iPsWithMostVisitsOnDay(){
        
        LogAnalyzer testLog = new LogAnalyzer();
        testLog.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> ipMap = testLog.iPsForDays();
        System.out.println(testLog.iPsWithMostVisitsOnDay(ipMap,"Sep 30"));
        
    }
}
