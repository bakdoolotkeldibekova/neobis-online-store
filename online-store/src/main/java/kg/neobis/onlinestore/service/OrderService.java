package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Order;
import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.model.OrderModel;

public interface OrderService {
    Order create(Order order);
    Order getByUserLogin(String userLogin);
    Order update(OrderModel orderModel, String userLogin);
    Order orderDelivered(Order order);
}
