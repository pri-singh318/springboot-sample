package com.learning.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.learning.model.Employee;
import com.learning.model.EmployeeResponse;
import com.learning.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	

	/* end point to fetch employee */
	@GetMapping("/getAllEmployee")
	private List<Employee> getAllEmployee() {
		return empService.getAllEmployee();

	}

	/* end point to fetch employee by employee id */
	@GetMapping("/getEmployee/{eid}")
	private Employee getEmployee(@PathVariable("eid") int enumber) {

		System.out.println("value of eid is" + enumber);
		/* fetch employee from service layer */
		return empService.getEmployee(enumber);

	}

	/* end point to delete employee */
	@PostMapping("/deleteEmployee/{eid}")
	private EmployeeResponse deleteEmployee(@PathVariable int eid) {
		System.out.println("Request received for deletion, Emp ID is " + eid);
		return empService.deleteEmployee(eid);

	}

	/* end point to add an employee */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	private EmployeeResponse addEmployee(@RequestBody Employee emp) {

		return empService.addEmployee(emp);

	}

	/* end point to update an employee */
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	private EmployeeResponse updateEmployee(@RequestBody Employee emp) {

		return empService.updateEmployee(emp);

	}

}
