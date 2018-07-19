package com.example.simple;

import java.util.ArrayList;
import java.util.List;

public class SimpleTree {
	
	public static void main(String[] args) {
		
		
		List<Employee> level3_1 = new ArrayList<>();
		level3_1.add( new Employee(4000.00, null,"level3_1 -1"));
		level3_1.add(  new Employee(4200.00, null,"level3_1 -2"));
		level3_1.add(  new Employee(4400.00, null,"level3_1 -3"));
		List<Employee> level3_2 = new ArrayList<>();
		level3_2.add( new Employee(4000.00, null,"level3_2 -1"));
		level3_2.add(  new Employee(4200.00, null,"level3_2 -2"));
		level3_2.add(  new Employee(4400.00, null,"level3_2 -3"));
		level3_2.add( new Employee(4000.00, null,"level3_2 -1"));
		level3_2.add(  new Employee(4200.00, null,"level3_2 -2"));
		level3_2.add(  new Employee(4400.00, null,"level3_2 -3"));
		List<Employee> level3_3 = new ArrayList<>();
		level3_3.add( new Employee(4000.00, null,"level3_3 -1"));
		level3_3.add(  new Employee(4200.00, null,"level3_3 -2"));
		level3_3.add(  new Employee(4400.00, null,"level3_3 -3"));
		
		
		List<Employee> level2_1 = new ArrayList<>();
		level2_1.add( new Employee(null, level3_1,"level2_1 -1"));
		level2_1.add(  new Employee(null, level3_2,"level2_1 -2"));
		level2_1.add(  new Employee(null, level3_3,"level2_1 -3"));
		
		Employee employee = new Employee(null, level2_1, "Root");
		averageBonusCalculation(employee);
		System.out.println(employee.getAverage());
	}

	private static Double averageBonusCalculation(Employee employee) {
		if(employee.getSubemployee() == null) 
			return employee.getAverage();
		double total = 0;
		for(Employee emp : employee.getSubemployee()) {
					total = total + averageBonusCalculation(emp);
		}
		employee.setAverage(total/employee.getSubemployee().size());
		return total;
		}
		
	

}
