
import edu.duke.*;

public class WordPlay {
    
    
    public boolean isVowel(char ch){

        if (ch =='a' || ch =='e' || ch =='i'||ch =='o'||ch =='u'||ch =='A'||
        ch =='E'||ch =='I'||ch =='O'||ch =='U'){            
            return true;            
        }
        else{
            return false;
        }
    }
    
    public StringBuilder replaceVowels (StringBuilder phrase, char ch){
        
        
        
        for(int i = 0; i < phrase.length(); i++){
            
            char spec = phrase.charAt(i);
            
            if (isVowel(spec)){
                phrase.setCharAt(i,ch);
            }
            
            
        }
        
        return phrase;
    }
    
    public StringBuilder emphasize(StringBuilder phrase, char ch){
        
        
          for(int i = 0; i < phrase.length(); i++){
            
            char spec = phrase.charAt(i);
            //find our target letter equals 
            if (spec == ch){
                //if odd position
                if (i % 2 != 0){
                    phrase.setCharAt(i,'*');
                }
                else{
                    phrase.setCharAt(i,'+');
                }
            }
         
        }
        return phrase;
    }
    public void testemphasize3(){
        StringBuilder phrase = new StringBuilder("dna ctgaaactga");
        System.out.println(emphasize(phrase, 'a'));
    }
    
}
