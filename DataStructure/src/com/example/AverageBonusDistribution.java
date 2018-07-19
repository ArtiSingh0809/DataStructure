package com.example.simple;

public class AverageBonusDistribution {
	
	public Double averageBonusCalculation(Employee employee) {
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
