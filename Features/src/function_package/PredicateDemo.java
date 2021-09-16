package function_package;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ganesh
 * This class demonstrate predicate interface
 *
 */
public class PredicateDemo {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
		
/*		
 * created a predicate which tests the names that start with S
 * 
 * This predicate is supplied to a stream
*/	   
		Predicate<String> nameStartsWithS = str -> str.startsWith("S");
		
	    names.stream().filter(nameStartsWithS).forEach(System.out::println);
	    
//	    names.stream().filter(str -> str.startsWith("S")).forEach(System.out::println);
	}
}
