package lambdaexpression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person
{
	public int employeeId;
	public String employeeName;
	public String employeeAddress;
	public Person(int employeeId, String employeeName, String employeeAddress) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeAddress == null) ? 0 : employeeAddress.hashCode());
		result = prime * result + employeeId;
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
		if (employeeAddress == null) {
			if (other.employeeAddress != null)
				return false;
		} else if (!employeeAddress.equals(other.employeeAddress))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAddress="
				+ employeeAddress + "]";
	}
	
	
	
}
public class ConstructorReferenceDemo1 {
public static void main(String[] args) {
	
	//Person person = new Person();
	Person p1=new Person(1, "ganesh", "pune");
	Person p2=new Person(1, "gane", "pune");
	
	List<Person> persons= new ArrayList<>();
	persons.add(p1);
	persons.add(p2);
	
	//List<String> names = persons.stream().map(person -> person.getEmployeeName()).collect(Collectors.toList());
	//names.forEach(System.out::println);
	
	List<String> names = persons.stream().map(Person::getEmployeeName).collect(Collectors.toList());
	names.forEach(System.out::println);
}
}
