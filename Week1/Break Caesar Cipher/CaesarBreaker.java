
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class CaesarBreaker {
    
    public int[] countLetters(String message){
        
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] countLet = new int[26];
        
        for (int i = 0; i < message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            //assign a number to each letter
            int dex = alph.indexOf(ch);
            if (dex != -1){
                countLet[dex] ++;
            }
            
        }
        
        return countLet;
    }
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for (int k = 0; k <vals.length; k++){
            if (vals[k] >vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
               
    }
    
    public String decrypt(String encrypted){
        
        CaesarCipher cc = new CaesarCipher();
        
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        // dkey is for "E" which is the fifth letter
        int dkey = maxDex - 4;
        if (maxDex < 4){
            
            dkey = 26 - (4 - maxDex);
 
        }
        
        return cc.encrypt(encrypted, 26-dkey);

    }
    //define half string
    public String halfOfString(String message, int start){
        
        String result = new String();
        
        for (int k = start; k < message.length(); k = k + 2){
            
            result = result + message.charAt(k);
            
            
        }
        return result;
    }
    //getkey
    
    public int getKey (String s){
        
        int[] letters = countLetters(s);
        int maxI = maxIndex(letters);
        int dkey = maxI -4;
        if (dkey < 0){
            dkey = 26 - (4 - maxI);
        }
        return dkey;
    }
    
    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        
        String even = halfOfString(encrypted,0);
        String odd = halfOfString(encrypted,1);
        
        int key1 = getKey(even);
        int key2 = getKey(odd);
        
        // int key1 = 2;
        // int key2 = 20;
        System.out.println("key1 is " +key1 + " and key2 is " + key2);
        
        //////////
        
        String input1 = cc.encrypt(even, 26 - key1);
        String input2 = cc.encrypt(odd, 26 - key2);
        StringBuilder newinput = new StringBuilder(input1 + input2);
        
        for (int i =0; i<input1.length(); i++){
            newinput.setCharAt(2*i,input1.charAt(i));
            
        }
        for (int k=0; k<input2.length(); k++){
            newinput.setCharAt(2*k+1,input2.charAt(k));
        }
            
        return newinput.toString();   
    }
        
        
    
    
    public void testDecrypt1(){
        CaesarCipher cc = new CaesarCipher();
        String encrypted ="Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        int key = 23;
        String message = cc.encrypt(encrypted, 26 - key);
        System.out.println(message);
        
        System.out.println(decrypt(message));
        
    }
    
    public void testdecryptTwoKeys2(){
        CaesarCipher cc = new CaesarCipher();
        FileResource fr = new FileResource();
        String encrypted = fr.asString ();
        System.out.println(decryptTwoKeys(encrypted));
        
        // String encrypted = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        // System.out.println(decryptTwoKeys(encrypted));
        
    }
    
    
    
}
