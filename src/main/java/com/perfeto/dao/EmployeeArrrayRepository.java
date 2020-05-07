//package com.perfeto.dao;
//
//import com.perfeto.exceptions.NotFoundException;
//import com.perfeto.model.Employee;
//import com.perfeto.model.User;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class EmployeeArrrayRepository {
//
//    public EmployeeArrrayRepository() {
//    }
//
//    public void fillTest() {
//        employeeList.add(new Employee(0L,"Front-end dev", "NikitOS"));
//        employeeList.add(new Employee(1L,"Back-end dev", "Perfeto"));
//    }
//
//    private List<Employee> employeeList = new ArrayList<>(Arrays.asList(new Employee("Front-end dev", "NikitOS"), new Employee("Back-end dev", "Perfeto")));
//
//    public Iterable<Employee> findAll(){
//        return (Iterable<Employee>) employeeList;
//    }
//
//    public List<Employee> findByEmpId(Long empId){
//        List<Employee> employeesToReturn = (List<Employee>) employeeList.stream().filter(employee -> employee.getEmpId() == empId).collect(Collectors.toList());
//        if (employeesToReturn.size() == 0)
//            throw new NotFoundException();
//        else
//        return employeesToReturn;
//    }
//
//    public void save(Employee employee) {
//        if (! employeeList.stream().filter(employee1 -> employee1.getEmpId() == employee.getEmpId()).collect(Collectors.toList()).isEmpty()) {
//            employeeList.set(employeeList.indexOf(employeeList.stream().filter(employee1 -> employee1.getEmpId() == employee.getEmpId()).collect(Collectors.toList()).get(0)), new Employee(employeeList.stream().filter(employee1 -> employee1.getEmpId() == employee.getEmpId()).collect(Collectors.toList()).get(0).getEmpId(), employee.getEmpNo(), employee.getEmpName()));
//        } else {
//            employeeList.add(new Employee(employee.getEmpNo(), employee.getEmpName()));
//        }
//    }
//
//    public void deleteById(Long empId) {
//        employeeList.remove(employeeList.stream().filter(employee -> employee.getEmpId() == empId).findFirst().get());
//    }
//}
