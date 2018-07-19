package com.example.simple;

import java.util.List;

public class Employee {
	private String name;
	private Double bonus;
	private List<Employee> subemployee;
	
	public Employee(Double bonus, List<Employee> subemployee,String name) {
		super();
		this.bonus = bonus;
		this.subemployee = subemployee;
		this.name = name;
	}
	public List<Employee> getSubemployee() {
		return subemployee;
	}
	public void setSubemployee(List<Employee> subemployee) {
		this.subemployee = subemployee;
	}
	public Double getAverage() {
		return bonus;
	}
	public void setAverage(Double average) {
		this.bonus = average;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
