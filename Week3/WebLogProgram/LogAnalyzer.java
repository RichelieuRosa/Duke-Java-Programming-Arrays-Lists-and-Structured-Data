
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         
         for (String s: fr.lines()){
             LogEntry netlog = WebLogParser.parseEntry(s);
             records.add(netlog);
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs (){
         
         ArrayList<String> UniqIP = new ArrayList();
         
         for (LogEntry l: records){
             String IpAddre = l.getIpAddress();
             if (! UniqIP.contains(IpAddre)){
                 UniqIP.add(IpAddre);
             }
             
         }
                     
         return UniqIP.size();
     }
     
     public void printAllHigherThanNum (int num){
         
         System.out.println("This entry has a status code higher than ");
         System.out.println(num + " : " + "\n");
         ArrayList<Integer> uniqIp = new ArrayList();
         for (LogEntry l: records){
             if (l.getStatusCode() > num){
                 
                 if (! uniqIp.contains(l.getStatusCode())){
                     
                     uniqIp.add(l.getStatusCode());
                 }
                }
             
             
         }
         System.out.println(uniqIp);
     }
     
     public ArrayList uniqueIPVisitsOnDay (String someday){
         
         ArrayList<String> uniqIpOneDay = new ArrayList();
         for (LogEntry l: records){
             String date = l.getAccessTime().toString();
             
             if (date.contains(someday)){
                 if (! uniqIpOneDay.contains(l.getIpAddress())){
                     uniqIpOneDay.add(l.getIpAddress());
                 }
                 
                 
             }
             
         }
         System.out.println("size is " + uniqIpOneDay.size());
         return uniqIpOneDay;
     }
     
     public int countUniqueIPsInRange (int low, int high){
         System.out.println("This entry has a status code between ");
         System.out.println(low + " and " + high + "\n");
         ArrayList<String> uniqIP = new ArrayList();
         
         for (LogEntry l: records){
             if (l.getStatusCode() >= low && l.getStatusCode() <= high){
                 if (! uniqIP.contains(l.getIpAddress())){
                     uniqIP.add(l.getIpAddress());
                 }
                 
             }

         }
         
         return uniqIP.size();
     }
     
     
     public HashMap countVisitsPerIP(){
         
         HashMap<String,Integer> ipMap = new HashMap<String,Integer>();
         
         for (LogEntry l: records){
             String ipAddr = l.getIpAddress();
             if (! ipMap.containsKey(ipAddr)){
                 ipMap.put(ipAddr,1);
                 
             }
             else{
                 ipMap.put(ipAddr,ipMap.get(ipAddr)+1);
                 
             }
             
         }
         
         return ipMap;
     }
     
     public int mostNumberVisitsByIP(HashMap<String,Integer> uniqMap){
         
         int maxVisit = -1;
         
         for (String key: uniqMap.keySet()){
             if (uniqMap.get(key)> maxVisit){
                 maxVisit = uniqMap.get(key);
             }
         }
         
         return maxVisit;
     }
     
     public ArrayList iPsMostVisits(HashMap<String, Integer> uniqMap){
         ArrayList<String> ipMost = new ArrayList<String>();
         
         int maxVisit = -1;
         //find max value
         for (String key: uniqMap.keySet()){
             if (uniqMap.get(key)> maxVisit){
                 maxVisit = uniqMap.get(key);
             }
         }
         //add max ip into arraylist
         for (String key: uniqMap.keySet()){
             if (uniqMap.get(key) == maxVisit){
                 if (! ipMost.contains(key)){
                     ipMost.add(key);
                 }
                 
             }
             
         }
         
         return ipMost;
     }
     
     public HashMap<String, ArrayList<String>> iPsForDays(){
         
         HashMap<String, ArrayList<String>> ipDays = new HashMap<String, ArrayList<String>>();
         
         
         for (LogEntry l: records){
             
             String ip = l.getIpAddress();
             Date d = l.getAccessTime();
             //determine the MMM DD style (from 5th index to 10th index)
             String datestr = d.toString().substring(4,10);
             
             if (! ipDays.containsKey(datestr)){
                 //create a new arraylist for each date
                 ArrayList<String> ipList = new ArrayList<String>();
                 ipList.add(ip);               
                 ipDays.put(datestr,ipList);
                 
                 
             }
             else{
                 //count repeated ip addresses
                 ipDays.get(datestr).add(ip);
                 
             }
             
         }
         
         return ipDays;
     }
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
         
         int maxIps = -1;
         String maxDay = "";
         for (String s: map.keySet()){
             if (map.get(s).size() > maxIps){
                 
                 maxIps = map.get(s).size();
                 maxDay = s;
             }
             
         }
         
         return maxDay;
     }
     
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map,String day){
         
         ArrayList<String> stringList = new ArrayList<String>();
         stringList = map.get(day);
         
         
         HashMap<String,Integer> ipMap = new HashMap<String,Integer>();
         
         for (String l: stringList){
             //remember l is the IP address
             if (! ipMap.containsKey(l)){
                 ipMap.put(l,1);
                 
             }
             else{
                 ipMap.put(l,ipMap.get(l)+1);
                 
             }
             
         }
         
         stringList = iPsMostVisits(ipMap);
         
         return stringList;
         
     }
}
