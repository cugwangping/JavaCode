package com.cxf.service;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "StringHashMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class StringHashMap {

	 @XmlElement(nillable = false, name = "entry")
	    List<StringHashMapEntry> entries = new ArrayList<StringHashMapEntry>();

	    public List<StringHashMapEntry> getEntries() {
	        return entries;
	    }

	    @XmlAccessorType(XmlAccessType.FIELD)
	    @XmlType(name = "IdentifiedUser")
	    static class StringHashMapEntry {
	        //Map keys cannot be null
	        @XmlElement(required = true, nillable = false)
	        String str1;
	        String str2;
			public String getStr1() {
				return str1;
			}
			public void setStr1(String str1) {
				this.str1 = str1;
			}
			public String getStr2() {
				return str2;
			}
			public void setStr2(String str2) {
				this.str2 = str2;
			}

	       
	    }
	
}
