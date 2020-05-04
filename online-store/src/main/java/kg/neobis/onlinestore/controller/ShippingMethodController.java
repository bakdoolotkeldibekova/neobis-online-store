package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.ShippingMethod;
import kg.neobis.onlinestore.service.ShippingMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipping_method")
public class ShippingMethodController {
    @Autowired
    private ShippingMethodService shippingMethodService;

    @PostMapping
    public ShippingMethod create(@RequestBody ShippingMethod shippingMethod){
        return shippingMethodService.create(shippingMethod);
    }

    @GetMapping
    public List<ShippingMethod> getAll(){
        return shippingMethodService.getAll();
    }

    @GetMapping("/{id}")
    public ShippingMethod getById(@PathVariable Long id){
        return shippingMethodService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ShippingMethod deleteById(@PathVariable Long id){
        return shippingMethodService.deleteById(id);
    }
}
