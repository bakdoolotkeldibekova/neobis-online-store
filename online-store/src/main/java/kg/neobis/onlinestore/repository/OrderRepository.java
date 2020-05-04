package kg.neobis.onlinestore.repository;

import kg.neobis.onlinestore.entity.Order;
import kg.neobis.onlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByUser_Login(String userLogin);
}
