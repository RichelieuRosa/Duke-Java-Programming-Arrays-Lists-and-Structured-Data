
import edu.duke.*;

public class WordLengths {
    
    public void countWordLengths (FileResource resource, int[] counts){
        
        int countsLen = counts.length;
        
        for (String word: resource.words()){
            //min: when word length exceeds the countlen, we only record max countlen
            int wordLen = Math.min(wordLength(word),countsLen);
            counts[wordLen]++;
            
        }
        
    }
    //define a method to count word length
    private int wordLength(String word){
        int len =0;
        for (char ch: word.toCharArray()){
            if (Character.isLetter(ch)){
                len++;
            }
            
        }
        
        return len;
    }
    
    //Test 1
    public void testCountWordLengths(){
        //length 30 or more (last element is 30)
        int[] counts = new int [31];
        FileResource fr = new FileResource();
        
        countWordLengths(fr, counts);
        
        for (int i = 1; i < counts.length; i++){
            if (counts[i] != 0){
            System.out.println(counts[i] +" words of length of " + i);} 
        }
        
        System.out.println(indexOfMax(counts));
    }
    
    //Sub method 2
    public int indexOfMax (int[] values){
        
        int indexMax = 0;
        int MaxVal = 0;
        
        for (int k = 0; k < values.length; k++){
            
            if (values[k] > MaxVal){
                MaxVal = values[k];
                indexMax = k;
            }
            
        }
        
        return indexMax;
        
    }
    
}
