package button1;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class L1 implements ActionListener {
	private Applet applet;
	L1 (Applet applet){this.applet = applet;}
	public void actionPerformed(ActionEvent e) {
		applet.getAppletContext().showStatus("Button 1 pressed");
	}

}
