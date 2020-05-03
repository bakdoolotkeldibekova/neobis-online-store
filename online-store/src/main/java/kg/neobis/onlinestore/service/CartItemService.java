package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.CartItem;
import kg.neobis.onlinestore.model.CartItemModel;

import java.util.List;

public interface CartItemService {
    CartItem create(CartItemModel cartItemModel, String userLogin);
    CartItem deleteById(Long id, String userLogin);
    CartItem getById(Long id, String userLogin);
    List<CartItem> getAllMy(String userLogin);
}
