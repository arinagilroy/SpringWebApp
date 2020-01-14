package com.perfeto.controller;

import com.perfeto.dao.EmployeeDAOArray;
import com.perfeto.dao.EmployeeRepository;
import com.perfeto.exceptions.CantRequestBodyException;
import com.perfeto.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

//    @Autowired
//    private EmployeeDAOArray employeeDAOArray;

    @Autowired
    private EmployeeRepository employeeRepository;


//    @GetMapping
//    public String getAllEmployee(Model model) {
//
//        List<Employee> employees = employeeDAOArray.getEmployees();
//        model.addAttribute("employees", employees);
//        return "employee";
//    }
//
//    @GetMapping("{empId}")
//    public String getAllEmployeeById(Model model, @PathVariable Long empId) {
//        List<Employee> employees = employeeDAOArray.getEmployees();
//        model.addAttribute("employees", employeeDAOArray.getEmployeeById(empId, employees));
//        return "employee";
//    }
//
//    @GetMapping("/search")
//    public ModelAndView index(Model model, @RequestParam Long empId) {
//
//        List<Employee> employees = employeeDAOArray.getEmployees();
//        model.addAttribute("employees", employeeDAOArray.getEmployeeById(empId, employees));
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("employee");
//        return modelAndView;
//    }
//
    @PostMapping
    @ResponseBody
    public /*List<Employee>*/ void addEmployee(@RequestBody Employee employee) {
        if (employee.getEmpNo() == null || employee.getEmpName() == null){
            throw new CantRequestBodyException();
        } else {
            //employeeDAOArray.addEmployee(employee.getEmpNo(), employee.getEmpName());
            employeeRepository.save(employee);
            //return employeeDAOArray.getEmployees();
        }
    }
//
//    @DeleteMapping("{empId}")
//    public void deleteEmployee(@PathVariable Long empId) {
//        List<Employee> employees = employeeDAOArray.getEmployees();
//        employees.remove(employeeDAOArray.getEmployeeById(empId, employees));
//    }
//
//    @PutMapping("{empId}")
//    public String putEmployee(Model model, @PathVariable Long empId, @RequestBody Employee employee) {
//        List<Employee> employees = employeeDAOArray.getEmployees();
//        employeeDAOArray.updateEmployee(empId, employee);
//        model.addAttribute("employees", employees);
//        return "employee";
//    }
}
