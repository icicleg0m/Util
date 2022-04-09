package util.collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetUtil {
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("a");
//		set.add("v");
//		set.add("c");
//		set.add("s");
//		set.add("d");
//		set.add("d");
//		set.add("w");
//		set.add("k");
		
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println("==" + iter.next());
		}
	}
	
	
}
