package lambdaexpression;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		
		List<Integer> values = new ArrayList<Integer>();
		values.add(12);
		values.add(25);
		values.add(15);
		
		values.forEach((x)-> System.out.println(x));
		
		//values.forEach(System.out::println);
		
		/*for(int i:values)
		{
			if(i%2==0)
			{
			System.out.println(i);
			}
		}*/
	}
}
