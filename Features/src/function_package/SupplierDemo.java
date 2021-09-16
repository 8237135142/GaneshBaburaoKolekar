package function_package;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

/**
 * @author Ganesh
 * This class demonstrate supplier interface
 *
 */
public class SupplierDemo {

	public static void main(String[] args) {
		
		    Supplier<Double> doubleSupplier1 = () -> Math.random();
		    System.out.println(doubleSupplier1.get());
		    
		    DoubleSupplier doubleSupplier2 = Math::random;
		    System.out.println(doubleSupplier2.getAsDouble());
		}
		/*randomSupplier = () -> Math.random(); 
		randomSupplier = Math::random; */
		
	}

