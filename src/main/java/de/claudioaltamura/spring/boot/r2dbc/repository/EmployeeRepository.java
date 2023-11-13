package de.claudioaltamura.spring.boot.r2dbc.repository;

import de.claudioaltamura.spring.boot.r2dbc.model.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, UUID> {

    @Query("select id, first_name, last_name from employee where first_name = $1")
    Flux<Employee> findByName(String name);
}
