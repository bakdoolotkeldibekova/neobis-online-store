package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Order;
import kg.neobis.onlinestore.model.OrderModel;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    Order create(Order order);
    Order getByUserLogin(String userLogin);
    Order update(OrderModel orderModel, String userLogin);
    Order orderDelivered(Order order);

    List<Order> getAllByDateTimeCreatedBetween(LocalDateTime a, LocalDateTime b);
    List<Order> getAllByStatus(String status);
    List<Order> getAllByAmountBetween(Integer a, Integer b);
    List<Order> getAllByPaymentMethodAndDateTimeCreatedAfter(String method, LocalDateTime dateTime);
}
