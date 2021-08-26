
import edu.duke.*;
import java.util.*;

public class CodonCount {
    private HashMap<String, Integer> dnaMap;
    
    public CodonCount(){
        dnaMap = new HashMap<String, Integer>();
    }
    
    public void buildCodonMap (int start, String dna){
        
        dnaMap.clear();
        for (int k = start ; k < dna.length()-2; k = k+3){
            String codon = dna.substring(k, k+3);
            if (! dnaMap.containsKey(codon)){
                dnaMap.put(codon,1);
            }
            else{
                dnaMap.put(codon, dnaMap.get(codon)+1);
            }
            
        }
        
        
    }
    
    public String getMostCommonCodon(){
        
        int MaxV = 0;
        String mostV = "";
        
        for (String str: dnaMap.keySet()){
            if (dnaMap.get(str) > MaxV){
                MaxV = dnaMap.get(str);
                mostV = str;
                
            }
            
        }
        
        return mostV;
    }
    
    public void printCodonCounts (int start, int end){
        
        for (String s: dnaMap.keySet()){
            if (dnaMap.get(s) > start && dnaMap.get(s) < end){
                System.out.println("The codon between is " + s);
                
            }
        }
        
    }
    
    public void tester (){
        FileResource fr = new FileResource();
        String a = fr.asString();
        // String a = "CGTTCAAGTTCAA";
        a = a.toUpperCase();
       
        
        
        
        
        for (int start = 0; start < 3; start++){
        
        buildCodonMap(start,a);

        System.out.print("Reading frame starting with " + start + " results in " + dnaMap.size() +" unique codons" + "\n");
        
        System.out.print("and most common codon is " + getMostCommonCodon() + "\t " + dnaMap.get(getMostCommonCodon()) + "\n");
        System.out.print("Counts of codons between 6 and 8 inclusive are:" + "\t" + "\n");
        printCodonCounts(6,8);
        
        }
    }
}
