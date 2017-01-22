package player;

import java.awt.*; 
import java.awt.event.*;
import java.applet.*; 
import javax.media.bean.playerbean.MediaPlayer; 
//必须下载 jmf 媒体播放包
public class MusicPlayer extends Applet implements ActionListener { 
	Button b1, b2;
	MediaPlayer mPlayer;
	public void init() {
		mPlayer = new MediaPlayer(); 
		setLayout(new FlowLayout());
		try{
		player.setMediaLocation("file:/E:\\a.wav");// <<file:/>>不能删除 音频文件路径 
		} catch (Exception e) { 
		System.out.println("文件不存在");
		} 
		b1 = new Button("播放");
		b2 = new Button("停止"); 
		add(b1); 
		add(b2); 
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(200, 200); 
		setVisible(true); 
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) { 
			player.start(); 
		} else if (e.getSource() == b2) {
			player.stop();
			System.out.println(player.getMediaTime().getSeconds());
		}
	} 
}

