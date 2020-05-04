package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.PaymentMethod;
import kg.neobis.onlinestore.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment_method")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping
    public PaymentMethod create(@RequestBody PaymentMethod paymentMethod){
        return paymentMethodService.create(paymentMethod);
    }

    @GetMapping("/{id}")
    public PaymentMethod getById(@PathVariable Long id){
        return paymentMethodService.getById(id);
    }

    @GetMapping
    public List<PaymentMethod> getAll(){
        return paymentMethodService.getAll();
    }

    @DeleteMapping("/{id}")
    public PaymentMethod deleteById(@PathVariable Long id){
        return paymentMethodService.deleteById(id);
    }



}
