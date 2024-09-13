package tw.test.testS1;

import java.util.LinkedList;
import java.util.List;

public class Student {
	private String name;
	private Integer age;
	private Boolean gender;
	private List<GBike> bikes;
	
	public Student() {
		bikes = new LinkedList<GBike>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public List<GBike> getBikes() {
		return bikes;
	}

	public void setBikes(List<GBike> bikes) {
		this.bikes = bikes;
	}
}
