package com.cxf.service;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StringHashMapAdapter  extends XmlAdapter<StringHashMap, HashMap<String, String>> {

	@Override
	public StringHashMap marshal(HashMap<String, String> v) throws Exception {
		StringHashMap map = new StringHashMap();
        for (Map.Entry<String, String> e : v.entrySet()) { 
            StringHashMap.StringHashMapEntry iue = new StringHashMap.StringHashMapEntry();
            iue.setStr1(e.getKey());
            iue.setStr2(e.getValue());
            map.getEntries().add(iue);
        }
        return map;
	}

	@Override
	public HashMap<String, String> unmarshal(StringHashMap v) throws Exception {
		 HashMap<String, String> map = new HashMap<String, String>();
	        for (StringHashMap.StringHashMapEntry e : v.getEntries()) {
	            map.put(e.getStr1(), e.getStr2());
	        }
	        return map;
	}

}
