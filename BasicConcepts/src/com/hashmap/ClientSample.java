package com.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ClientSample {

	public static void main(String[] args) {

		Map<String, Employee> map = new HashMap<String, Employee>();
		map.put("A", new Employee(101, "john", "consultent"));
		map.put("b", new Employee(103, "asif", "Software Engineer"));
		map.put("c", new Employee(102, "amir", "Software Developer"));

		// getting entrySet() into Set
		Set<Entry<String, Employee>> entrymap = map.entrySet();

		for (Entry<String, Employee> entry : entrymap) {

			String key = entry.getKey();

			if (key.equalsIgnoreCase("b")) {
				map.put("d", new Employee(105, "saif", "manager"));
			} else {
				System.out.println(entry.getKey() + "\t" + entry.getValue());
			}
		} 
	}
}

