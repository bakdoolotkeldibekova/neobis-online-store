package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Order;
import kg.neobis.onlinestore.entity.OrderItem;
import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.model.OrderModel;
import kg.neobis.onlinestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private MailService mailService;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getByUserLogin(String userLogin) {
        return orderRepository.findByUser_Login(userLogin);
    }

    @Override
    public Order update(OrderModel orderModel, String userLogin) {
        User user = userService.getByLogin(userLogin);
        if(user != null){
            Order order = getByUserLogin(user.getLogin());
            order.setPaymentMethod(orderModel.getPaymentMethod());
            order.setShippingMethod(orderModel.getShippingMethod());
            order.setStatus("active");
            List<OrderItem> orderItemList = orderItemService.getAllMy(userLogin);
            Integer amount=0;
            for(OrderItem o : orderItemList){
                amount += (o.getProductQuantity()*o.getProduct().getPrice());
            }
            order.setAmount(amount);
            String text = "Dear, " + userLogin  + ", your order is successfully placed."
                    + "\n\n Regards, online-store project (:";
            System.out.println(mailService.send(user.getEmail(), "online-store", text));
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order orderDelivered(Order order) {
        order.setStatus("delivered");
        return order;
    }
}
