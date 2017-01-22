package player;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.media.bean.playerbean.MediaPlayer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import java.applet.*; 

public class PlayTest extends Applet {
	 /**
	 * 
	 */
	public MediaPlayer mPlayer = new MediaPlayer();
	public static int playNum = 0; 
	private static final long serialVersionUID = 1L;
	
	JButton b1 = new JButton("打开");
	JButton b2 = new JButton("播放"); 
	JButton b3 = new JButton("暂停");
	JButton b4 = new JButton("停止"); 
	JTextField t = new JTextField(20);
	public void init() { 
	    b1.addActionListener(new B1()); 
	    b2.addActionListener(new B2()); 
	    b3.addActionListener(new B3()); 
	    b4.addActionListener(new B4()); 

	    add(b1); 
	    add(b2); 
	    add(b3); 
	    add(b4); 
	    add(t);
	    
	  } 
	 class B1 implements ActionListener { 
	    public void actionPerformed(ActionEvent e) { 
	    	
	    	JFileChooser fd = new JFileChooser();  
	    	fd.setFileSelectionMode(JFileChooser.OPEN_DIALOG);  
	    	fd.showOpenDialog(null);  
	    	File f = fd.getSelectedFile();  
	    	if(f != null){
	    		System.out.println("加载文件");
	    		t.setText(f.toString());
	    	}else {
				System.out.println("文件打开失败");
			}	
	    } 
	  } 
	  class B2 implements ActionListener { 
	    public void actionPerformed(ActionEvent e) { 
	      mPlayer.start();
	    } 
	  } 
	  
	  class B3 implements ActionListener { 
		    public void actionPerformed(ActionEvent e) { 
		      if(playNum == 0){
		    	playNum = 1;
		    	mPlayer.stop();
		      }else{
		    	  playNum = 0;
		    	  mPlayer.start();
		      }  	  
		    } 
		  } 
	  class B4 implements ActionListener { 
		    public void actionPerformed(ActionEvent e) { 
		      mPlayer.start();
		    } 
		  } 
	  // To close the application: 
	  static class WL extends WindowAdapter { 
	    public void windowClosing(WindowEvent e) { 
	      System.exit(0); 
	    } 
	  } 
	  // A main() for the application: 
	  public static void main(String[] args) { 
	    PlayTest applet = new PlayTest(); 
	    Frame aFrame = new Frame("MediaPlayer"); 
	    aFrame.addWindowListener(new WL()); 
	    aFrame.add(applet, BorderLayout.CENTER); 
	    aFrame.setSize(300,200); 
	    applet.init(); 
	    applet.start(); 
	    aFrame.setVisible(true); 
	  } 
}
