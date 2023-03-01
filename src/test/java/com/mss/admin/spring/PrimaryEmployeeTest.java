package com.mss.admin.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mss.admin.spring.primary.entity.Employee;
import com.mss.admin.spring.primary.repo.PrimaryEmployeeRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PrimaryEmployeeTest {

	@Autowired
	private PrimaryEmployeeRepository employeeRepo;
	
	public void TestEmployee() {
		Employee emp=new Employee();
		emp.setFirstName("Mani");
		emp.setLastName("Kandan");
		
		employeeRepo.save(emp);
		assertNotNull(employeeRepo.findById(2));
	}
}
