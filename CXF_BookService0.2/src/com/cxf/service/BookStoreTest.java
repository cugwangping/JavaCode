package com.cxf.service;

import java.util.HashMap;

public class BookStoreTest {
	public static void main(String[] args) {
		BookServiceImpl bs=new BookServiceImpl();
		HashMap<String,String> hm=new HashMap<String,String>();
		hm=bs.ListAllBook();
		//hm=bs.queryBookByName("bbb");
		
		System.out.println("ID��\t����\t����\t�۸�\t������ַ\t\t��ע");   
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
