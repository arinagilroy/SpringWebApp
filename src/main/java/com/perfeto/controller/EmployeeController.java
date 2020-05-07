//package com.perfeto.controller;
//
//import com.perfeto.dao.EmployeeRepository;
//import com.perfeto.exceptions.NotFoundException;
//import com.perfeto.model.Employee;
//import com.perfeto.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("employee")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//
//    @GetMapping
//    @ResponseBody
//    public List<Employee> getAllEmployee(Model model) {
//        List<Employee> employees = new ArrayList<>();
//        employeeRepository.findAll().forEach(employees::add);
//        return employees;
//    }
//
//    @GetMapping("{empId}")
//    @ResponseBody
//    public Employee getAllEmployeeById(Model model, @PathVariable Long empId) {
//        return employeeRepository.findByEmpId(empId);
//    }
//
//    @GetMapping("/search")
//    @ResponseBody
//    public Employee index(@RequestParam Long empId) {
//        return employeeRepository.findByEmpId(empId);
//    }
//
//    @PostMapping
//    @ResponseBody
//    public List<Employee> addEmployee(@AuthenticationPrincipal User user, @RequestBody Employee employee) {//(@AuthenticationPrincipal User user, @RequestBody Employee employee)
//        employee.setAuthor(user);
//        employeeRepository.save(employee);
//        return (List<Employee>) employeeRepository.findAll();
//    }
//
//    @DeleteMapping("{empId}")
//    @ResponseBody
//    public List<Employee> deleteEmployee(@PathVariable Long empId) throws NotFoundException {
//        Employee employee =  employeeRepository.findByEmpId(empId);
//        if (employee != null){
//            employeeRepository.deleteById(empId);
//        } else {
//            throw new NotFoundException();
//        }
//        return (List<Employee>) employeeRepository.findAll();
//    }
//
//    @PutMapping
//    @ResponseBody
//    public List<Employee> putEmployee(@RequestBody Employee employee) {
//        Employee employee1 = employeeRepository.findByEmpId(employee.getEmpId());
//        employee1.setAuthor(employee.getAuthor());
//        employee1.setEmpNo(employee.getEmpNo());
//        employee1.setEmpName(employee.getEmpName());
//        employeeRepository.save(employee1);
//        return (List<Employee>) employeeRepository.findAll();
//    }
//}
