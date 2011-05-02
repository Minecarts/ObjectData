package com.minecarts.objectdata;

import java.util.HashMap;
import java.util.WeakHashMap;

public class ObjectDataMap {
    
    HashMap<String, WeakHashMap<Object, Object>> map;
    
    public ObjectDataMap() {
        map = new HashMap<String, WeakHashMap<Object, Object>>();
    }
    
    public Object get(Object obj, String key) {
        WeakHashMap<Object, Object> data = map.get(key);
        return data == null ? null : data.get(obj);
    }
    
    public ObjectDataMap set(Object obj, String key, Object value) {
        WeakHashMap<Object, Object> data = map.get(key);
        
        if(data == null) {
            data = new WeakHashMap<Object, Object>();
            map.put(key, data);
        }
        
        data.put(obj, value);
        
        return this;
    }
    
    public ObjectDataMap remove(Object obj, String key) {
        WeakHashMap<Object, Object> data = map.get(key);
        if(data != null) data.remove(obj);
        return this;
    }
    
    public WeakHashMap<Object, Object> withKey(String key) {
        return map.get(key);
    }
    
    public String[] keys() {
        return map.keySet().toArray(new String[0]);
    }
    
}