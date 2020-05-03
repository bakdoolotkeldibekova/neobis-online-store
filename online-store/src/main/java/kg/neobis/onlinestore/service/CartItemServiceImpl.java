package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Cart;
import kg.neobis.onlinestore.entity.CartItem;
import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.model.CartItemModel;
import kg.neobis.onlinestore.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

    @Override
    public CartItem create(CartItemModel cartItemModel, String userLogin) {
        User user = userService.getByLogin(userLogin);
        CartItem cartItem = new CartItem();
        if(user != null){
            Cart cart = cartService.getByUser(user);
            cartItem.setCart(cart);
            cartItem.setProduct(cartItemModel.getProduct());
            cartItem.setProductQuantity(cartItemModel.getProductQuantity());
            cartItem.setDateCreated(LocalDateTime.now());
            cartItemRepository.save(cartItem);
        }
        return cartItem;
    }

    @Override
    public CartItem deleteById(Long id, String userLogin) {
        CartItem cartItem = getById(id, userLogin);
        cartItemRepository.deleteById(id);
        return cartItem;
    }

    @Override
    public CartItem getById(Long id, String userLogin) {
        CartItem cartItem = cartItemRepository.findById(id).orElse(null);
        if(cartItem != null){
            User user = cartItem.getCart().getUser();
            if(user.getLogin().equals(userLogin)){
                return cartItem;
            }
        }
        return null;
    }

    @Override
    public List<CartItem> getAllMy(String userLogin) {
        return cartItemRepository.findAllByCart_User_Login(userLogin);
    }
}
