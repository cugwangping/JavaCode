package pipe;

//import java.awt.List;
import java.util.ArrayList;

public class PipeImpl implements Pipe{
	private ArrayList<Object> buffer = new ArrayList<Object>();
	public synchronized boolean put(Object obj){
		boolean bAdded = buffer.add(obj);
		notify();
		return bAdded;
	}
	
	public synchronized Object get() throws InterruptedException{
		while(buffer.isEmpty())
			wait(); //pipe empty-wait
		Object obj = buffer.remove(0);
		return obj;
	}
}
