package com.cxf.service;

import java.util.HashMap;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@WebService
public interface BookService {
	
	 @XmlJavaTypeAdapter(StringHashMapAdapter.class)
	public HashMap<String,String> queryBookByName(String bookName);
	
	 @XmlJavaTypeAdapter(StringHashMapAdapter.class)
	public HashMap<String,String> ListAllBook();

}
