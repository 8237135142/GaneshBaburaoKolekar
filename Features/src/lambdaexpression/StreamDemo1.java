package lambdaexpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {
public static void main(String[] args) {
	List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
	//List<String> sorted = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
	//sorted.forEach(System.out::println);
	
	//List<String> sorted = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
	//sorted.forEach(System.out::println);
	
	Stream.of("this", "is", "a", "list", "of", "strings").sorted(String::compareTo).forEach(System.out::println);
	
	//Stream.of("this", "is", "a", "list", "of", "strings").map(String::length).forEach(System.out::println);
}
}
