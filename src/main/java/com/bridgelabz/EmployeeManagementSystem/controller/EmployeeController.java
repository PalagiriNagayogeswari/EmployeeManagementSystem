package com.bridgelabz.EmployeeManagementSystem.controller;


import com.bridgelabz.EmployeeManagementSystem.EmployeeManagementSystemApplication;
import com.bridgelabz.EmployeeManagementSystem.exception.IdNotFoundException;
import com.bridgelabz.EmployeeManagementSystem.model.Employee;
import com.bridgelabz.EmployeeManagementSystem.service.EmployeeService;
import com.bridgelabz.EmployeeManagementSystem.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller containing all the end points
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    //Post mapping to add an employee
    @PostMapping("/employees")
    public ResponseEntity<String> addemployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeServiceImpl.addemployee(employee), HttpStatus.CREATED);
    }


    //Get mapping to get employee with id.
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getemployee(@PathVariable("id") Long id)throws IdNotFoundException{
            return new ResponseEntity<>(employeeServiceImpl.getemployee(id),HttpStatus.OK);
    }

    //Get mapping to get all the employees
    @GetMapping("/employees")
    public List<Employee> getemployees(){
        return employeeServiceImpl.getemployees();
    }

    //Put mapping to change the employee details based on id.
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id")Long id,@Valid @RequestBody  Employee employee)throws IdNotFoundException{
        return new ResponseEntity<>(employeeServiceImpl.update(id,employee),HttpStatus.OK);
    }


    //Delete mapping to delete employee based on Id.
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Long id)throws IdNotFoundException{
       employeeServiceImpl.delete(id);
       return ResponseEntity.noContent().build();
    }
}
