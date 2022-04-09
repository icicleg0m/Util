package util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MapUtil {

	public static void printMap(HashMap<String, String> map) {

//		for()

	}
	
	public static void testsort() {
		Map<String, String> map = new HashMap<>();
        
        map.put("A", "29");
        map.put("C", "19");
        map.put("D", "31");
        map.put("B", "15");
         
        List<String> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 //
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
         
        for(String key : keySetList) {
            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }
         
        System.out.println("-----------------------------------------------------------------");
         
        // 오름차순 //
        Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
         
        for(String key : keySetList) {
            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }
 
	}

	public static void multiMapSetValueTest(HashMap<String, HashSet<String>> map) {

		Iterator<String> keys = map.keySet().iterator();

		System.out.println("=======================================================");
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));
		}
		System.out.println("=======================================================");
		// 방법2
		for (HashMap.Entry<String, HashSet<String>> elem : map.entrySet()) {
			System.out.println(String.format("키 : %s, 값 : %s", elem.getKey(), elem.getValue()));
		}
		System.out.println("=======================================================");

		// 방법3
		for (String key : map.keySet()) {
			System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));
		}
		System.out.println("=======================================================");

	}
	
	public static HashMap<String, HashSet<String>> setHashMapInSetValue(HashMap<String, HashSet<String>> map,
			String key, String value) {
		HashSet<String> set;
		if(map.containsKey(key)) {
			set = map.get(key);
			
		}else {
			set = new HashSet<String>();
		}
		set.add(value);
		map.put(key, set);
		return map;
	}

	public static void main(String[] args) {

		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		setHashMapInSetValue(map, "0", "00");
		setHashMapInSetValue(map, "0", "11");
		setHashMapInSetValue(map, "0", "333");
		setHashMapInSetValue(map, "1", "11");
		setHashMapInSetValue(map, "1", "11");
		setHashMapInSetValue(map, "1", "22");
		setHashMapInSetValue(map, "1", "33");
		
		
		
		
//		HashSet<String> set1 = new HashSet<String>();
//		set1.add("set1-1");
//		set1.add("set1-1");
//		set1.add("set1-2");
//		set1.add("set1-3");
//		HashSet<String> set2 = new HashSet<String>();
//		set2.add("set2-test");
//		set2.add("set2-test12");
//		set2.add("set2-test");
//		set2.add("set2-test");
//		HashSet<String> set3 = new HashSet<String>();
//		set3.add("set3");
//		set3.add("set3");
//		set3.add("set3");
//		set3.add("set3");
//		map.put("set1", set1);
//		map.put("set2", set2);
//		map.put("set3", set3);
//		set3.add("set3-new");
//		map.put("set3-enw", set3);
		multiMapSetValueTest(map);
		
		
		testsort();
	}

}
