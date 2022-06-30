package test.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListStrimTest {

	public static void main(String[] args) {
		String group = null;
		List<String> roleList = Arrays.asList(group.split(","));;
		
		System.out.println(roleList.stream().collect(Collectors.joining(", ")));
	}

}
