package de.claudioaltamura.spring.boot.r2dbc.repository;

import de.claudioaltamura.spring.boot.r2dbc.entity.Department;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface DepartmentRepository extends ReactiveCrudRepository<Department, UUID> {

}
