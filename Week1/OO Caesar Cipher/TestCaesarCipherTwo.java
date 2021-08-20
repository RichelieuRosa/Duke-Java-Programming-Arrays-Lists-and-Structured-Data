
import edu.duke.*;

public class TestCaesarCipherTwo {
    
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
    
    public String halfOfString(String message, int start){

        String result = new String();

        for (int k = start; k < message.length(); k = k + 2){

            result = result + message.charAt(k);


        }
        return result;
    }
    
    public void simpleTests (){
        
        FileResource f = new FileResource();
        String msg = f.asString();
        
        int key1 = 21;
        int key2 = 8;
        // String msg = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        
        
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
        String secret = cc.encrypt(msg);
        
        System.out.println(secret);
        System.out.println(cc.decrypt(secret));
        breakCaesarCipher(secret);
    }
    
    public int getkey(String input){
        int[] letters = countLetters(input);
        int maxI = maxIndex(letters);
        int dkey = maxI -4;
        if (dkey < 0){
            dkey = 26 - (4 - maxI);
        }
        return dkey;
    }
    
    public void breakCaesarCipher (String input){
                        
        String even = halfOfString(input,0);
        String odd = halfOfString(input,1);
        
        int keyF = getkey(even);
        int keyS = getkey(odd);
        
        System.out.println("key1 is " + keyF + " and key2 is" + keyS);
        
    }
}
