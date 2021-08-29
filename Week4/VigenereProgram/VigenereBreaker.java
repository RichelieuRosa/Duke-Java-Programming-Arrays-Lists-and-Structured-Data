import java.util.*;
import edu.duke.*;
import java.io.File;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String slicer = "";
        for (int i = whichSlice; i < message.length(); i += totalSlices){
            //append each slice into the empty string
            slicer = slicer + message.charAt(i);
            
        }
        return slicer;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        
        CaesarCracker cc = new CaesarCracker();
        
        for (int i = 0; i <klength; i++){
            String sliced = sliceString(encrypted, i, klength);
            int OneKey = cc.getKey(sliced);
            key[i] = OneKey;
        }
        
        return key;
    }

    public void breakVigenere() {
        //create a fileresource
        FileResource fr = new FileResource();
        String content = fr.asString();
        FileResource dic = new FileResource("dictionaries/English");
        HashSet<String> diction = readDictionary(dic);
        //keylength may vary and keep 'e' as most common first
        int[] key = tryKeyLength(content,38,'e');
        //create new vc
        VigenereCipher vc = new VigenereCipher(key);
        //decrypt vc
        String decrypted = vc.decrypt(content);
        //print out
        System.out.println(decrypted);
        //
        System.out.println("\n"+"valid word "+countWords(content,diction));
    }
    
    public void breakVigenere2(){
        FileResource fr = new FileResource();
        String content = fr.asString();
        //read a dictionary
        FileResource dic = new FileResource("dictionaries/English");
        HashSet<String> diction = readDictionary(dic);
        String complex = breakForLanguage(content, diction);
        System.out.println(complex);
    }
    
    //test unknown languages
    public void breakVigenere3(){
        //raw file
        FileResource fr = new FileResource();
        String content = fr.asString();
        //create a hashmap
        HashMap<String,HashSet<String>> langDict = new HashMap<String,HashSet<String>>();
        //read a banch of dictionary
        File folder = new File("dictionaries/");
        File[] filelist = folder.listFiles();
        for (int k=0; k<filelist.length;k++){
            if (filelist[k].isFile()){
                FileResource dicFile = new FileResource();
                HashSet<String> diction = readDictionary(dicFile);
                //add this diction hashset into hashmap
                langDict.put(filelist[k].getName(),diction);
                System.out.println("Current processing in " + filelist[k] + " dictionary");
            }
        }
        
        
        breakForAllLangs(content, langDict);
    }
    
    ///For unknown key length
    public HashSet<String> readDictionary(FileResource fr){
        //create hashset of string
        HashSet<String> wordSet = new HashSet<String>();
        for (String line: fr.lines()){
            String lineLow = line.toLowerCase();
            wordSet.add(lineLow);
            
        }
        return wordSet;
    }
    
    public int countWords(String msg, HashSet dictionary){
        String[] splited = msg.split("\\W+");
        int validword = 0;
        for (int k = 0; k< splited.length; k++){
            String word = splited[k].toLowerCase();
            if (dictionary.contains(word)){
                validword++;
                
            }
            
        }
        return validword;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int mostReal = 0;
        String possResult = "";
        int keylen = 0;
        int[] finalKey = {};
        char mc = mostCommonCharIn(dictionary);
        for (int i = 1; i <= 100; i++){
            int[] key = tryKeyLength(encrypted, i, mc);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int validcount = countWords(decrypted,dictionary);
            if (validcount > mostReal){
                mostReal = validcount;
                possResult = decrypted;
                keylen = i;
                finalKey = key;
            }
        }
        System.out.println("This file contains " + mostReal + " valid words");
        System.out.println("\n"+"key length " + keylen);
        for (int i = 0; i <finalKey.length; i++){
            System.out.println(finalKey[i]);
            
        }
        return possResult;
        
    }
    
    //for other languages
    public char mostCommonCharIn(HashSet<String> dictionary){
        int highest = 0;
        char mostChar = '\0';
        HashMap<Character,Integer> chaCount = new HashMap<Character,Integer>();
        for (String word: dictionary){
            char[] letters = word.toCharArray();
            for (int i = 0; i<letters.length; i++){
                if (!chaCount.containsKey(letters[i])){
                    chaCount.put(letters[i],1);
                }
                else{
                    chaCount.put(letters[i],chaCount.get(letters[i])+1);
                }
            }
        }
        for (char ch: chaCount.keySet()){
            if (chaCount.get(ch)>highest){
                highest = chaCount.get(ch);
                mostChar = ch;
            }
        }
        return mostChar;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> languages){
        int mostValid = 0;
        String decrypted = "";
        String correctLang = "";
        //iterate all languages in the keyset (named as "s")
        for (String s: languages.keySet()){
            String msg = breakForLanguage(encrypted, languages.get(s)); 
            int countW = countWords(msg, languages.get(s));
            if (countW > mostValid){
                mostValid = countW;
                correctLang = s;
                decrypted = msg;
            }
        }
        System.out.println(decrypted);
        System.out.println("\n" + "correct language is " + correctLang);
    }
}
