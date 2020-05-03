package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Cart;
import kg.neobis.onlinestore.entity.User;

public interface CartService {
    Cart create(Cart cart);
    Cart getByUser(User user);
}
