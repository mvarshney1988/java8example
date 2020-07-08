

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Operations {

	public static void main(String[] args) {
		Java8Operations operations = new Java8Operations();
		String[] arr = {"apple","mango","apple","orange","orange"};
		operations.convertToList(arr).forEach(s->System.out.println(s));
		operations.listToMap(arr).entrySet().forEach(entry->System.out.println(entry.getKey()+entry.getValue()));
		operations.converToGroupBy(arr).entrySet().forEach(v->v.getValue().forEach(t->System.out.println(t)));
		operations.flatMapExample();
	}
	
	void flatMapExample(){
		List<Address> address = new ArrayList<Address>();
		address.add(new Address("add1"));
		address.add(new Address("add2"));
		Employee e = new Employee();
		e.setId(1);
		e.setName("test");
		e.setSalary(100.0);
		e.setDepartment("Finance");
		e.setAddress(address);
		Employee e1 = new Employee();
		e1.setId(2);
		e1.setName("test2");
		e1.setSalary(200.0);
		e1.setDepartment("IT");
		e1.setAddress(address);
		Map<Integer,String> empMap= Stream.of(e,e1).map(s->s).collect(Collectors.toMap(Employee::getId, Employee::getName));
		Stream.of(e,e1).flatMap(emp->emp.getAddress().stream()).forEach(s->System.out.println(s.getAddress()));
		
		
	}
	<T> List<T> convertToList(T[] arr){
		return Stream.of(arr).collect(Collectors.toList());
		//return null;
		
	}
	
	<T> Map<T,T> listToMap(T[] arr){
		return Stream.of(arr).map(k->(k)).collect(Collectors.toMap(l->l, v->v,(m,n)->m));
		//return null;
		
	}
	
	<T> Map<T, List<T>> converToGroupBy(T[] arr){
		return Stream.of(arr).collect(Collectors.groupingBy(s->s));
		//return null;
		
	}

	<T> Map<T, Long> converToGroupByCount(T[] arr){
		return Stream.of(arr).collect(Collectors.groupingBy(s->s,Collectors.counting()));
		//return null;
		
	}
//	<T> Map<T, Long> converToGroupBySum(T[] arr){
//		return Stream.of(arr).collect(Collectors.groupingBy(s->s,Collectors.summarizingLong(1l)));
//		//return null;
//		
//	}
	
}
class Employee{
private int id;
private String name;
private double salary;
private String department;
List<Address> address;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double d) {
	this.salary = d;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public List<Address> getAddress() {
	return address;
}
public void setAddress(List<Address> address) {
	this.address = address;
}



}
class Address{
private String address;

public Address(String address) {
	this.address = address;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}	

}

