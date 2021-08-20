
import edu.duke.*;

public class TestCaesarCipher {
    
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
    
    public void simpleTests(){
        FileResource f = new FileResource();
        String msg = f.asString();
       
        int key = 15;
        // String msg = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipher cc = new CaesarCipher(key);
        
        String encrypted = cc.encrypt(msg);
        System.out.println("Encrypted message is " + encrypted);
        // Remember to decrypt the encrypted message! I firstly decrpyt the original
        // message, so it becomes another encrypted message.
        System.out.println("Decrypted message is " + cc.decrypt(encrypted));
        // Only accurate for long text
        // System.out.println("Key is " +breakCaesarCipher(encrypted));
        
    }
    
    public int breakCaesarCipher (String input){
        
        int[] letters = countLetters(input);
        int maxI = maxIndex(letters);
        int dkey = maxI -4;
        if (dkey < 0){
            dkey = 26 - (4 - maxI);
        }
        return dkey;
        
        
    }
}
