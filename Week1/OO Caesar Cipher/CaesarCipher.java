
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class CaesarCipher {
    private String alphabet;
    private String shifted;
    private int mainKey;
    
    public CaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        shifted = alphabet.substring(key) + alphabet.substring(0, key);
        
        mainKey = key;
    }
    
    public String encrypt(String input){
        
        StringBuilder output = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftedLower = shifted.toLowerCase();
        
        for (int k=0; k<input.length();k++){
            char c = output.charAt(k);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            
            if (Character.isLowerCase(c)){
                if (idxLower != -1){
                    output.setCharAt(k, shiftedLower.charAt(idxLower));
                }
                
            }
            else{
                if(idx != -1){
                    output.setCharAt(k,shifted.charAt(idx));
                }
            }
            
        }
        return output.toString();
    }
    
    public String decrypt (String input){
        
        CaesarCipher cc = new CaesarCipher(26 - mainKey); 
        
        String decrypt = cc.encrypt(input);
        
        return decrypt;
        
    }
    
    
}
