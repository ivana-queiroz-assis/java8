package br.com.ivana.java.foreach;

public class Pessoa {
	
	public Pessoa(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pessoa [age=" + age + ", name=" + name + "]";
	}

}
