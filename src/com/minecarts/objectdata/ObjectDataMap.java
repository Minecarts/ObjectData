package com.minecarts.objectdata;

import java.util.WeakHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ObjectDataMap {
    
	WeakHashMap<Object, HashMap<String, Object>> map;
	
    public ObjectDataMap() {
        map = new WeakHashMap<Object, HashMap<String, Object>>();
    }
    
    public Object get(Object obj, String key) {
    	HashMap<String, Object> data = map.get(obj);
    	return data == null ? null : data.get(key);
    }
    
    public HashMap<String, Object> getAll(Object obj) {
    	return map.get(obj);
    }
    
    public ObjectDataMap set(Object obj, String key, Object value) {
    	HashMap<String, Object> data = map.get(obj);
    	
    	if(data == null) {
    		data = new HashMap<String, Object>();
    		map.put(obj, data);
    	}
    	
    	data.put(key, value);
    	
    	return this;
    }
    
    public ObjectDataMap setAll(Object obj, HashMap<String, Object> data) {
    	map.put(obj, data);
    	return this;
    }
    
    public ObjectDataMap remove(Object obj, String key) {
    	HashMap<String, Object> data = map.get(obj);
    	if(data != null) data.remove(key);
    	return this;
    }
    
    public ObjectDataMap removeAll(Object obj) {
    	map.remove(obj);
    	return this;
    }
    
    public WeakHashMap<Object, Object> withKey(String key) {
    	WeakHashMap<Object, Object> result = new WeakHashMap<Object, Object>();

    	for(Iterator<Entry<Object, HashMap<String, Object>>> entries = map.entrySet().iterator(); entries.hasNext();) {
    		Entry<Object, HashMap<String, Object>> entry = entries.next();
    		if(entry.getValue().containsKey(key)) {
    			result.put(entry.getKey(), entry.getValue().get(key));
    		}
    	}
    	
    	return result;
    }
    
}