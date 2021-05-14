package com.tts.SpringBoot.Project.repository;

import com.tts.SpringBoot.Project.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
