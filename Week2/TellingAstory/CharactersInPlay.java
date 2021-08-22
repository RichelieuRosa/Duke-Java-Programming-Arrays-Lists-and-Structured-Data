
import edu.duke.*;
import java.util.ArrayList;
public class CharactersInPlay {
    
    private ArrayList<String> chaName;
    private ArrayList<Integer> chaCount;
    
    public CharactersInPlay(){
        chaName = new ArrayList<String>();
        chaCount = new ArrayList<Integer>();
    }  
    
    public void update(String person){
        
        
        int index = chaName.indexOf(person);
        
        if (index == -1){
            chaName.add(person);
            chaCount.add(1);
        }
        else{
            int value = chaCount.get(index);
            chaCount.set(index, value+1);
        }
        
        
    }
    
    public void findAllCharacters (){
        FileResource f = new FileResource();
        
        for (String l: f.lines()){
            int periodPos = l.indexOf(".");
            
            if (periodPos != -1){
                String person = l.substring(0,periodPos);
                
                update(person);
                
            }
            
        }
        
        
    }
    
    public void tester (){
        chaName.clear();
        chaCount.clear();
        findAllCharacters();
        
        for (int k =0; k < chaName.size(); k++){
            if (chaCount.get(k) > 20){
                System.out.println(chaName.get(k) + "\t" + chaCount.get(k));
            }
        //System.out.println("Most frequency is " + chaName.get(Max) + chaCount.get(Max) + " times");
        
       }
        charactersWithNumParts(10,15);
    }
    
    public void charactersWithNumParts (int num1, int num2){
        
        // num1 <= num2 
        
        System.out.println("Character between " + num1 + " and " + num2);
        
        for (int k = 0; k < chaName.size(); k ++){
            
            if (chaCount.get(k) >= num1 && chaCount.get(k)<= num2){
                System.out.println(chaName.get(k) + " \t" + chaCount.get(k));
            }
        }
    }
}
