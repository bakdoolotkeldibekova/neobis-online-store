package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.OrderItem;
import kg.neobis.onlinestore.model.OrderItemModel;

import java.util.List;

public interface OrderItemService {
    OrderItem create(OrderItemModel orderItemModel, String userLogin);
    OrderItem deleteById(Long id, String userLogin);
    OrderItem getById(Long id, String userLogin);
    List<OrderItem> getAllMy(String userLogin);
}
