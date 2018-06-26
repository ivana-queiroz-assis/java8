package br.com.ivana.java.filters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiltersMain {

	public static void main(String[] args) {
		
		List<String> lines = Arrays.asList("spring","node","ivana");
		
		//I don't wanna Ivana in the list
		
		List<String> result= lines.stream()
				.filter(line-> !"ivana".equals(line))
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		
		//get name of the person
		List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );
		
		// multiples filters 
		Person jack= persons.stream().						//convert to strem
				filter(p-> p.getName().equals("jack")).		//we wan "jack" only
				findAny().									//if 'findAny the return the found
				orElse(null);								//if not found, return null
		System.out.println("Simples filter: "+jack);
		
		
		Person lawrence = persons.stream()
				.filter(p-> {
					if(p.getName().equals("lawrence") && p.getAge()==40) {
						return true;
					}
					return false;
				}).findAny()
				.orElse(null);
		System.out.println("Multiple filters: "+lawrence);
		
		//Find a name in arraylist and return it
		
		String name= persons.stream()
				.filter(p->p.getName().equals("jack"))
				.map(Person::getName)
				.findAny()
				.orElse("");
		System.out.println("Find Jack in arraylist and return it: "+ name);
		
		//Convert Array of Object in arraylist of overwhere you wanna
		List<String> collect = persons.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		collect.forEach(System.out::println);
		
		
	}
	
}
