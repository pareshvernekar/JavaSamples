package test.javalambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparatorLambda {

	public static void main(String argv[]) {
		List<Person> personList = new ArrayList<>();
		Person p1 = new Person("peter", "pan", 39);
		Person p2 = new Person("andy","griffith",20);
		Person p3 = new Person("trin","tran",56);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		
		List<Person> personList1 = new ArrayList<>();
		Person p12 = new Person("peter", "pan", 39);
		Person p22 = new Person("andy","griffith",20);
		Person p32 = new Person("trin","tran",56);
		personList1.add(p12);
		personList1.add(p22);
		personList1.add(p32);
		
		
		Comparator<Person> pComparator1 = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if (o1 == null || o2 == null)
					return -1;
				return o1.fName.compareTo(o2.fName);
			}
		};
		
		Comparator<Person> pComparator2 = (Person o1, Person o2) -> {
															if (o1 == null || o2 == null)
																return -1;
															return o1.fName.compareTo(o2.fName);
															};
															
		Collections.sort(personList, pComparator1);
		Collections.sort(personList1, pComparator2);
		for(Person p:personList) {
			System.out.println(p.fName);
		}
		System.out.println("**********************");
		for(Person p:personList1) {
			System.out.println(p.fName);
		}
		
		
		System.out.println(p1.printName(p-> p.fName +","+p.sName));
		System.out.println(p1.printName(p-> p.sName +","+p.fName));
	}
	
}

class Person {
	
	String fName;
	String sName;
	int age;
	
	public Person(String fName, String sName,int age) {
		this.fName = fName;
		this.sName = sName;
		this.age = age;
	}
	
	public String printName(Function<Person, String> func) {
		return func.apply(this);
	}
}
