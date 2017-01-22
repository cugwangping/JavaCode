package com.cxf.service;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
@WebService(endpointInterface = "com.cxf.service.BookService",serviceName = "BookService")
public class BookServiceImpl implements BookService{

	public HashMap<String,String> ListAllBook() {
		SAXReader saxReader= new SAXReader();
		HashMap<String, String> hm = new HashMap<String , String>();
		try{
			Document document = saxReader.read("src/com/cxf/service/Book.xml");
			Element root =document.getRootElement();
			int num=-1;
			for(Iterator iter = root.elementIterator(); iter.hasNext();){
				Element element = (Element) iter.next();
				num++;
				for(Iterator iterInner=element.elementIterator();iterInner.hasNext();){
					Element elementInner = (Element) iterInner.next();
					hm.put(elementInner.getName()+num,elementInner.getText());
					
				}
			}
			
		}catch(DocumentException de){
			de.printStackTrace();
			
		}
		return hm;
		
	}

	public HashMap<String,String> queryBookByName(String bookName) {
		HashMap<String,String> hm=new HashMap<String,String>();
		SAXReader reader = new SAXReader();   
	    try {   
	        Document doc = reader.read("src/com/cxf/service/Book.xml");  
	        List list = doc.selectNodes("/books/book[bookName='"+bookName+"']");
	        Iterator it = list.iterator();    
	        int num=-1;
			while (it.hasNext()) {    
				Element elt = (Element) it.next(); 
				num++;
				for(Iterator iterInner=elt.elementIterator();iterInner.hasNext();){
					Element elementInner = (Element) iterInner.next();
					hm.put(elementInner.getName()+num,elementInner.getText());	
					}
			
			   }
    
	    } catch (Exception e) {   
	        e.printStackTrace();   
	    }
		return hm;   
	}
	
	

}
