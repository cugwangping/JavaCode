package wordGenerator;

import pipe.*;
import filter.*;

public class Master {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pipe pipe = new PipeImpl();
		Thread wordGenerator = new WordSortGenerator(pipe);
		Thread wordSortFilter = new WordSortFilter(pipe);
		wordGenerator.start();
		wordSortFilter.start();
	}

}