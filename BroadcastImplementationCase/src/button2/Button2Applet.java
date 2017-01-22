package button2;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;

public class Button2Applet extends Applet {
	Button b1 = new Button("Button 1");
	Button b2 = new Button("Button 2");
	public void init(){
		add(b1);
		add(b2);
	}
	
	public boolean action (Event evt, Object obj){
		if(evt.target.equals(b1))
			getAppletContext().showStatus("Button 1 pressed");
		else if(evt.target.equals(b2))
			getAppletContext().showStatus("Button 2 pressed");
		else
			return super.action(evt, obj);
		return true;
		}
}
