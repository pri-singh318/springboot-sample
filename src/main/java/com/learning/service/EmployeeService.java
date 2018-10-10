package com.learning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.model.Employee;
import com.learning.model.EmployeeResponse;
import com.learning.respository.EmployeeRepoImpl;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepoImpl empRepo;

	public List<Employee> getAllEmployee() {

		try {
			return empRepo.getAllEmployee();
		} catch (Exception e) {
			System.out.print("Exception ins fetching employee is" + e.getMessage());
			return new ArrayList<Employee>();

		}

	}

	public EmployeeResponse addEmployee(Employee emp) {
		try {
			return empRepo.addEmployee(emp);
		} catch (Exception e) {
			System.out.print("Exception ins adding employee is" + e.getMessage());
			return new EmployeeResponse("1050", "Application Exception");
		}

	}

	public EmployeeResponse deleteEmployee(int empId) {
		try {
			return empRepo.deleteEmployee(empId);
		} catch (Exception e) {
			System.out.print("Exception in deleting employee is" + e.getMessage());
			return new EmployeeResponse("1050", "Application Exception");
		}

	}

	public Employee getEmployee(int enumber) {
		try {
			return empRepo.getEmployee(enumber);
		} catch (Exception e) {
			System.out.print("Exception in fetching employee is" + e.getMessage());
			return null;
		}

	}

	public EmployeeResponse updateEmployee(Employee emp) {

		try {
			return empRepo.updateEmployee(emp);
		} catch (Exception e) {
			System.out.print("Exception in updaitng employee is" + e.getMessage());
			return null;
		}
	}

}
