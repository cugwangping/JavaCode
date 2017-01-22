package subject;

import observer.Observer;;

public interface Subject {
	public void attach(Observer observer);
	public void detach(Observer observer);
	void notifyObservers();
}
