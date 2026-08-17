package com.bridgelabz.EmployeeManagementSystem.service;

import com.bridgelabz.EmployeeManagementSystem.exception.IdNotFoundException;
import com.bridgelabz.EmployeeManagementSystem.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

//Employee service interface.
public interface EmployeeService {
    public String addemployee(Employee employee);
    public Employee getemployee(Long id) throws IdNotFoundException;
    public List<Employee> getemployees();
    public Employee update(Long id,Employee employee) throws IdNotFoundException;
    public void delete(Long id)throws IdNotFoundException;
}
