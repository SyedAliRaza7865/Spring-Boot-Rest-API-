
package com.kiet.springboot2.Controller;

import com.kiet.springboot2.Model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>();

    // (b) Add employee
    @PostMapping
    public ResponseEntity<?> addEmployee(
            @RequestBody Employee employee) {

        for (Employee e : employees) {
            if (e.getId() == employee.getId()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Employee ID already exists");
            }
        }

        employees.add(employee);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employee);
    }

    // (c) Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // (c) Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(
            @PathVariable int id) {

        for (Employee e : employees) {
            if (e.getId() == id) {
                return ResponseEntity.ok(e);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Employee not found");
    }

    // (d) Update employee
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee updatedEmployee) {

        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setName(updatedEmployee.getName());
                e.setDepartment(updatedEmployee.getDepartment());
                e.setSalary(updatedEmployee.getSalary());

                return ResponseEntity.ok(e);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Employee not found");
    }

    // (e) Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable int id) {

        for (Employee e : employees) {
            if (e.getId() == id) {
                employees.remove(e);

                return ResponseEntity.ok(
                        "Employee deleted successfully");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Employee not found");
    }
}
