package function_package;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Ganesh
 * This class demonstrate function interface
 *
 */
public class FunctionDemo1 {
	
	public static void main(String[] args) {
		
	    List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");
	    
	    //Integer java.util.function.Function.apply(String t)
	    Function<String, Integer> nameMappingFunction = String::length;
	    List<Integer> nameLength = names.stream().map(nameMappingFunction).collect(Collectors.toList());
	    System.out.println(nameLength);
	}
}
