package com.perfeto.model.var13;

import javax.persistence.*;

@Entity
@Table(name = "manufactCompany")
public class ManufacturerCompany {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String phone;

    public ManufacturerCompany() {
    }

    public ManufacturerCompany(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
