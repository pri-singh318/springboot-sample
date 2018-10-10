package com.learning.respository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.learning.model.Employee;
import com.learning.model.EmployeeResponse;
import com.learning.service.EmployeeService;

@Repository
public class EmployeeRepoImpl  {

	private static List<Employee> empList = new ArrayList<Employee>();

	/* stubbing the employee list */
	 static  {
		Employee emp1 = new Employee(100, "John", 12000);
		Employee emp2 = new Employee(101, "Dave", 15000);

		empList.add(emp1);
		empList.add(emp2);
	}

	/* get All employee from list */
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empList;
	}

	
	/* Add a employee */
	public EmployeeResponse addEmployee(Employee emp) {
		// TODO Auto-generated method stub

		if (emp == null) {
			new EmployeeResponse("1021", "invalid employee");
		}

		for (Employee employee : empList) {
			if (emp.getEnumber() == employee.getEnumber()) {
				return new EmployeeResponse("1020", "Employee Already Exist");

			}
		}

		empList.add(emp);

		return new EmployeeResponse("1001", "Employee Added successfully");
	}

	
	/* delete a employee */
	public EmployeeResponse deleteEmployee(int empId) {
		// TODO Auto-generated method stub

		List<Employee> updatedEmpList = empList.stream().filter(em -> em.getEnumber() != empId)
				.collect(Collectors.toList());

		/*
		 * List<Employee> updaedEmpList2 = empList.stream() .parallel() .filter(em ->
		 * em.getEnumber() !=empId ) .collect(Collectors.toCollection(ArrayList::new));
		 */

		if (empList != null && updatedEmpList != null && empList.size() == updatedEmpList.size()) {

			return new EmployeeResponse("1021", "Employee does not exist");
		}
		empList = updatedEmpList;
		updatedEmpList.forEach(emp -> System.out.print(emp));
		empList.forEach(emp -> System.out.print(emp));

		return new EmployeeResponse("1003", "Employee delete successfully");
	}

	
	/* get a specific employee */
	public Employee getEmployee(int enumber) {
		// TODO Auto-generated method stub

		List<Employee> updaedEmpList2 = empList.stream().parallel().filter(em -> em.getEnumber() == enumber)
				.collect(Collectors.toCollection(ArrayList::new));
		if (updaedEmpList2 != null && updaedEmpList2.size() > 0)
			return updaedEmpList2.get(0);
		return null;
	}

	
	/* this is to update an existing employee */
	public EmployeeResponse updateEmployee(Employee emp) {
		// TODO Auto-generated method stub

		if (emp == null) {
			new EmployeeResponse("1021", "Employee does not exist or invalid!!");
		}

		for (Employee employee : empList) {
			if (emp.getEnumber() == employee.getEnumber()) {
				empList.remove(employee);
				empList.add(emp);

			}
		}

		return new EmployeeResponse("1002", "Employee updated successfully");

	}

}
