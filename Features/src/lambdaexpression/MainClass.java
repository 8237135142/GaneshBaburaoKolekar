package lambdaexpression;

public class MainClass {
public static void main(String[] args) {
	MainClass mainClass = new MainClass();
	
//	MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Good Evening");
	//myFunctionalInterface.wish();
	
	MyFunctionalInterface myFunctionalInterface = mainClass :: msg;
	myFunctionalInterface.wish();
		
}

public void msg()
{
	System.out.println("G A");
}
}
