package com.cxf.client;

import java.util.HashMap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.cxf.service.BookService;

public class ClientTest {
	private static final QName SERVICE_NAME 
      = new QName("http://service.cxf.com/", "BookService");
	private static final QName PORT_NAME 
      = new QName("http://service.cxf.com/", "BookServicePort");
  private ClientTest() {
  } 
	
	
	public static void main(String[] args) {
		Service service = Service.create(SERVICE_NAME);
		// Endpoint Address
		String endpointAddress = "http://192.168.1.135:9000/BookService";
		
		// Add a port to the Service
		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
		
		HashMap<String,String> hm=new HashMap<String,String>();
		
		BookService bookService=service.getPort(BookService.class);
		hm=bookService.ListAllBook();
		//hm=bookService.queryBookByName("bbb");
		System.out.println("ID号\t书名\t作者\t价格\t网购地址\t\t备注");   
		for(int i=0;i<hm.size();i+=6){   
			int j=i/6;   
			System.out.print(hm.get("bookId"+j)+"\t");   
			System.out.print(hm.get("bookName"+j)+"\t");   
			System.out.print(hm.get("author"+j)+"\t");   
			System.out.print(hm.get("price"+j)+"\t");   
			System.out.print(hm.get("bookUrl"+j)+"\t");   
			System.out.println(hm.get("remark"+j)+"\t");   
			}   
		
		
	        
	}
}
