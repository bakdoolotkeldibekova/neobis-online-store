package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.Order;
import kg.neobis.onlinestore.model.OrderModel;
import kg.neobis.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PutMapping("/create")
    public Order createOrder(@RequestBody OrderModel orderModel, Principal principal){
        return orderService.update(orderModel, principal.getName());
    }

    @PutMapping("/delivered")
    public Order orderDelivered(@RequestBody Order order){ //admin
        return orderService.orderDelivered(order);
    }

}
