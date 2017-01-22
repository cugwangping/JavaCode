package button1;

import java.applet.Applet;
import java.awt.Button;


public class Button1Applet extends Applet{
	Button b1 = new Button("Button 1");
	Button b2 = new Button("Button 2");
	public void init(){
		b1.addActionListener(new L1(this));
		b2.addActionListener(new L2(this));
		add(b1);
		add(b2);
	}
}
