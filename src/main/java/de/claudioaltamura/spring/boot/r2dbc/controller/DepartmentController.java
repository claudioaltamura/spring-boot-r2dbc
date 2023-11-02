package de.claudioaltamura.spring.boot.r2dbc.controller;

import de.claudioaltamura.spring.boot.r2dbc.model.Department;
import de.claudioaltamura.spring.boot.r2dbc.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    @GetMapping(path = "/departments")
    public Mono<ResponseEntity<List<Department>>> getDepartments() {
        return departmentRepository.findAll()
                .collectList()
                .map(departments -> new ResponseEntity(departments, HttpStatus.OK));
    }

}
