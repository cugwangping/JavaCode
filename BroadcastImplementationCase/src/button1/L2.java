package button1;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class L2 implements ActionListener {
	private Applet applet;
	L2 (Applet applet){this.applet = applet;}
	public void actionPerformed(ActionEvent e) {
		applet.getAppletContext().showStatus("Button 2 pressed");
	}
}
