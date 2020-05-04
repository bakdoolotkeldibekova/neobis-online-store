package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.CartItem;
import kg.neobis.onlinestore.model.CartItemModel;
import kg.neobis.onlinestore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/cart_item")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public CartItem create(@RequestBody CartItemModel cartItemModel, Principal principal){ //только после регистрации
        return cartItemService.create(cartItemModel, principal.getName());
    }

    @DeleteMapping("/{id}")
    public CartItem deleteById(@PathVariable Long id, Principal principal){ //только после регистрации
        return cartItemService.deleteById(id, principal.getName());
    }

    @GetMapping("/{id}")
    public CartItem getById(@PathVariable Long id, Principal principal){ //только после регистрации
        return cartItemService.getById(id, principal.getName());
    }

    @GetMapping //get all items in user's cart
    public List<CartItem> getAllMy(Principal principal){ //только после регистрации
        return cartItemService.getAllMy(principal.getName());
    }


}
