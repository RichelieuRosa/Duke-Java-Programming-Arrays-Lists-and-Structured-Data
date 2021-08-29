
/**
 * Write a description of tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Tester {
    
    public void test01CaesarCipher(){
        FileResource fr = new FileResource();
        String textFile = fr.asString();
        CaesarCipher cc = new CaesarCipher(5);
        
        String enMsg = cc.encrypt(textFile);
        System.out.println(enMsg);
        System.out.println(cc.decrypt(enMsg));
    }
    
    
    public void test02CaesarCracker(){
        FileResource fr = new FileResource();
        String textFile = fr.asString();
        CaesarCracker CaCr = new CaesarCracker();
        
        String enMsg = CaCr.decrypt(textFile);
        System.out.println(enMsg);
        
    }
    
    public void test03VigenereCipher(){
        FileResource fr = new FileResource();
        String textFile = fr.asString();
        int[] key = {17,14,12,4};
        VigenereCipher vc = new VigenereCipher(key);
        
        String enMsg = vc.encrypt(textFile);
        System.out.println(enMsg);
        System.out.println(vc.decrypt(enMsg));
        
    }
    
    public void test1VigenereBreaker(){
        FileResource fr = new FileResource();
        String textFile = fr.asString();
        
        VigenereBreaker vb = new VigenereBreaker();
        
        // String newString = vb.sliceString("abcdefghijklm", 2, 5);
        // System.out.println(newString);
        System.out.println("****possible key****");
        int[] key = vb.tryKeyLength(textFile,4,'e');
        for (int i = 0; i < key.length; i++){
            
            System.out.println(key[i]);
            
        }
    }
    

}
