package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import pipe.*;

public class WordSortFilter extends Thread {
    private Pipe pipe = null;
    private ArrayList<String> wordList = new ArrayList<String>();
    public WordSortFilter(Pipe _pipe) {
        pipe = _pipe;
    }
    public void run() {
        String word = null;
        /*
        try {
            while ((word = (String) pipe.get()) != null)
                wordList.add(word);
        } catch (InterruptedException intrtex) {}
        //now sort the word list
        Collections.sort(wordList);
        //print the sorted word list and write it to a file
        try {
            FileWriter fw = new FileWriter("sortedwords.txt");
            for (String s : wordList) {
                System.out.println(s);
                fw.write(s + "\n");
            }
            fw.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        //*/
        try {
            while ((word = (String) pipe.get()) != null){
                wordList.add(word);
                Collections.sort(wordList);
                for (String s : wordList)
                    System.out.println(s);
                System.out.println("\n");
                }
        }catch (InterruptedException intrtex) {}
        //now sort the word list
      
        //print the sorted word list and write it to a file
        try {
            FileWriter fw = new FileWriter("sortedwords.txt");
            for (String s : wordList) {
                System.out.println(s);
                fw.write(s + "\n");
            }
            fw.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
    


