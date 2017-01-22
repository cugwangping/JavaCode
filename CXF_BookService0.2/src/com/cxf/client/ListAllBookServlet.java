package com.cxf.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.cxf.service.BookService;

public class ListAllBookServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		QName SERVICE_NAME = new QName("http://service.cxf.com/", "BookService");
		QName PORT_NAME = new QName("http://service.cxf.com/", "BookServicePort");
		Service service = Service.create(SERVICE_NAME);
		// Endpoint Address
		String endpointAddress = "http://192.168.135:9000/BookService";
		
		// Add a port to the Service
		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
		
		HashMap<String,String> hm=new HashMap<String,String>();
		
		BookService bookService=service.getPort(BookService.class);
		hm=bookService.ListAllBook();
		//hm=bookService.queryBookByName("bbb");
		
		List<BookInfo> books=new ArrayList<BookInfo>();
		
		for(int i=0;i<hm.size();i+=6){   
			int j=i/6;   
			BookInfo bookInfo=new BookInfo();
			bookInfo.setBookId(hm.get("bookId"+j));
			bookInfo.setBookName(hm.get("bookName"+j));
			bookInfo.setAuthor(hm.get("author"+j));
			bookInfo.setPrice(Integer.parseInt(hm.get("price"+j)));
			bookInfo.setBookUrl(hm.get("bookUrl"+j));
			bookInfo.setRemark(hm.get("remark"+j));
			books.add(j,bookInfo);
			 
		}
		
		req.setAttribute("books", books);
		req.getRequestDispatcher("/QueryBookInfo.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

}
