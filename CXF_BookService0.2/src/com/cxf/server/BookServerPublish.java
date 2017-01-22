package com.cxf.server;

import javax.xml.ws.Endpoint;

import com.cxf.service.BookServiceImpl;

public class BookServerPublish {
	protected BookServerPublish() throws Exception {
        // START SNIPPET: publish
        System.out.println("Starting Server");
        BookServiceImpl impl=new BookServiceImpl();
        String address = "http://192.168.1.135:9000/BookService";
        Endpoint.publish(address, impl);
        // END SNIPPET: publish
    }

    public static void main(String args[]) throws Exception {
        new BookServerPublish();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }

}
