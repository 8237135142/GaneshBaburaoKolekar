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

public class FunctionDemo {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara", "Zoë", "Jayne", "Simon", "River");
		
		/*
		 * 
		 * implement Anonymous inner class
		 * 
		 */
		
		/*List<Integer> nameLengths = names.stream().map(new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {    		//iterate each element
				return s.length();						//return length of each string
			}
		}).collect(Collectors.toList());				//represent the list of lenghts
		System.out.println(nameLengths);
		*/
		
		/*
		 * 
		 * using lambda expression
		 * 
		 */
		
		Function<String, Integer> nameMappingFunction = s -> s.length();
		  List<Integer> nameLengths = names.stream().map(nameMappingFunction).collect(Collectors.toList());
		System.out.println(nameLengths);
	
	
		/*
		 * 
		 * using method reference
		 * 
		 */
//		Function<String, Integer> nameMappingFunction = String::length;
//		List<Integer> nameLengths = names.stream().map(nameMappingFunction).collect(Collectors.toList());
//		System.out.println(nameLengths);
		
	}
}


//nameLengths == [3, 4, 6, 5, 3, 5, 5, 5]




