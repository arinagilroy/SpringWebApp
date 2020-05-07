package com.perfeto.controller.var13;

import com.perfeto.dao.var13.ManufacturerCompanyRepository;
import com.perfeto.dao.var13.NetworkComponentRepository;
import com.perfeto.dao.var13.SupplierCompanyRepository;
import com.perfeto.exceptions.NotFoundException;
import com.perfeto.model.var13.ManufacturerCompany;
import com.perfeto.model.var13.NetworkComponent;
import com.perfeto.model.var13.SupplierCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("networkComponent")
public class NetworkComponentController {

    @Autowired
    private NetworkComponentRepository networkComponentRepository;
    @Autowired
    private SupplierCompanyRepository supplierCompanyRepository;
    @Autowired
    private ManufacturerCompanyRepository manufacturerCompanyRepository;


    @GetMapping("/netComponents")
    @ResponseBody
    public List<NetworkComponent> getAllNetworkComponent() {
        return (List<NetworkComponent>) networkComponentRepository.findAll();
    }

    @GetMapping("/supplComp")
    @ResponseBody
    public List<SupplierCompany> getAllSupplierCompany() {
        return (List<SupplierCompany>) supplierCompanyRepository.findAll();
    }

    @GetMapping("/manufactCompany")
    @ResponseBody
    public List<ManufacturerCompany> getAllManufacturerCompany() {
        return (List<ManufacturerCompany>) manufacturerCompanyRepository.findAll();
    }

    //==================================================================================================================

    @GetMapping("/searchNetComponents")
    @ResponseBody
    public NetworkComponent searchNetComponents(@RequestParam Long id) {
        return networkComponentRepository.findById(id).get();
    }


    @GetMapping("/searchSupplComp")
    @ResponseBody
    public SupplierCompany searchSupplComp(@RequestParam Long id) {
        return supplierCompanyRepository.findById(id).get();
    }


    @GetMapping("/searchManufactCompany")
    @ResponseBody
    public ManufacturerCompany searchManufactCompany(@RequestParam Long id) {
        return manufacturerCompanyRepository.findById(id).get();
    }


    //==================================================================================================================


    @PostMapping("/netComponents")
    @ResponseBody
    public List<NetworkComponent> addNetworkComponent(@RequestBody NetworkComponent networkComponent,
                                                      @RequestParam Long supplId,
                                                      @RequestParam Long manufactId) {

        networkComponent.setSupplierCompany(supplierCompanyRepository.findById(supplId).get());
        networkComponent.setManufacturerCompany(manufacturerCompanyRepository.findById(manufactId).get());
        networkComponentRepository.save(networkComponent);
        return (List<NetworkComponent>) networkComponentRepository.findAll();
    }

    @PostMapping("/supplComp")
    @ResponseBody
    public List<SupplierCompany> addSupplierCompany(@RequestBody SupplierCompany supplierCompany) {
        supplierCompanyRepository.save(supplierCompany);
        return (List<SupplierCompany>) supplierCompanyRepository.findAll();
    }

    @PostMapping("/manufactCompany")
    @ResponseBody
    public List<ManufacturerCompany> addManufacturerCompany(@RequestBody ManufacturerCompany manufacturerCompany) {
        manufacturerCompanyRepository.save(manufacturerCompany);
        return (List<ManufacturerCompany>) manufacturerCompanyRepository.findAll();
    }

    //==================================================================================================================

    @DeleteMapping("/netComponents")
    @ResponseBody
    public List<NetworkComponent> deleteNetComponent(@RequestParam Long id) throws NotFoundException {
        NetworkComponent networkComponent = networkComponentRepository.findById(id).get();
        if (networkComponent != null) {
            networkComponentRepository.deleteById(id);
        } else {
            throw new NotFoundException();
        }
        return (List<NetworkComponent>) networkComponentRepository.findAll();
    }

    @DeleteMapping("/supplComp")
    @ResponseBody
    public List<SupplierCompany> deleteSupplierCompany(@RequestParam Long id) throws NotFoundException {
        SupplierCompany supplierCompany = supplierCompanyRepository.findById(id).get();
        if (supplierCompany != null) {
            supplierCompanyRepository.deleteById(id);
        } else {
            throw new NotFoundException();
        }
        return (List<SupplierCompany>) supplierCompanyRepository.findAll();
    }

    @DeleteMapping("/manufactCompany")
    @ResponseBody
    public List<ManufacturerCompany> deleteManufacturerCompany(@RequestParam Long id) throws NotFoundException {
        ManufacturerCompany manufacturerCompany = manufacturerCompanyRepository.findById(id).get();
        if (manufacturerCompany != null) {
            manufacturerCompanyRepository.deleteById(id);
        } else {
            throw new NotFoundException();
        }
        return (List<ManufacturerCompany>) manufacturerCompanyRepository.findAll();
    }
    //==================================================================================================================

    @PutMapping("/netComponents")
    @ResponseBody
    public List<NetworkComponent> putNetworkComponent(@RequestBody NetworkComponent networkComponent,
                                                      @RequestParam Long supplId,
                                                      @RequestParam Long manufactId) throws Exception {
        NetworkComponent networkComponent1 = networkComponentRepository.findById(networkComponent.getId()).get();
        if (networkComponent.getId() == null) {
            throw new Exception("network component must have id here!");
        }
        if (supplId != -1) {
            SupplierCompany supplierCompany = supplierCompanyRepository.findById(supplId).get();
            if (supplierCompany != null) {
                networkComponent.setSupplierCompany(supplierCompany);
            }
        } else {
            networkComponent.setManufacturerCompany(networkComponent1.getManufacturerCompany());
        }
        if (manufactId != -1) {
            ManufacturerCompany manufacturerCompany = manufacturerCompanyRepository.findById(manufactId).get();
            if (manufacturerCompany != null) {
                networkComponent.setManufacturerCompany(manufacturerCompany);
            }
        } else {
            networkComponent.setSupplierCompany(networkComponent1.getSupplierCompany());
        }
        return (List<NetworkComponent>) networkComponentRepository.findAll();
    }

    @PutMapping("/supplComp")
    @ResponseBody
    public List<SupplierCompany> putSupplierCompany(@RequestBody SupplierCompany supplierCompany) throws Exception {
        if (supplierCompany.getId() == null) {
            throw new Exception("supplier company must have id here!");
        }
        supplierCompanyRepository.save(supplierCompany);
        return (List<SupplierCompany>) supplierCompanyRepository.findAll();
    }

    @PutMapping("/manufactCompany")
    @ResponseBody
    public List<ManufacturerCompany> putManufacturerCompany(@RequestBody ManufacturerCompany manufacturerCompany) throws Exception {
        if (manufacturerCompany.getId() == null) {
            throw new Exception("manufacturer company must have id here!");
        }
        manufacturerCompanyRepository.save(manufacturerCompany);
        return (List<ManufacturerCompany>) manufacturerCompanyRepository.findAll();
    }
}
