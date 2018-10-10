package com.learning;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;
import com.learning.controller.EmployeeController;
import com.learning.model.Employee;
import com.learning.respository.EmployeeRepoImpl;
import com.learning.service.EmployeeService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)

public class EmployeeControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private EmployeeService empService;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testgetAllEmployee() throws Exception {
		Employee emp = new Employee(105, "test22", 11000);
		String json = new Gson().toJson(emp);
		// mockMvc.perform(requestBuilder)
		mockMvc.perform(get("/getAllEmployee")).andExpect(status().isOk());

	}
	
	
	@Test
	public void testgetAEmployee() throws Exception {
		//Employee emp = new Employee(105, "test22", 11000);
		//String json = new Gson().toJson(emp);
		// mockMvc.perform(requestBuilder)
		mockMvc.perform(get("/getEmployee/{eid}",100))
		.andExpect(status().isOk());
		//.andExpect(jsonPath("$[0].enumber", is(100)));
		

	}

}
