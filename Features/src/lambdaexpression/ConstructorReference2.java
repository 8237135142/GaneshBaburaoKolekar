package lambdaexpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person1
{
	
	public String employeeName;
	
	

	public Person1(String employeeName) {
		super();
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [employeeName=" + employeeName + "]";
	}
	
	
	
	
}
public class ConstructorReference2 {
public static void main(String[] args) {
	List<String> names = Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace","Karen Spärck Jones");
	//List<Person1> people = names.stream().map(name -> new Person1(name)).collect(Collectors.toList());
	
	List<Person1> people = names.stream().map(Person1::new).collect(Collectors.toList());
	people.forEach(System.out::println);
}
}
