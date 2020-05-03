package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.Address;
import kg.neobis.onlinestore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    public AddressService addressService;

    @PostMapping
    public Address create(@RequestBody Address address){
        return addressService.create(address);
    }

    @GetMapping
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id){
        return addressService.getById(id);
    }
}
