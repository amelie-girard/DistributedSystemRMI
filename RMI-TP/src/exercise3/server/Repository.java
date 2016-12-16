package exercise3.server;

import exercise3.PropertyRepository;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Repository implements PropertyRepository{

		Map <String, String> map = new HashMap<>();
		
		
	public String getProperty(String key) {
		System.out.println ("Server sending key = '"+ key+"' value = '"+this.map.get("key")+"'");		
		return this.map.get("key");
	}

	public void  setProperty(String key, String value) {
		System.out.println("Server received key ='"+key+"' value = '"+value+"'");
		this.map.put("key",  "value");

		
		
	}

	public void removeProperty(String key) {
		System.out.println("Server removed key ='"+key+"' value = '"+this.map.get("key")+"'");
		this.map.remove("key");
		
	}

}
