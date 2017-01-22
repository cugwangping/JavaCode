package JList;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class JListTest extends JFrame{
 /**
	 * 
	 */
	private static final long serialVersionUID = -2615951700230491288L;

public JListTest(){
  Container container = getContentPane();//获取窗体容器
  container.setLayout(new BorderLayout());//设置窗体布局
  JList<Object> jl= new JList<Object>(new MyListModel());//使用自定义模型创建JList
  JScrollPane js = new JScrollPane(jl);//创建滚动面板控制JList
  container.add(js);
  setTitle("在这个窗体使用了列表框");
  setSize(119,150);
  setVisible(true);
  setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  
 }
}
