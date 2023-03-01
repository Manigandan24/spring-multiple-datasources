package com.mss.admin.spring.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.admin.spring.secondary.entity.Employee;

@Repository
public interface SecondaryEmployeeRepository extends JpaRepository<Employee, Integer>{

	
}
