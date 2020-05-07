package com.perfeto.model.var13;

import javax.persistence.*;

@Entity
@Table(name = "supplierCompany")
public class SupplierCompany {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String phone;
    private Long deliverPrice;

    public SupplierCompany() {
    }

    public SupplierCompany(String address, String phone, Long deliverPrice) {
        this.address = address;
        this.phone = phone;
        this.deliverPrice = deliverPrice;
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

    public Long getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(Long deliverPrice) {
        this.deliverPrice = deliverPrice;
    }
}