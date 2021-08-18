
import edu.duke.*;

public class CaesarCipher {

    public String encrypt (String input, int key){
        
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLow = alphabet.toLowerCase();
        
        String shifted = alphabet.substring(key) + alphabet.substring(0,key);
        String shiftedLow = alphabetLow.substring(key) + alphabetLow.substring(0,key);
        
        for (int i = 0; i < encrypted.length(); i ++){
            
            char currChar = encrypted.charAt(i);

            
            if (Character.isUpperCase(currChar) == true){
                int idx = alphabet.indexOf(currChar);
                
                if (idx != -1){
                    char cr = shifted.charAt(idx);
                    encrypted.setCharAt(i, cr);
                }
                
            }
            else{
                int index = alphabetLow.indexOf(currChar);
                
                if (index != -1){
                    char crL = shiftedLow.charAt(index);
                    encrypted.setCharAt(i, crL);
                }
            }
        }
            
        return encrypted.toString();
        
    }
    
    public String encryptTwoKeys (String input, int key1, int key2){
        
        StringBuilder encrypted = new StringBuilder(input);
        
        String oddOut = encrypt(input, key1);
        String evenOut = encrypt(input, key2);
        System.out.println(oddOut+ " " + evenOut);
        
        for (int i = 0; i < encrypted.length(); i ++){
            char currChar = encrypted.charAt(i);
            //even (first is 0)
            if (i % 2 == 0){
                char ev = oddOut.charAt(i);
                encrypted.setCharAt(i, ev);
            }
            else{
                char od = evenOut.charAt(i);
                encrypted.setCharAt(i, od);
            }
        }
                
        return encrypted.toString();
    }
    
    //test Ceaser
    
    public void testCaesar(){

    // FileResource fr = new FileResource();
    // String message = fr.asString();
    
    int key1 = 8;
    int key2 = 21;
    String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
    
    String encrypted = encryptTwoKeys(message, key1, key2);
    System.out.println("key is " + key1 + key2 + "\n" + encrypted);
    
    
    }
}
