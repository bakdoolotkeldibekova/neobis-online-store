package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Cart;
import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getByUser(User user) {
        return cartRepository.findByUser(user);
    }
}
