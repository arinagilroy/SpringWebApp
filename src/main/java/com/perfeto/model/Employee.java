package com.perfeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String empNo;
    private String empName;

    static long counter = 0;

    public Employee() {
 
    }
 
    public Employee(Long empId, String empNo,
            String empName) {
        this.empId = empId;
        this.empNo = empNo;
        this.empName = empName;
        counter++;
    }

    public Employee(String empNo,
            String empName) {
        this.empId = counter++;
        this.empNo = empNo;
        this.empName = empName;

    }
 
    public Long getEmpId() {
        return empId;
    }
 
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
 
    public String getEmpNo() {
        return empNo;
    }
 
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
 
    public String getEmpName() {
        return empName;
    }
 
    public void setEmpName(String empName) {
        this.empName = empName;
    }
}