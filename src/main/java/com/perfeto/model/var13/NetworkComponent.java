package com.perfeto.model.var13;



import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "netComponents")
public class NetworkComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "net_comp_id")
    private Long Id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufact_id")
    @Nullable
    private ManufacturerCompany manufacturerCompany;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supl_id")
    @Nullable
    private SupplierCompany supplierCompany;
    private String name;
    private Long price;
    private String networkArchitecture;
    private String topology;
    private String deliveryTime;

    public NetworkComponent() {
    }

    public NetworkComponent(ManufacturerCompany manufacturerCompany,
                            SupplierCompany supplierCompany,
                            String name,
                            Long price,
                            String networkArchitecture,
                            String topology,
                            String deliveryTime) {
        this.manufacturerCompany = manufacturerCompany;
        this.supplierCompany = supplierCompany;
        this.name = name;
        this.price = price;
        this.networkArchitecture = networkArchitecture;
        this.topology = topology;
        this.deliveryTime = deliveryTime;
    }

    public NetworkComponent(String name,
                            Long price,
                            String networkArchitecture,
                            String topology,
                            String deliveryTime) {
        this.name = name;
        this.price = price;
        this.networkArchitecture = networkArchitecture;
        this.topology = topology;
        this.deliveryTime = deliveryTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public ManufacturerCompany getManufacturerCompany() {
        return manufacturerCompany;
    }

    public void setManufacturerCompany(ManufacturerCompany manufacturerCompany) {
        this.manufacturerCompany = manufacturerCompany;
    }

    public SupplierCompany getSupplierCompany() {
        return supplierCompany;
    }

    public void setSupplierCompany(SupplierCompany supplierCompany) {
        this.supplierCompany = supplierCompany;
    }

    public String getName() {
        if (name == null){
            return "null";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getNetworkArchitecture() {
        return networkArchitecture;
    }

    public void setNetworkArchitecture(String networkArchitecture) {
        this.networkArchitecture = networkArchitecture;
    }

    public String getTopology() {
        return topology;
    }

    public void setTopology(String topology) {
        this.topology = topology;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
