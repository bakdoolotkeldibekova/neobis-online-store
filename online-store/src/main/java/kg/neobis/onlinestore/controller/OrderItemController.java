package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.OrderItem;
import kg.neobis.onlinestore.model.OrderItemModel;
import kg.neobis.onlinestore.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/order_item")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public OrderItem create(@RequestBody OrderItemModel orderItemModel, Principal principal){
        return orderItemService.create(orderItemModel, principal.getName());
    }

    @GetMapping("/{id}")
    public OrderItem getById(@PathVariable Long id, Principal principal){
        return orderItemService.getById(id, principal.getName());
    }

    @GetMapping
    public List<OrderItem> getAllMy(Principal principal){
        return orderItemService.getAllMy(principal.getName());
    }

    @DeleteMapping("/{id}")
    public OrderItem deleteById(@PathVariable Long id, Principal  principal){
        return orderItemService.deleteById(id, principal.getName());
    }

}
