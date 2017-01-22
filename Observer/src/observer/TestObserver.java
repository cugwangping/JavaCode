package observer;

import subject.ConcreteSubject;

public class TestObserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcreteSubject sbj= new ConcreteSubject();
		Observer co1=new ConcreteObserver1();
		Observer co2=new ConcreteObserver2();
		sbj.attach(co1);
		sbj.attach(co2);
		sbj.notifyObservers();
	}

}
