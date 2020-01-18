package com.perfeto.model;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String empNo;
    private String empName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    static long counter = 0;

    public String getAuthorName() {
        return (author != null) ? author.getUsername() : "<none>";
    }

    public Employee() {

    }

    public Employee(Long empId, String empNo,
            String empName) {
        this.empId = empId;
        this.empNo = empNo;
        this.empName = empName;
        counter++;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", author=" + author +
                '}';
    }
}