package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.Order;
import kg.neobis.onlinestore.model.OrderModel;
import kg.neobis.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping
    public Order getByUserLogin(@RequestBody String login){
        return orderService.getByUserLogin(login);
    }

    @GetMapping("/date")
    public List<Order> getAllByDateTimeCreatedBetween(@RequestParam(name = "a") LocalDateTime a, @RequestParam(name = "b") LocalDateTime b){
        return orderService.getAllByDateTimeCreatedBetween(a, b);
    }

    @GetMapping("/status")
    public List<Order> getAllByStatus(@RequestParam(name = "status") String status){
        return orderService.getAllByStatus(status);
    }

    @GetMapping("/amount")
    public List<Order> getAllByAmountBetween(@RequestParam(name = "a") Integer a, @RequestParam(name = "b") Integer b){
        return orderService.getAllByAmountBetween(a, b);
    }

    @GetMapping("/paymentAndDate")
    public List<Order> getAllByPaymentMethodAndDateTimeCreatedAfter(@RequestParam(name = "method") String method,
                                                                    @RequestParam(name = "dateTime") LocalDateTime dateTime) {
        return orderService.getAllByPaymentMethodAndDateTimeCreatedAfter(method, dateTime);
    }
}
