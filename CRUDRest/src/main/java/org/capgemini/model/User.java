package org.capgemini.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Comparable<User>{
	
	private int id;
	private String name;
	private int age;
	private String gender;
	
	public User() {
		
	}
	
	public User(int id, String name, int age, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public User(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int compareTo(User user) {
		if(this.getId() > user.getId())
			return 1;
		else if(this.getId() == user.getId())
			return 0;
		else
			return -1;
	}
		
}