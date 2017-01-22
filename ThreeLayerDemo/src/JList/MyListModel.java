package JList;

import javax.swing.AbstractListModel;

public class MyListModel extends AbstractListModel<Object>{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String[] contents = {"list1","list2","list3","list4","list5","list6"};
	private String[] contents;
	
	public MyListModel(String[] contents){
		this.contents = contents;
	}
	
	public int getSize() {
	  // TODO Auto-generated method stub
	  return contents.length;
	 }
	 public Object getElementAt(int index) {
	  // TODO Auto-generated method stub
	  if(index < contents.length)
	   return contents[index++];
	  else
	   return null;
	  
	 }
}
