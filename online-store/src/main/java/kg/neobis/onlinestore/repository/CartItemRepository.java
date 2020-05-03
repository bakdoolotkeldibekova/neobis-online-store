package kg.neobis.onlinestore.repository;

import kg.neobis.onlinestore.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem>  findAllByCart_User_Login(String userLogin);
}
