package com.bridgelabz.EmployeeManagementSystem.service;

import com.bridgelabz.EmployeeManagementSystem.exception.IdNotFoundException;
import com.bridgelabz.EmployeeManagementSystem.model.Employee;
import com.bridgelabz.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;



//service interface implementation.
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //method to add employeee
    @Override
    public String addemployee(Employee employee){
        employeeRepository.save(employee);
        return "Employee saved successfully";
    }

    //method to get employee based on id
    @Override
    public Employee getemployee(Long id) throws IdNotFoundException{
            return employeeRepository.findById(id).orElseThrow(()->
                    new IdNotFoundException("Employee Not Found"));
    }

    //method to get all employees
    @Override
    public List<Employee> getemployees(){
        return employeeRepository.findAll();
    }

    //method to update the employee based on id.
    @Override
    public Employee update(Long id,Employee employee)throws IdNotFoundException{
        Employee e1=employeeRepository.findById(id).orElseThrow(()->
                new IdNotFoundException("Id Not Found"));
        e1.setName(employee.getName());
        e1.setEmail(employee.getEmail());
        e1.setDepartment(employee.getDepartment());
        e1.setSalary(employee.getSalary());
        employeeRepository.save(e1);
        return e1;
    }

    //method to delete employee based on id.
    @Override
    public void delete(Long id) throws IdNotFoundException{
        if(!employeeRepository.existsById(id)){
            throw  new IdNotFoundException("Id Not Found");
        }
        employeeRepository.deleteById(id);
    }
}
