package function_package;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ganesh
 * This class demonstrate supplier interface
 *
 */
public class SuppliersDemo {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Snara", "Zoë", "Sayne", "Simon", "River");
		Optional<String> first = names.stream().filter(name -> name.startsWith("S")).findFirst();

		/*
		 * not present then its show o/p - Optional.empty
		 */
		// System.out.println(first); //

		/*
		 * not present then its show o/p - None
		 */
		// System.out.println(first.orElse("None"));

		/*
		 * not present then its show O/p - No result found in Mal, Wash, Kaylee, Inara, Zoë, Sayne, Simon, River
		 */
		System.out.println(
				first.orElse(String.format("No result found in %s", names.stream().collect(Collectors.joining(", ")))));

		/*
		 * delaying the execution until it is needed For example, Optional class
		 * has a method named orElseGet This method is triggered if optional
		 * does not have data
		 * 
		 * not present then its show O/p - No result found in Mal, Wash, Kaylee, Inara, Zoë, Sayne, Simon, River
		 */
		// System.out.println(first.orElseGet(
		// () -> String.format("No result found in %s",
		// names.stream().collect(Collectors.joining(", ")))));

	}
}
