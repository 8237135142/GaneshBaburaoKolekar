package function_package;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Ganesh
 * This class demonstrate consumer
 *
 */

public class ConsumerDemo {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
		
		 /*
		  * 
		  * 1. Anonymous inner class implementation
		  * 
		  */
		strings.forEach(new Consumer<String>(){ //forEach() method pass all element from Iterable Collection to the consumer argument
		 @Override
		 public void accept(String s)
		 {
			 System.out.println(s);
		 }
	});
		
		/* 
		 * 2. using lambda expression
		 */
		strings.forEach(s -> System.out.println(s));
		
		/*
		 *  3. using method reference
		 */
		strings.forEach(System.out::println);
}
}