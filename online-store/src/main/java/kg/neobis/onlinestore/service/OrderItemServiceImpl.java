package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Order;
import kg.neobis.onlinestore.entity.OrderItem;
import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.model.OrderItemModel;
import kg.neobis.onlinestore.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @Override
    public OrderItem create(OrderItemModel orderItemModel, String userLogin) {
        User user = userService.getByLogin(userLogin);
        OrderItem orderItem = new OrderItem();
        if(user != null){
            Order order = orderService.getByUserLogin(userLogin);
            orderItem.setProduct(orderItemModel.getProduct());
            orderItem.setProductQuantity(orderItemModel.getProductQuantity());
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
        }
        return orderItem;
    }

    @Override
    public OrderItem deleteById(Long id, String userLogin) {
        OrderItem orderItem =  getById(id, userLogin);
        if (orderItem != null){
            orderItemRepository.deleteById(id);
        }
        return orderItem;
    }

    @Override
    public OrderItem getById(Long id, String userLogin) {
        OrderItem orderItem = orderItemRepository.findById(id).orElse(null);
        if(orderItem != null){
            User user = orderItem.getOrder().getUser();
            if (user.getLogin().equals(userLogin)){
                return orderItem;
            }
        }
        return null;
    }

    @Override
    public List<OrderItem> getAllMy(String userLogin) {
        return orderItemRepository.findAllByOrder_User_Login(userLogin);
    }
}
