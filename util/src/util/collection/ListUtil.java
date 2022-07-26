package util.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtil {
	
	public void testSubList() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		al.add("5");
		al.add("6");
		al.add("7");
		al.add("8");
		al.add("9");
		al.add("10");
		al.add("11");
		al.add("12");
		al.add("13");
		
		for(int i = 0; i < al.size(); i++) {
			System.out.println(i + ":" + al.get(i));
		}
		al.subList(10, al.size()).clear();
		for(int i = 0; i < al.size(); i++) {
			System.out.println(i + ":" + al.get(i));
		}
		System.out.println(al.contains("3"));
		System.out.println(al.contains("9"));
		System.out.println(al.contains("22"));
	}
	
	public void testDoubleColon() {
		List<Integer> list = Arrays.asList(1, 3, 2, 4,7);
		
		list.forEach(n -> System.out.println(n));
		list.forEach((Integer n) -> System.out.println(n));
		
		list.forEach(System.out::println);
		//list.forEach((x) -> System.out::println(x));
	}
	
	public void TestDoubleList() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		al.add("5");
		al.add("6");
		al.add("7");
		al.add("8");
		al.add("9");
		al.add("10");
		al.add("11");
		al.add("12");
		al.add("13");
		
		List<List<String>> lls = new ArrayList<List<String>>();
		
		System.out.println(lls.size());
		
		//al.stream().forEach(() -> lls.add(null));
		//al.forEach(null);
		
		
	}
	
	public static void main(String[] args) {
		ListUtil lu = new ListUtil();
		
		lu.testSubList();
		
		System.out.println("================testDoubleColon=================");
		lu.testDoubleColon();
		System.out.println("================testDoubleColon=================");
	}
	
}
