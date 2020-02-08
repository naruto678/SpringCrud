package com.example.CrudDemo.entity;

import java.util.List;

public class PersonJson {
	
	private int id;
	private String firstName;
	private String lastName;
	private String favouriteColour;
	private List<String> hobby;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person makePersonFromJson() {
		Person person=new Person();
		person.setFirstName(this.firstName);
		person.setLastName(this.lastName);
	
		person.setAge(this.age);
		StringBuffer strBuffer=new StringBuffer();
		person.setFavouriteColour(this.favouriteColour);
		for(int i=0;i<hobby.size()-1;i++) 
			strBuffer.append(hobby.get(i)+",");
		strBuffer.append(hobby.get(hobby.size()-1));
		
		
		person.setHobby(strBuffer.toString());
		return person;
		
	}
	public String getFavouriteColour() {
		return favouriteColour;
	}
	public void setFavouriteColour(String favouriteColour) {
		this.favouriteColour = favouriteColour;
	}
	
}
