package br.com.ivana.java.foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ForeachMain {
	public static void main(String[] args) {

		// Foreach in map
		System.out.println("Foreach in Map");
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k, v) -> System.out.println("Item: " + k + ", count: " + v));

		items.forEach((k, v) -> {
			System.out.println("Item: " + k + ", count: " + v);
			if ("E".equals(k)) {
				System.out.println("Hello E");
			}
		});

		// Foreach in list
		System.out.println("Foreach in List");

		List<String> items1 = new ArrayList<>();
		items1.add("A");
		items1.add("B");
		items1.add("C");
		items1.add("D");
		items1.add("E");

		// lambda
		items1.forEach(item -> System.out.println(item));

		// lambda com if
		items1.forEach(item -> {
			if ("C".equals(item)) {
				System.out.println(item);
			}
		});

		// method reference
		items1.forEach(System.out::println);

		// stream and filter
		items1.stream().filter(s -> s.contains("B")).forEach(System.out::println);

		// strem and filter and map
		List<Pessoa> listaPessoas = Arrays.asList(new Pessoa("Joao", 32), new Pessoa("Antonio", 20),
				new Pessoa("Maria", 18), new Pessoa("Angela", 30), new Pessoa("Ivana",18));

		System.out.println("Sum of age of the people with start with letter 'A: '"
				+ listaPessoas.stream().filter(p -> p.getName().startsWith("A")).mapToInt(p -> p.getAge()).sum());

		System.out.println("Minimum of age in the list of people: "
				+ listaPessoas.stream().mapToInt(p -> p.getAge()).min().getAsInt());

		System.out.println("Maximum of age in the list of people: "
				+ listaPessoas.stream().mapToInt(p -> p.getAge()).max().getAsInt());

		// Convert Stream to list, set or map
		Map<Integer, List<Pessoa>> map = listaPessoas.stream().collect(Collectors.groupingBy(Pessoa::getAge));
		System.out.println("Convert Stream to map");
		map.get(18).forEach(p -> System.out.println("Name: " + p.getName() + ", age:" + p.getAge()));

		
		
	}
}
