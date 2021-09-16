package function_package;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ganesh
 * This class demonstrate predicate interface
 *
 */
public class PredicatesDemo {

	public static void main(String[] args) {
		
		
		    List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
		    
		    //created a predicate which tests the names that start with S
		    Predicate<String> startPredicate = str -> str.startsWith("S");
		    
		    //created a predicate which tests the length of names 
		    Predicate<String> lengthPredicate = str -> str.length() >= 5;
		    
		    names.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);
		    
//		    names.stream().filter(str -> str.startsWith("S")(str -> str.length() >= 5)).forEach(System.out::println);
		}
	
}
