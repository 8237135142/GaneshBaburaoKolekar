package function_package;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Ganesh
 * This class demonstrate consumer
 *
 */
public class ConsumerDemo1 {

	public static void main(String[] args) {
		
		    List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");
		   // System.out.println(cities);
/*	   
 * we have created two consumers 
 * 
 * one converts a list of items into upper case Strings
 * 
 * the other one prints the uppercased string
 * 
*/		 
		    Consumer<List<String>> upperCaseConsumer = list -> {
		        for(int i=0; i < list.size(); i++){
		            list.set(i, list.get(i).toUpperCase());
		        }
		    };
		    
		    Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);
		    upperCaseConsumer.andThen(printConsumer).accept(cities);
		    
		    System.out.println(cities);
		}
	}

