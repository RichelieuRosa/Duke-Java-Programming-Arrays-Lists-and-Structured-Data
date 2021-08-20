
import edu.duke.*;


public class CaesarCipherTwo {
    private String alphabet;
    private String shifted1;
    private String shifted2;
    private int FirstK;
    private int SecondK;
    
    public CaesarCipherTwo (int key1, int key2){
        
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        shifted1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        
        shifted2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        
        FirstK = key1;
        SecondK = key2;
        
    }
    
    public String encrypt (String input){
        
        StringBuilder output = new StringBuilder(input);
        String alphabetLower = alphabet.toLowerCase();
        String shifted1Lower = shifted1.toLowerCase();
        String shifted2Lower = shifted2.toLowerCase();
        
        
        for (int k = 0; k < input.length(); k ++){
        char c = output.charAt(k);
        int idx = alphabet.indexOf(c);
        int idxLower = alphabetLower.indexOf(c);
        if (k % 2 == 0){
            if (Character.isLowerCase(c)){
                if (idxLower != -1){
                    output.setCharAt(k, shifted1Lower.charAt(idxLower));
                }
                
            }
            else{
                if(idx != -1){
                    output.setCharAt(k,shifted1.charAt(idx));
                }
            }
            
        }
        else{
            if (Character.isLowerCase(c)){
                if (idxLower != -1){
                    output.setCharAt(k, shifted2Lower.charAt(idxLower));
                }
                
            }
            else{
                if(idx != -1){
                    output.setCharAt(k,shifted2.charAt(idx));
                }
            }
            
            
        }
        
        }
        return output.toString();
    }
    
    public String decrypt (String input){
        
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - FirstK, 26 - SecondK); 
        
        String decrypt = cc.encrypt(input);
        
        return decrypt;
    }
}
