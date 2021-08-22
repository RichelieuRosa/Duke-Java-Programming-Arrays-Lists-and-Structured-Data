
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }   
    
    public void findUnique (){
        FileResource fr = new FileResource();
        
        myWords.clear();
        myFreqs.clear();
        
        for (String s: fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                //get how many of one word (at "index" location)
                int value = myFreqs.get(index);
                //then add one to that number (at "index" location)
                myFreqs.set(index, value+1);
                        
        }
        
        
       }
    }
    
    public void tester(){
        findUnique();
        System.out.println("unique words" + myWords.size());
        System.out.println("Max number is" + findIndexOfMax());
        for (int k =0; k < myWords.size(); k++){
            
            //System.out.println(myFreqs.get(k) + " " + myWords.get(k));
        }
    }
    
    public int findIndexOfMax (){
        int Max = 0;
        for (int k=0; k<myFreqs.size(); k++){
            if (myFreqs.get(k)>myFreqs.get(Max)){
                Max = k;
            }
            
        }
        System.out.println(myWords.get(Max));
        return myFreqs.get(Max);
        
    }
}
