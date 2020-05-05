package kg.neobis.onlinestore.repository;

import kg.neobis.onlinestore.entity.Order;
import kg.neobis.onlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByUser_Login(String userLogin);
    List<Order> findAllByDateCreatedBetween(LocalDateTime a, LocalDateTime b);
    List<Order> findAllByStatusIgnoringCase(String status);
    List<Order> findAllByAmountBetween(Integer a, Integer b);
    List<Order> findAllByPaymentMethod_MethodContainingIgnoringCaseAndDateCreatedAfter(String method, LocalDateTime dateTime);

}
