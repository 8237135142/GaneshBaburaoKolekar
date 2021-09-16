package lambdaexpression;

import java.util.Date;

@FunctionalInterface
public interface MyFunctionalInterface {

	public void wish();
	
	//public int addition(int a, int b);
	
	public default void getDate()
	{
		System.out.println("Date:"+new Date());
	}
	
	
}
