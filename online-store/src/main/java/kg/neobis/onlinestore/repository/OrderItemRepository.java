package kg.neobis.onlinestore.repository;

import kg.neobis.onlinestore.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findAllByOrder_User_Login(String userLogin);
}
