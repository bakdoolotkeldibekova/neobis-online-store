package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.Address;
import kg.neobis.onlinestore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address") // localhost:8080/address
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id){
        return addressService.getById(id);
    }

    @GetMapping
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @PostMapping
    public Address create(@RequestBody Address address){
        return addressService.create(address);
    }

    @PutMapping
    public Address update(@RequestBody Address address){
        return addressService.update(address);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        addressService.deleteById(id);
    }

}
