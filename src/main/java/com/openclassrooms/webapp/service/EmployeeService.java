package com.openclassrooms.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.webapp.model.Employee;
import com.openclassrooms.webapp.repository.EmployeeClient;

import lombok.Data;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeClient EmployeeClient;

    public Employee getEmployee(final int id) {
        return EmployeeClient.getEmployee(id);
    }

    public Iterable<Employee> getEmployees() {
        return EmployeeClient.getEmployees();
    }

    public void deleteEmployee(final int id) {
        EmployeeClient.deleteEmployee(id);;
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        employee.setLastName(employee.getLastName().toUpperCase());

        if(employee.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedEmployee = EmployeeClient.createEmployee(employee);
        } else {
            savedEmployee = EmployeeClient.updateEmployee(employee);
        }
    
        return savedEmployee;
    }

}