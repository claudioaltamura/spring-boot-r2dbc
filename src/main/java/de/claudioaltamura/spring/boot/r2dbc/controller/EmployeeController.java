package de.claudioaltamura.spring.boot.r2dbc.controller;

import de.claudioaltamura.spring.boot.r2dbc.model.Employee;
import de.claudioaltamura.spring.boot.r2dbc.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping(path = "/employees")
    public Mono<ResponseEntity<List<Employee>>> getEmployees() {
        return employeeRepository.findAll()
                .collectList()
                .map(employees -> new ResponseEntity(employees, HttpStatus.OK));
    }

    @PostMapping(path = "/employees")
    public Mono<ResponseEntity<Employee>> createEmployee(@RequestBody @Valid Mono<Employee> newEmployee) {
        return newEmployee.flatMap(employeeRepository::save)
                .map(employee -> new ResponseEntity(employee, HttpStatus.CREATED));
    }

}
