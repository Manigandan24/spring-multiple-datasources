package com.mss.admin.spring.secondary.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table
@GenericGenerator(name="emp_sequence",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
parameters = {
		@Parameter(name="sequence_name", value="emp-sequence"),
				@Parameter(name="initial_value",value="2"),
				@Parameter(name="increment_size",value="1")
})
public class Employee {

	@Id
	@GeneratedValue(generator = "emp_sequence")
	private int Id;
	private String firstName;
	private String lastName;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
