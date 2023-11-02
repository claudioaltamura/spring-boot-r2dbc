package de.claudioaltamura.spring.boot.r2dbc.repository;

import de.claudioaltamura.spring.boot.r2dbc.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, UUID> {
}
