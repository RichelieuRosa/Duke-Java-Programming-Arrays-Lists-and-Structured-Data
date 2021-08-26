
import edu.duke.*;
import java.util.*;
import java.io.File;

public class WordsInFiles {
    private HashMap<String,ArrayList> wordsCommon;
    
    public WordsInFiles(){
        wordsCommon = new HashMap<String,ArrayList>();
    }
    
    private void addWordsFromFile (File f){
        FileResource fr = new FileResource(f);
        
        for (String s: fr.words()){
            //if the word does not in the map, write the filename into the arraylist
            if (!wordsCommon.containsKey(s)){
                ArrayList<String> strlist = new ArrayList();
                strlist.add(f.getName());
                wordsCommon.put(s, strlist);
            }
            //if this word exists, check whether the filename exists, if not-add it
            else{
                ArrayList<String> strlist = new ArrayList();
                strlist = wordsCommon.get(s);
                if (! strlist.contains(f.getName())){
                    strlist.add(f.getName());
                    
            }
        }
        
        }
    }
    
    public void buildWordFileMap (){
        wordsCommon.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            addWordsFromFile(f);
        }
        
    }
    
    public int maxNumber (){
        int Max = 0;
        
        for (ArrayList s: wordsCommon.values()){
            
            if (s.size()> Max){
                Max = s.size();
            }
            
        }
        return Max;
    }
    
    public ArrayList wordsInNumFiles (int number){
        
        System.out.println("\n This words appear " + number +" times: ");
        ArrayList<String> list = new ArrayList<String>();
        int count = 0;
        for (String word: wordsCommon.keySet()){
            int fileCounts = wordsCommon.get(word).size();
            if (fileCounts == number){
                list.add(word);
                count ++;
            }
            
        }
        System.out.println(count + " and the words are " + list);
        return list;
    }
    
    public void printFilesIn (String word){
        
        System.out.println("\n This word " + word +" in: ");
        
        for (String k: wordsCommon.keySet()){
            if (k.equals(word)){
                ArrayList filelist = wordsCommon.get(k);
                for (int i =0; i < filelist.size(); i++){
                    System.out.println(filelist.get(i));
                }
                
            }
            
        }
    }
    
    public void tester(){
        buildWordFileMap();
        int max = maxNumber();
        ArrayList list = wordsInNumFiles(4);
        //max number
        System.out.println("Max number is " + max);
        //determine all the words that are in the maximum number of files
        // for (int i = 0; i< list.size(); i ++){
            
            // System.out.println(list.get(i));
            // System.out.println(" and in : " + wordsCommon.get(list.get(i)));
        // }
        // System.out.println("\n");
        //full map print
        // for (String s: wordsCommon.keySet()){
            
            System.out.println("tree" + wordsCommon.get("tree"));
        // }
        
        
    }
}
