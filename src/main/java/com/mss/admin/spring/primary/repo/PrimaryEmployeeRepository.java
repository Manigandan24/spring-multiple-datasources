package com.mss.admin.spring.primary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.admin.spring.primary.entity.Employee;

@Repository
public interface PrimaryEmployeeRepository extends JpaRepository<Employee, Integer>{

}
