package subject;

import java.util.Enumeration;
import java.util.Vector;
import observer.Observer;;

public class ConcreteSubject implements Subject {
	private Vector<Observer> observersVector = new Vector<Observer>();
	public void attach(Observer observer){
		observersVector.addElement(observer); 
		}
	public void detach(Observer observer){
		observersVector.removeElement(observer);
		}
	public void notifyObservers(){
		Enumeration<Observer> enumeration = observers();
		while (enumeration.hasMoreElements()){ 
			((Observer)enumeration.nextElement()).update(); 
			}
	}
	@SuppressWarnings("unchecked")
	public Enumeration<Observer> observers(){
		return ((Vector<Observer>)observersVector.clone()).elements();
	}
}
