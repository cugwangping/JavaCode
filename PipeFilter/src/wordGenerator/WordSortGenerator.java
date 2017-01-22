package wordGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import pipe.*;

public class WordSortGenerator extends Thread{
	private Pipe pipe = null;
	public WordSortGenerator(Pipe _pipe){
		pipe = _pipe;
	}
	
	public void run(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("words.txt"));
			String word = null;
			while(!(word = br.readLine()).equals("stop"))
				pipe.put(word);
			 pipe.put(null); //null signals no more input
	         br.close();
		}catch (IOException ioex) {
            ioex.printStackTrace();
        }
	}
}
